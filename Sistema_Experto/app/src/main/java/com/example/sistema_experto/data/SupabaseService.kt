package com.example.sistema_experto.data

import com.example.sistema_experto.data.models.*
import io.github.jan.supabase.SupabaseClient
import io.github.jan.supabase.createSupabaseClient
import io.github.jan.supabase.postgrest.Postgrest
import io.github.jan.supabase.postgrest.postgrest
import io.github.jan.supabase.postgrest.from
import io.ktor.client.HttpClient
import io.ktor.client.engine.android.Android
import io.ktor.client.plugins.HttpTimeout
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.Json

// Modelos auxiliares para consultas DISTINCT
@Serializable
data class CategoriaResponse(val categoria: String)

@Serializable
data class SubcategoriaResponse(val subcategoria: String)

class SupabaseService {
    // Cliente HTTP compartido con timeouts configurados
    private val httpClient: HttpClient by lazy {
        HttpClient(Android) {
            install(HttpTimeout) {
                requestTimeoutMillis = 60000 // 60 segundos
                connectTimeoutMillis = 30000 // 30 segundos
                socketTimeoutMillis = 60000 // 60 segundos
            }
            install(ContentNegotiation) {
                json(Json {
                    ignoreUnknownKeys = true
                    isLenient = true
                    encodeDefaults = false
                })
            }
        }
    }
    
    private val client: SupabaseClient by lazy {
        try {
            android.util.Log.d("SupabaseService", "🔄 Inicializando cliente de Supabase...")
            android.util.Log.d("SupabaseService", "URL: ${SupabaseConfig.SUPABASE_URL}")
            
            val client = createSupabaseClient(
                supabaseUrl = SupabaseConfig.SUPABASE_URL,
                supabaseKey = SupabaseConfig.SUPABASE_KEY
            ) {
                // Intentar usar el cliente HTTP personalizado
                try {
                    httpEngine = httpClient.engine
                    android.util.Log.d("SupabaseService", "✅ Cliente HTTP personalizado configurado")
                } catch (e: Exception) {
                    android.util.Log.w("SupabaseService", "⚠️ No se pudo configurar cliente HTTP personalizado: ${e.message}")
                }
                install(Postgrest)
            }
            
            android.util.Log.d("SupabaseService", "✅ Cliente de Supabase inicializado correctamente")
            client
        } catch (e: Exception) {
            android.util.Log.e("SupabaseService", "❌ Error al inicializar cliente de Supabase: ${e.message}", e)
            android.util.Log.e("SupabaseService", "Stack trace: ${e.stackTraceToString()}")
            throw e
        }
    }
    
    private val postgrest: Postgrest by lazy {
        try {
            android.util.Log.d("SupabaseService", "🔄 Accediendo a postgrest...")
            client.postgrest
        } catch (e: Exception) {
            android.util.Log.e("SupabaseService", "❌ Error al acceder a postgrest: ${e.message}", e)
            throw e
        }
    }

    // Obtener todas las categorías (DISTINCT desde enfermedades)
    suspend fun obtenerCategorias(): List<Categoria> {
        return try {
            android.util.Log.d("SupabaseService", "🔄 Intentando obtener categorías desde Supabase...")
            // Obtener todas las enfermedades para extraer categorías únicas
            val enfermedades = postgrest.from(SupabaseConfig.TABLE_ENFERMEDADES)
                .select()
                .decodeList<Enfermedad>()
            
            android.util.Log.d("SupabaseService", "✅ Se obtuvieron ${enfermedades.size} enfermedades")
            
            // Extraer categorías únicas y crear objetos Categoria
            val categorias = enfermedades.map { it.categoria }
                .distinct()
                .map { nombre ->
                    Categoria(
                        nombre = nombre,
                        icono = getIconoPorCategoria(nombre)
                    )
                }
            
            android.util.Log.d("SupabaseService", "✅ Se extrajeron ${categorias.size} categorías únicas: ${categorias.map { it.nombre }}")
            categorias
        } catch (e: Exception) {
            // Log del error para debugging
            android.util.Log.e("SupabaseService", "❌ Error al obtener categorías: ${e.message}", e)
            android.util.Log.e("SupabaseService", "URL: ${SupabaseConfig.SUPABASE_URL}")
            android.util.Log.e("SupabaseService", "Tabla: ${SupabaseConfig.TABLE_ENFERMEDADES}")
            emptyList()
        }
    }

