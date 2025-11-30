package com.example.projectworkable.data.remote

import io.github.jan.supabase.createSupabaseClient
import io.github.jan.supabase.gotrue.Auth
import io.github.jan.supabase.postgrest.Postgrest

object SupabaseConfig {

    // Replace with your actual Supabase project URL and anon key
    private const val SUPABASE_URL = "https://rpdlmgflyndcebyvhvkj.supabase.co"
    private const val SUPABASE_KEY = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpc3MiOiJzdXBhYmFzZSIsInJlZiI6InJwZGxtZ2ZseW5kY2VieXZodmtqIiwicm9sZSI6ImFub24iLCJpYXQiOjE3NjM1MzE5MDksImV4cCI6MjA3OTEwNzkwOX0.nWt-yR-XujJSc-Y2PgISSVoqzmyRbhSiXFVDhyUOsHo"

    val client = createSupabaseClient(
        supabaseUrl = SUPABASE_URL,
        supabaseKey = SUPABASE_KEY
    ) {
        install(Auth)
        install(Postgrest.Companion)
    }
}