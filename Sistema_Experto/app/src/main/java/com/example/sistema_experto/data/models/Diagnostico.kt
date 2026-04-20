package com.example.sistema_experto.data.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.JsonArray
import kotlinx.serialization.json.JsonElement
import kotlinx.serialization.json.JsonPrimitive
import kotlinx.serialization.json.buildJsonArray

@Serializable
data class Diagnostico(
    val id: String? = null,  // UUID, se genera automáticamente
    @SerialName("usuario_id")
    val usuarioId: String? = null,
    @SerialName("enfermedad_id")
    val enfermedadId: String,  // UUID
    @SerialName("sintomas_seleccionados")
    val sintomasSeleccionados: JsonArray,  // JSONB: Lista de UUIDs de síntomas como JSON
    val fecha: String? = null  // Se genera automáticamente
) {
    companion object {
        fun create(
            usuarioId: String?,
            enfermedadId: String,
            sintomasSeleccionados: List<String>
        ): Diagnostico {
            val jsonArray = buildJsonArray {
                sintomasSeleccionados.forEach { add(JsonPrimitive(it)) }
            }
            return Diagnostico(
                usuarioId = usuarioId,
                enfermedadId = enfermedadId,
                sintomasSeleccionados = jsonArray
            )
        }
    }
}

