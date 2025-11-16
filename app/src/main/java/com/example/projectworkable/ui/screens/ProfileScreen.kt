package com.example.projectworkable.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.projectworkable.ui.components.ProfileField

@Composable
fun ProfileScreen() {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp)
    ) {
        // -------------------------------
        // PROFILE HEADER
        // -------------------------------
        Column(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // Avatar circular icon
            Box(
                modifier = Modifier
                    .size(115.dp)
                    .clip(CircleShape)
                    .background(MaterialTheme.colorScheme.primary),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = "JD",
                    fontSize = 28.sp,
                    fontWeight = FontWeight.Bold,
                    color = MaterialTheme.colorScheme.onPrimary
                )
            }

            Spacer(modifier = Modifier.height(16.dp))

            Text(
                text = "Jess Lee Dassan",
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colorScheme.onBackground
            )
        }

        Spacer(modifier = Modifier.height(32.dp))

        // -------------------------------
        // TWO COLUMN LAYOUT
        // -------------------------------
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            // LEFT COLUMN
            Column(modifier = Modifier.weight(1f)) {

                ProfileField("Email", "DassanJess@example.com")
                ProfileField("Password", "********")
                ProfileField("Experience", "5 years in software development.")
                ProfileField("Disability", "Dyslexic")
                ProfileField("Wants", "Remote job with flexible hours.")
                ProfileField("Circumstances",
                    "Living in a rural area with limited job opportunities.")
            }

            Spacer(modifier = Modifier.width(32.dp))

            // RIGHT COLUMN
            Column(modifier = Modifier.weight(1f)) {

                Text(
                    text = "Capability",
                    fontWeight = FontWeight.Bold,
                    fontSize = 16.sp,
                    color = MaterialTheme.colorScheme.onBackground
                )

                Spacer(modifier = Modifier.height(8.dp))

                val capabilityList = listOf(
                    "Reading & Writing" to "7",
                    "Vision" to "6",
                    "Hearing" to "6",
                    "Speech Communication" to "6",
                    "Physical Ability" to "7",
                    "Mental Focus" to "6",
                    "Financial Work Barriers" to "5",
                    "Legal Social Barriers" to "7",
                    "Caregiver Dependents" to "6",
                    "Tech Skills" to "6"
                )

                capabilityList.forEach { (capability, scale) ->
                    Row(
                        modifier = Modifier.fillMaxWidth()
                            .padding(vertical = 6.dp),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Text(capability, color = MaterialTheme.colorScheme.onBackground)
                        Text(scale, color = MaterialTheme.colorScheme.onBackground)
                    }
                }
            }
        }
    }
}
