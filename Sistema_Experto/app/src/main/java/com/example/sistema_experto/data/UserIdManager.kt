package com.example.sistema_experto.data

import android.content.Context
import android.content.SharedPreferences
import java.util.UUID

/**
 * Gestor de ID de usuario único y persistente
 * Genera un UUID único la primera vez que se usa y lo guarda en SharedPreferences
 * para reutilizarlo en todas las sesiones posteriores
 */
object UserIdManager {
    private const val PREFS_NAME = "sistema_experto_prefs"
    private const val KEY_USER_ID = "user_id"

    /**
     * Obtiene el ID de usuario único. Si no existe, lo genera y guarda.
     * @param context Contexto de la aplicación
     * @return UUID único del usuario/dispositivo
     */
    fun getUserId(context: Context): String {
        val prefs: SharedPreferences = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)
        
        // Intentar obtener el ID existente
        val existingId = prefs.getString(KEY_USER_ID, null)
        
        return if (existingId != null) {
            // Ya existe un ID, retornarlo
            android.util.Log.d("UserIdManager", "✅ ID de usuario existente recuperado: $existingId")
            existingId
        } else {
            // No existe, generar uno nuevo y guardarlo
            val newId = UUID.randomUUID().toString()
            prefs.edit().putString(KEY_USER_ID, newId).apply()
            android.util.Log.d("UserIdManager", "🆕 Nuevo ID de usuario generado: $newId")
            newId
        }
    }

    /**
     * Obtiene el ID de usuario de forma asíncrona (para usar en coroutines)
     * @param context Contexto de la aplicación
     * @return UUID único del usuario/dispositivo
     */
    suspend fun getUserIdAsync(context: Context): String {
        return getUserId(context)
    }

    /**
     * Resetea el ID de usuario (útil para testing o si el usuario quiere empezar de nuevo)
     * @param context Contexto de la aplicación
     */
    fun resetUserId(context: Context) {
        val prefs: SharedPreferences = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)
        prefs.edit().remove(KEY_USER_ID).apply()
        android.util.Log.d("UserIdManager", "🔄 ID de usuario reseteado")
    }
}


