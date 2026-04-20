package com.example.sistema_experto.data.models

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
@Parcelize
data class Sintoma(
    val id: String,  // UUID
    val nombre: String,
    @SerialName("subcategoria")
    val subcategoria: String
) : Parcelable

