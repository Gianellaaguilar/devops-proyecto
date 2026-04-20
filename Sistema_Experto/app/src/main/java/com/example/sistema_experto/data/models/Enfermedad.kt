package com.example.sistema_experto.data.models

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import kotlinx.serialization.Serializable

@Serializable
@Parcelize
data class Enfermedad(
    val id: String,  // UUID
    val nombre: String,
    val categoria: String,
    val descripcion: String? = null
) : Parcelable

