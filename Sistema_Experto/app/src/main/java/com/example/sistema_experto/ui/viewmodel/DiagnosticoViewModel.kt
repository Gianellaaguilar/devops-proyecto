package com.example.sistema_experto.ui.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.example.sistema_experto.BuildConfig
import com.example.sistema_experto.data.SupabaseService
import com.example.sistema_experto.data.UserIdManager
import com.example.sistema_experto.data.models.*
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class DiagnosticoViewModel(application: Application) : AndroidViewModel(application) {
    private val supabaseService = SupabaseService()
    private val appContext = application.applicationContext

    private val _categorias = MutableStateFlow<List<Categoria>>(emptyList())
    val categorias: StateFlow<List<Categoria>> = _categorias.asStateFlow()

    private val _subcategorias = MutableStateFlow<List<Subcategoria>>(emptyList())
    val subcategorias: StateFlow<List<Subcategoria>> = _subcategorias.asStateFlow()

    private val _sintomas = MutableStateFlow<List<Sintoma>>(emptyList())
    val sintomas: StateFlow<List<Sintoma>> = _sintomas.asStateFlow()

    private val _diagnosticoResultado = MutableStateFlow<DiagnosticoResultado?>(null)
    val diagnosticoResultado: StateFlow<DiagnosticoResultado?> = _diagnosticoResultado.asStateFlow()

    private val _loading = MutableStateFlow(false)
    val loading: StateFlow<Boolean> = _loading.asStateFlow()

    private val _error = MutableStateFlow<String?>(null)
    val error: StateFlow<String?> = _error.asStateFlow()

    private val _resultadoConexion = MutableStateFlow<com.example.sistema_experto.data.ResultadoConexion?>(null)
    val resultadoConexion: StateFlow<com.example.sistema_experto.data.ResultadoConexion?> = _resultadoConexion.asStateFlow()

    // Estado de selección
    var categoriaSeleccionada: Categoria? = null
    var subcategoriaSeleccionada: Subcategoria? = null
    val sintomasSeleccionados = mutableSetOf<String>()  // UUIDs

    init {
        android.util.Log.d("DiagnosticoViewModel", "🔵 ViewModel inicializado")
        // La carga de categorías ahora se realiza desde SplashFragment
        // La verificación de conexión se ejecuta desde MainActivity
    }

    // Función para verificar la conexión a Supabase
    fun verificarConexion() {
        viewModelScope.launch {
            _loading.value = true
            try {
                val resultado = supabaseService.verificarConexion()
                _resultadoConexion.value = resultado
                if (resultado.conectado) {
                    _error.value = null
                } else {
                    _error.value = "Error de conexión: ${resultado.mensaje}\n${resultado.error}"
                }
            } catch (e: Exception) {
                _error.value = "Error al verificar conexión: ${e.message}"
                _resultadoConexion.value = com.example.sistema_experto.data.ResultadoConexion(
                    conectado = false,
                    mensaje = "Error al verificar conexión",
                    tieneEnfermedades = false,
                    tieneSintomas = false,
                    tieneRecomendaciones = false,
                    totalEnfermedades = 0,
                    totalSintomas = 0,
                    totalRecomendaciones = 0,
                    error = e.message ?: "Error desconocido"
                )
            } finally {
                _loading.value = false
            }
        }
    }

    fun cargarCategorias() {
        viewModelScope.launch {
            _loading.value = true
            try {
                android.util.Log.d("DiagnosticoViewModel", "🔄 Iniciando carga de categorías...")
                val categorias = supabaseService.obtenerCategorias()
                android.util.Log.d("DiagnosticoViewModel", "✅ Categorías cargadas: ${categorias.size}")
                _categorias.value = categorias
                if (categorias.isEmpty()) {
                    android.util.Log.w("DiagnosticoViewModel", "⚠️ No se encontraron categorías")
                    _error.value = "No se encontraron categorías. Verifica que la base de datos tenga datos."
                } else {
                    _error.value = null
                }
            } catch (e: Exception) {
                val mensajeError = "Error al cargar categorías: ${e.message}\n\n" +
                        "Verifica:\n" +
                        "1. Que la URL y clave de Supabase sean correctas\n" +
                        "2. Que tengas conexión a internet\n" +
                        "3. Que las políticas RLS permitan lectura pública"
                _error.value = mensajeError
                android.util.Log.e("DiagnosticoViewModel", "❌ $mensajeError", e)
                // No crashear, solo mostrar error
                _categorias.value = emptyList()
            } finally {
                _loading.value = false
            }
        }
    }

    fun cargarSubcategorias(categoriaNombre: String) {
        viewModelScope.launch {
            _loading.value = true
            try {
                _subcategorias.value = supabaseService.obtenerSubcategoriasPorCategoria(categoriaNombre)
                _error.value = null
            } catch (e: Exception) {
                _error.value = "Error al cargar subcategorías: ${e.message}"
            } finally {
                _loading.value = false
            }
        }
    }

    fun cargarSintomas(subcategoriaNombre: String) {
        viewModelScope.launch {
            _loading.value = true
            try {
                _sintomas.value = supabaseService.obtenerSintomasPorSubcategoria(subcategoriaNombre)
                _error.value = null
            } catch (e: Exception) {
                _error.value = "Error al cargar síntomas: ${e.message}"
            } finally {
                _loading.value = false
            }
        }
    }

    fun obtenerDiagnostico() {
        viewModelScope.launch {
            _loading.value = true
            _error.value = null
            try {
                // Obtener el ID de usuario único y persistente
                val usuarioId = UserIdManager.getUserIdAsync(appContext)
                android.util.Log.d("DiagnosticoViewModel", "👤 Usando ID de usuario: $usuarioId")
                
                val resultado = supabaseService.obtenerDiagnostico(
                    sintomaIds = sintomasSeleccionados.toList(),
                    usuarioId = usuarioId
                )
                
                if (resultado == null) {
                    // No se encontraron coincidencias con enfermedades
                    _diagnosticoResultado.value = null
                    _error.value = null // No es un error, simplemente no hay coincidencias
                    android.util.Log.w("DiagnosticoViewModel", "⚠️ No se encontraron enfermedades que coincidan con los síntomas seleccionados")
                } else {
                    // Se encontró al menos una enfermedad
                    _diagnosticoResultado.value = resultado
                    _error.value = null
                    android.util.Log.d("DiagnosticoViewModel", "✅ Diagnóstico obtenido: ${resultado.enfermedad.nombre}")
                }
            } catch (e: Exception) {
                _diagnosticoResultado.value = null
                _error.value = "Error al obtener diagnóstico: ${e.message}"
                android.util.Log.e("DiagnosticoViewModel", "❌ Error al obtener diagnóstico: ${e.message}", e)
            } finally {
                _loading.value = false
            }
        }
    }

    fun resetear() {
        categoriaSeleccionada = null
        subcategoriaSeleccionada = null
        sintomasSeleccionados.clear()
        _subcategorias.value = emptyList()
        _sintomas.value = emptyList()
        _diagnosticoResultado.value = null
        _error.value = null
    }
}

