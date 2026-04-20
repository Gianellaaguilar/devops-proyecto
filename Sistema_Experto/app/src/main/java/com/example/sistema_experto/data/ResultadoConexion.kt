package com.example.sistema_experto.data

// Clase de datos para el resultado de la verificación de conexión
data class ResultadoConexion(
    val conectado: Boolean,
    val mensaje: String,
    val tieneEnfermedades: Boolean,
    val tieneSintomas: Boolean,
    val tieneRecomendaciones: Boolean,
    val totalEnfermedades: Int,
    val totalSintomas: Int,
    val totalRecomendaciones: Int,
    val error: String?
)



