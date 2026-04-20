package com.example.sistema_experto.data.models

import androidx.annotation.DrawableRes

data class Experto(
    val id: Int,
    val nombre: String,
    val especialidad: String,
    val pais: String,
    @DrawableRes val imagenResId: Int // Referencia al recurso drawable
)
