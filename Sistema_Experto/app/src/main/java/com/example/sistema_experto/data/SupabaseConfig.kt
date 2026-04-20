package com.example.sistema_experto.data

object SupabaseConfig {
    // Credenciales de Supabase
    const val SUPABASE_URL = "https://hiodwukvcoosmzofuhwg.supabase.co"
    const val SUPABASE_KEY = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpc3MiOiJzdXBhYmFzZSIsInJlZiI6Imhpb2R3dWt2Y29vc216b2Z1aHdnIiwicm9sZSI6ImFub24iLCJpYXQiOjE3NjQ0Njc1MTksImV4cCI6MjA4MDA0MzUxOX0.IuFeUzwxApZPf_6wzRq-bC9E2hI-Pj0j2mdHPvcPdOM"
    
    // Nombres de las tablas en Supabase
    const val TABLE_SINTOMAS = "sintomas"
    const val TABLE_ENFERMEDADES = "enfermedades"
    const val TABLE_RECOMENDACIONES = "recomendaciones"
    const val TABLE_ENFERMEDAD_SINTOMA = "enfermedad_sintoma"
    const val TABLE_DIAGNOSTICOS = "diagnosticos"
    const val TABLE_CATEGORIA_SUBCATEGORIA = "categoria_subcategoria"
}

