package com.example.projectworkable

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import com.example.projectworkable.ui.screens.HeroScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Enables fullscreen layout (recommended for Material3)
        enableEdgeToEdge()

        // setContent → this is the Compose UI entry point
        setContent {

            // Surface = background for your screens (based on MaterialTheme)
            Surface(
                color = MaterialTheme.colorScheme.background
            ) {
                // Load your HeroScreen here
                HeroScreen()
            }
        }
    }
}
