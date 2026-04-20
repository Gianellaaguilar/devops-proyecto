package com.example.sistema_experto.data.models

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import kotlinx.parcelize.RawValue

@Parcelize
data class DiagnosticoResultado(
    val enfermedad: @RawValue Enfermedad,
    val sintomasSeleccionados: @RawValue List<Sintoma>,
    val recomendaciones: @RawValue List<Recomendacion>
) : Parcelable

