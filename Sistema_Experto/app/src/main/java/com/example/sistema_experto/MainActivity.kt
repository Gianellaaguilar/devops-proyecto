package com.example.sistema_experto

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.sistema_experto.BuildConfig
import com.example.sistema_experto.data.SupabaseService
import android.util.Log
import kotlinx.coroutines.runBlocking

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(android.R.id.content)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // No necesitamos setupActionBarWithNavController porque usamos tema NoActionBar
        
        // Verificar conexión a Supabase en modo DEBUG (después de que la UI esté lista)
        if (BuildConfig.DEBUG) {
            Log.d("MainActivity", "🔍 Programa verificación de conexión a Supabase...")
            // Retrasar la verificación para evitar problemas de inicialización
            window.decorView.postDelayed({
                try {
                    verificarConexionSupabase()
                } catch (e: Exception) {
                    Log.e("MainActivity", "Error al iniciar verificación: ${e.message}", e)
                }
            }, 2000) // Esperar 2 segundos después de que la UI esté lista
        }
    }
    
    private fun verificarConexionSupabase() {
        // Ejecutar en un hilo separado para no bloquear la UI
        Thread {
            try {
                Log.d("SupabaseConnection", "═══════════════════════════════════")
                Log.d("SupabaseConnection", "🔍 VERIFICACIÓN DE CONEXIÓN SUPABASE")
                Log.d("SupabaseConnection", "═══════════════════════════════════")
                Log.d("SupabaseConnection", "Iniciando verificación...")
                
                val supabaseService = SupabaseService()
                
                // Ejecutar la verificación en una coroutine
                runBlocking {
                    val resultado = supabaseService.verificarConexion()
                    
                    Log.d("SupabaseConnection", "Estado: ${if (resultado.conectado) "✅ CONECTADO" else "❌ ERROR"}")
                    Log.d("SupabaseConnection", "Mensaje: ${resultado.mensaje}")
                    Log.d("SupabaseConnection", "")
                    Log.d("SupabaseConnection", "📊 ESTADÍSTICAS:")
                    Log.d("SupabaseConnection", "  • Enfermedades: ${resultado.totalEnfermedades}")
                    Log.d("SupabaseConnection", "  • Síntomas: ${resultado.totalSintomas}")
                    Log.d("SupabaseConnection", "  • Recomendaciones: ${resultado.totalRecomendaciones}")
                    
                    if (resultado.error != null) {
                        Log.e("SupabaseConnection", "")
                        Log.e("SupabaseConnection", "⚠️ ERROR: ${resultado.error}")
                    }
                    
                    Log.d("SupabaseConnection", "═══════════════════════════════════")
                }
            } catch (e: Exception) {
                Log.e("SupabaseConnection", "❌ EXCEPCIÓN al verificar conexión", e)
                Log.e("SupabaseConnection", "Mensaje: ${e.message}")
                Log.e("SupabaseConnection", "Stack trace: ${e.stackTraceToString()}")
            }
        }.start()
    }

    // No necesitamos onSupportNavigateUp porque no tenemos ActionBar
}