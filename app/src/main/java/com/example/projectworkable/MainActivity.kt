package com.example.projectworkable

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.rememberNavController
import com.example.projectworkable.ui.navigation.BottomNavBar
import com.example.projectworkable.ui.navigation.WorkableNavHost
import com.example.projectworkable.ui.theme.WorkableTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Icon
import androidx.compose.material3.Text

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            WorkableTheme {
                Surface(color = MaterialTheme.colorScheme.background) {
                    MainApp()
                }
            }
        }
    }
}

@Composable
fun MainApp() {
    val navController = rememberNavController()

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        bottomBar = {
            BottomNavBar(navController)
        }
    ) { padding ->
        Box(
            modifier = Modifier
                .padding(padding)
                .fillMaxSize()
        ) {
            WorkableNavHost(navController)
        }
    }
}


// small wrapper to give NavHost some bottom padding (so content isn't hidden by the bottom bar)
@Composable
fun WorkableNavHostWrapper(navController: androidx.navigation.NavHostController) {
    androidx.compose.foundation.layout.Column {
        androidx.compose.foundation.layout.Box(modifier = Modifier
            .weight(1f)
            .padding(bottom = 56.dp)) { // ≈ height of nav bar — adjust if needed
            WorkableNavHost(navController = navController)
        }
    }
}