    // Obtener subcategorías relacionadas con una categoría (usando la tabla de relación directa)
    suspend fun obtenerSubcategoriasPorCategoria(categoriaNombre: String): List<Subcategoria> {
        return try {
            android.util.Log.d("SupabaseService", "🔄 Obteniendo subcategorías para categoría: $categoriaNombre")
            
            // Consulta directa y simple a la tabla de relación
            val relaciones = postgrest.from(SupabaseConfig.TABLE_CATEGORIA_SUBCATEGORIA)
                .select {
                    filter {
                        eq("categoria_nombre", categoriaNombre)
                    }
                }
                .decodeList<CategoriaSubcategoria>()
            
            if (relaciones.isEmpty()) {
                android.util.Log.w("SupabaseService", "⚠️ No se encontraron subcategorías para la categoría: $categoriaNombre")
                return emptyList()
            }
            
            // Extraer subcategorías únicas y crear objetos Subcategoria
            val subcategoriasUnicas = relaciones
                .map { it.subcategoriaNombre }
                .distinct()
            
            android.util.Log.d("SupabaseService", "✅ Se encontraron ${subcategoriasUnicas.size} subcategorías únicas: $subcategoriasUnicas")
            
            subcategoriasUnicas.map { nombre ->
                Subcategoria(
                    nombre = nombre,
                    icono = "🔸"
                )
            }
        } catch (e: Exception) {
            android.util.Log.e("SupabaseService", "❌ Error al obtener subcategorías: ${e.message}", e)
            emptyList()
        }
    }

    // Obtener síntomas por subcategoría
    suspend fun obtenerSintomasPorSubcategoria(subcategoriaNombre: String): List<Sintoma> {
        return try {
            postgrest.from(SupabaseConfig.TABLE_SINTOMAS)
                .select {
                    filter {
                        eq("subcategoria", subcategoriaNombre)
                    }
                }
                .decodeList<Sintoma>()
        } catch (e: Exception) {
            emptyList()
        }
    }

    // Obtener síntomas por sus IDs
    suspend fun obtenerSintomasPorIds(sintomaIds: List<String>): List<Sintoma> {
        return try {
            if (sintomaIds.isEmpty()) return emptyList()
            
            val sintomas = mutableListOf<Sintoma>()
            for (sintomaId in sintomaIds) {
                try {
                    val sintoma = postgrest.from(SupabaseConfig.TABLE_SINTOMAS)
                        .select {
                            filter {
                                eq("id", sintomaId)
                            }
                        }
                        .decodeSingle<Sintoma>()
                    sintomas.add(sintoma)
                } catch (e: Exception) {
                    // Continuar con el siguiente síntoma
                }
            }
            sintomas
        } catch (e: Exception) {
            emptyList()
        }
    }

    // Estructura de datos para almacenar información de coincidencias
    data class CoincidenciaEnfermedad(
        val enfermedadId: String,
        val cantidadCoincidencias: Int,
        val sintomasCoincidentes: List<String>
    )

