package com.example.sistema_experto.data.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

// Tabla de relación entre categorías y subcategorías
@Serializable
data class CategoriaSubcategoria(
    val id: String? = null,  // UUID, opcional
    @SerialName("categoria_nombre")
    val categoriaNombre: String,
    @SerialName("subcategoria_nombre")
    val subcategoriaNombre: String
)


