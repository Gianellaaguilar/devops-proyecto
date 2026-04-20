package com.example.sistema_experto.data.models

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
@Parcelize
data class Recomendacion(
    val id: String,  // UUID
    @SerialName("enfermedad_id")
    val enfermedadId: String,  // UUID
    val recomendacion: String
) : Parcelable {
    // Alias para compatibilidad con el código existente
    val descripcion: String get() = recomendacion
}

