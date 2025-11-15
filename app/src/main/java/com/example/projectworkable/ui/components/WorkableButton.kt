package com.example.projectworkable.ui.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun WorkableButton(text: String, onClick: () -> Unit) {

    // Custom button that fits full width
    Button(
        onClick = onClick,
        shape = RoundedCornerShape(14.dp), // rounded corners
        modifier = Modifier.fillMaxWidth(),
        colors = ButtonDefaults.buttonColors(
            containerColor = androidx.compose.ui.graphics.Color(0xFFA21CAF) // WorkAble primary color
        )
    ) {
        // Text inside button
        Text(text = text, fontSize = 18.sp)
    }
}
