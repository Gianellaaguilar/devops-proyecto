package com.example.sistema_experto.data.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

// Tabla de relación entre enfermedades y síntomas
@Serializable
data class EnfermedadSintoma(
    @SerialName("enfermedad_id")
    val enfermedadId: String,  // UUID
    @SerialName("sintoma_id")
    val sintomaId: String  // UUID
)