    // Obtener coincidencias por enfermedad con información detallada
    private suspend fun obtenerCoincidenciasPorEnfermedad(sintomaIds: List<String>): List<CoincidenciaEnfermedad> {
        return try {
            if (sintomaIds.isEmpty()) return emptyList()

            // Obtener relaciones enfermedad-síntoma
            val enfermedadSintomas = mutableListOf<EnfermedadSintoma>()
            
            for (sintomaId in sintomaIds) {
                try {
                    val resultados = postgrest.from(SupabaseConfig.TABLE_ENFERMEDAD_SINTOMA)
                        .select {
                            filter {
                                eq("sintoma_id", sintomaId)
                            }
                        }
                        .decodeList<EnfermedadSintoma>()
                    enfermedadSintomas.addAll(resultados)
                } catch (e: Exception) {
                    // Continuar con el siguiente síntoma
                }
            }

            // Agrupamos por enfermedad y contamos coincidencias
            val enfermedadCoincidencias = enfermedadSintomas
                .groupBy { it.enfermedadId }
                .mapValues { (enfermedadId, relaciones) ->
                    CoincidenciaEnfermedad(
                        enfermedadId = enfermedadId,
                        cantidadCoincidencias = relaciones.size,
                        sintomasCoincidentes = relaciones.map { it.sintomaId }
                    )
                }
                .values
                .sortedByDescending { it.cantidadCoincidencias }

            return enfermedadCoincidencias
        } catch (e: Exception) {
            emptyList()
        }
    }

    // Verificar si todos los síntomas seleccionados pertenecen a una enfermedad
    private suspend fun verificarTodosSintomasPertenecen(
        sintomaIds: List<String>,
        enfermedadId: String
    ): Boolean {
        return try {
            for (sintomaId in sintomaIds) {
                val existe = postgrest.from(SupabaseConfig.TABLE_ENFERMEDAD_SINTOMA)
                    .select {
                        filter {
                            eq("enfermedad_id", enfermedadId)
                            eq("sintoma_id", sintomaId)
                        }
                    }
                    .decodeList<EnfermedadSintoma>()
                
                if (existe.isEmpty()) {
                    // Este síntoma no pertenece a la enfermedad
                    return false
                }
            }
            true
        } catch (e: Exception) {
            false
        }
    }

    // Obtener enfermedades que coinciden con los síntomas seleccionados (método legacy, mantenido por compatibilidad)
    suspend fun obtenerEnfermedadesPorSintomas(sintomaIds: List<String>): List<Enfermedad> {
        return try {
            val coincidencias = obtenerCoincidenciasPorEnfermedad(sintomaIds)
            
            if (coincidencias.isEmpty()) {
                return emptyList()
            }

            // Obtenemos los detalles de las enfermedades
            val enfermedades = mutableListOf<Enfermedad>()
            for (coincidencia in coincidencias.take(5)) {
                try {
                    val enfermedad = postgrest.from(SupabaseConfig.TABLE_ENFERMEDADES)
                        .select {
                            filter {
                                eq("id", coincidencia.enfermedadId)
                            }
                        }
                        .decodeSingle<Enfermedad>()
                    enfermedades.add(enfermedad)
                } catch (e: Exception) {
                    // Continuar con la siguiente enfermedad
                }
            }
            enfermedades
        } catch (e: Exception) {
            emptyList()
        }
    }

    // Obtener recomendaciones por enfermedad
    suspend fun obtenerRecomendacionesPorEnfermedad(enfermedadId: String): List<Recomendacion> {
        return try {
            postgrest.from(SupabaseConfig.TABLE_RECOMENDACIONES)
                .select {
                    filter {
                        eq("enfermedad_id", enfermedadId)
                    }
                }
                .decodeList<Recomendacion>()
        } catch (e: Exception) {
            emptyList()
        }
    }

