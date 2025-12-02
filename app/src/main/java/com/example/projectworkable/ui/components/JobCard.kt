package com.example.projectworkable.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.LocalIndication
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp


/**
 * @param title The main title of the blog post.
 * @param description A short summary of the blog post.
 * @param detail Description of the job.
 * @param image The painter resource for the card's banner image.
 * @param tag A category tag (e.g., "Career", "Skills").
 * @param onClick A lambda function to be invoked when the card is clicked.
 */

@Composable
fun JobCard(
    title: String,
    description: String,
    detail: String,
    image: Painter,
    onClick: () -> Unit, // We can keep this for future navigation
    tag: String
) {
    // 1. State to control dialog visibility
    var showDialog by remember { mutableStateOf(false) }

    // When the card is clicked, we'll set the state to true
    JobBoxItem(
        title = title,
        description = description,
        detail = detail,
        image = {
            Image(
                painter = image,
                contentDescription = title,
                contentScale = ContentScale.Crop, // Makes the image fit well
                modifier = Modifier
                    .size(56.dp)
                    .clip(CircleShape) // Makes the image circular
            )
        },
        onClick = { showDialog = true }, // Updated onClick to show the dialog
        tag = tag
    )

    // 3. The AlertDialog that appears when showDialog is true
    if (showDialog) {
        AlertDialog(
            onDismissRequest = { showDialog = false }, // Hide dialog when clicking outside
            title = {
                Text(text = title, style = MaterialTheme.typography.headlineSmall)
            },
            text = {
                Column {
                    Text(text = description, style = MaterialTheme.typography.bodyLarge)
                    Spacer(modifier = Modifier.height(6.dp))
                    Text(text = detail, style = MaterialTheme.typography.bodyLarge)
                }
            },
            confirmButton = {
                TextButton(
                    onClick = { showDialog = false } // Hide dialog on button press
                ) {
                    Text("Close")
                }
            },
            shape = RoundedCornerShape(16.dp)
        )
    }
}

@Composable
fun JobBoxItem(
    title: String,
    description: String,
    image: @Composable () -> Unit,
    onClick: () -> Unit,
    tag: String,
    detail: String
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp, horizontal = 16.dp)
            .clickable(
                interactionSource = remember { MutableInteractionSource() },
                indication = LocalIndication.current,
                onClick = onClick
            ),
        shape = RoundedCornerShape(12.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surface
        )
    ) {
        Row(
            modifier = Modifier.padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            image()

            Spacer(modifier = Modifier.width(16.dp))

            Column(
                modifier = Modifier.weight(1f)
            ) {
                Text(
                    text = title,
                    style = MaterialTheme.typography.titleLarge,
                    fontWeight = FontWeight.Bold,
                    color = MaterialTheme.colorScheme.onSurface
                )
                Spacer(modifier = Modifier.height(4.dp))
                Text(
                    text = description,
                    style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.colorScheme.onSurfaceVariant,
                    maxLines = 2
                )
            }
        }
    }
}

