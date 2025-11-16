package com.example.projectworkable.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.glance.layout.Column
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.Box

data class JobBoxItem(val title: String, val description: String)

@Composable
fun JobsScreen() {

    val items = listOf(
        JobBoxItem(title = "Place Holder", description = "This is where job recommendations will appear.")
    )

    Column(modifier = Modifier
        .fillMaxSize()
        .padding(24.dp)
    ) {
        Text(text = "Jobs", style = androidx.compose.material3.MaterialTheme.typography.headlineMedium)
        Spacer(modifier = Modifier.height(12.dp))
        Text(text = "This is where job recommendations will appear.")
    }

    Box(
        
    ) {

    }
}