    // Método completo para obtener diagnóstico con reglas del sistema experto
    suspend fun obtenerDiagnostico(
        sintomaIds: List<String>,
        usuarioId: String? = null
    ): DiagnosticoResultado? {
        // REGLA 1: Validar cantidad de síntomas (3-5)
        // Esta regla ya está validada en la UI, pero la verificamos aquí por seguridad
        if (sintomaIds.size < 3 || sintomaIds.size > 5) {
            android.util.Log.w("SupabaseService", "⚠️ Regla 1 violada: Cantidad de síntomas inválida (${sintomaIds.size})")
            return null
        }

        // Obtener los síntomas completos
        val sintomas = sintomaIds.mapNotNull { id ->
            try {
                postgrest.from(SupabaseConfig.TABLE_SINTOMAS)
                    .select {
                        filter { eq("id", id) }
                    }
                    .decodeSingle<Sintoma>()
            } catch (e: Exception) {
                null
            }
        }

        if (sintomas.isEmpty()) {
            android.util.Log.w("SupabaseService", "⚠️ No se pudieron obtener los síntomas")
            return null
        }

        // Obtener coincidencias por enfermedad
        val coincidencias = obtenerCoincidenciasPorEnfermedad(sintomaIds)

        if (coincidencias.isEmpty()) {
            android.util.Log.w("SupabaseService", "⚠️ No se encontraron enfermedades relacionadas con los síntomas")
            return null
        }

        // Encontrar la enfermedad con más síntomas coincidentes
        val enfermedadMasProbable = coincidencias.firstOrNull()

        if (enfermedadMasProbable == null) {
            android.util.Log.w("SupabaseService", "⚠️ No se encontró enfermedad más probable")
            return null
        }

        // REGLA 3: Verificar que haya al menos 3 síntomas de la misma enfermedad
        if (enfermedadMasProbable.cantidadCoincidencias < 3) {
            android.util.Log.w("SupabaseService", "⚠️ Regla 3 violada: Menos de 3 síntomas de la misma enfermedad (${enfermedadMasProbable.cantidadCoincidencias})")
            return null
        }

        // REGLA 2: Verificar que TODOS los síntomas seleccionados pertenezcan a esa enfermedad
        val todosPertenecen = verificarTodosSintomasPertenecen(sintomaIds, enfermedadMasProbable.enfermedadId)

        if (!todosPertenecen) {
            android.util.Log.w("SupabaseService", "⚠️ Regla 2 violada: Hay síntomas de diferentes enfermedades")
            return null
        }

        // Si pasa todas las reglas, obtener los detalles de la enfermedad
        val enfermedad: Enfermedad
        try {
            enfermedad = postgrest.from(SupabaseConfig.TABLE_ENFERMEDADES)
                .select {
                    filter {
                        eq("id", enfermedadMasProbable.enfermedadId)
                    }
                }
                .decodeSingle<Enfermedad>()
        } catch (e: Exception) {
            android.util.Log.e("SupabaseService", "❌ Error al obtener detalles de la enfermedad: ${e.message}")
            return null
        }

        // Obtener recomendaciones
        val recomendaciones = obtenerRecomendacionesPorEnfermedad(enfermedad.id)

        android.util.Log.d("SupabaseService", "✅ Diagnóstico válido: ${enfermedad.nombre} con ${enfermedadMasProbable.cantidadCoincidencias} síntomas")

        // Guardar el diagnóstico en la base de datos
        guardarDiagnostico(
            usuarioId = usuarioId,
            enfermedadId = enfermedad.id,
            sintomasSeleccionados = sintomaIds
        )

        return DiagnosticoResultado(
            enfermedad = enfermedad,
            sintomasSeleccionados = sintomas,
            recomendaciones = recomendaciones
        )
    }

    // Guardar diagnóstico en la base de datos
    suspend fun guardarDiagnostico(
        usuarioId: String?,
        enfermedadId: String,
        sintomasSeleccionados: List<String>
    ): Boolean {
        return try {
            val diagnostico = com.example.sistema_experto.data.models.Diagnostico.create(
                usuarioId = usuarioId,
                enfermedadId = enfermedadId,
                sintomasSeleccionados = sintomasSeleccionados
            )
            
            postgrest.from(SupabaseConfig.TABLE_DIAGNOSTICOS)
                .insert(diagnostico)
            
            true
        } catch (e: Exception) {
            // No fallar si no se puede guardar el diagnóstico
            false
        }
    }

