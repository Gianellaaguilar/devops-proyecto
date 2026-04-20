package com.example.sistema_experto.data.models

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import kotlinx.serialization.Serializable

@Serializable
@Parcelize
data class Categoria(
    val nombre: String,
    val icono: String? = null
) : Parcelable {
    // Para compatibilidad con RecyclerView, generamos un ID basado en el nombre
    val id: String get() = nombre.hashCode().toString()
}