    // Función de prueba para verificar la conexión a Supabase
    suspend fun verificarConexion(): ResultadoConexion {
        android.util.Log.d("SupabaseService", "🔄 Iniciando verificarConexion()...")
        return try {
            android.util.Log.d("SupabaseService", "🔄 Intentando consultar tabla enfermedades...")
            // Intentar obtener una enfermedad para verificar la conexión
            val enfermedades = postgrest.from(SupabaseConfig.TABLE_ENFERMEDADES)
                .select {
                    limit(1)
                }
                .decodeList<Enfermedad>()
            
            // Verificar que hay datos
            val tieneEnfermedades = enfermedades.isNotEmpty()
            
            // Intentar obtener síntomas
            val sintomas = postgrest.from(SupabaseConfig.TABLE_SINTOMAS)
                .select {
                    limit(1)
                }
                .decodeList<Sintoma>()
            val tieneSintomas = sintomas.isNotEmpty()
            
            // Intentar obtener recomendaciones
            val recomendaciones = postgrest.from(SupabaseConfig.TABLE_RECOMENDACIONES)
                .select {
                    limit(1)
                }
                .decodeList<Recomendacion>()
            val tieneRecomendaciones = recomendaciones.isNotEmpty()
            
            // Contar registros totales
            val totalEnfermedades = postgrest.from(SupabaseConfig.TABLE_ENFERMEDADES)
                .select()
                .decodeList<Enfermedad>()
                .size
            
            val totalSintomas = postgrest.from(SupabaseConfig.TABLE_SINTOMAS)
                .select()
                .decodeList<Sintoma>()
                .size
            
            val totalRecomendaciones = postgrest.from(SupabaseConfig.TABLE_RECOMENDACIONES)
                .select()
                .decodeList<Recomendacion>()
                .size
            
            ResultadoConexion(
                conectado = true,
                mensaje = "Conexión exitosa a Supabase",
                tieneEnfermedades = tieneEnfermedades,
                tieneSintomas = tieneSintomas,
                tieneRecomendaciones = tieneRecomendaciones,
                totalEnfermedades = totalEnfermedades,
                totalSintomas = totalSintomas,
                totalRecomendaciones = totalRecomendaciones,
                error = null
            )
        } catch (e: Exception) {
            android.util.Log.e("SupabaseService", "❌ Error en verificarConexion(): ${e.message}", e)
            android.util.Log.e("SupabaseService", "Stack trace: ${e.stackTraceToString()}")
            ResultadoConexion(
                conectado = false,
                mensaje = "Error al conectar con Supabase",
                tieneEnfermedades = false,
                tieneSintomas = false,
                tieneRecomendaciones = false,
                totalEnfermedades = 0,
                totalSintomas = 0,
                totalRecomendaciones = 0,
                error = e.message ?: "Error desconocido"
            )
        }
    }

    // Función auxiliar para asignar íconos según la categoría
    private fun getIconoPorCategoria(nombre: String): String {
        return when {
            nombre.contains("Respiratorio", ignoreCase = true) -> "🫁" // Pulmones
            nombre.contains("Gastrointestinal", ignoreCase = true) -> "🫄" // Estómago/abdomen
            nombre.contains("Metabólico", ignoreCase = true) || nombre.contains("Sistémico", ignoreCase = true) -> "⚡" // Energía/metabolismo
            nombre.contains("Dermatológico", ignoreCase = true) -> "🩹" // Piel/curación
            nombre.contains("Neurológico", ignoreCase = true) -> "🧠" // Cerebro
            nombre.contains("Musculoesquelético", ignoreCase = true) -> "💪" // Músculos
            nombre.contains("General", ignoreCase = true) -> "⚕️" // Símbolo médico general
            nombre.contains("Oftalmológico", ignoreCase = true) -> "👁️" // Ojo
            nombre.contains("Otorrinolaringológico", ignoreCase = true) -> "👂" // Oído
            else -> "🏥" // Hospital por defecto
        }
    }
}
