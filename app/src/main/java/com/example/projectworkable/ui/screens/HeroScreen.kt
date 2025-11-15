package com.example.projectworkable.ui.screens

import androidx.compose.animation.*
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

import com.example.projectworkable.R
import com.example.projectworkable.ui.components.FeatureCard
import com.example.projectworkable.ui.components.WorkableButton

@OptIn(ExperimentalAnimationApi::class)
@Composable
fun HeroScreen() {

    // When this screen loads, this will become true → triggers animations
    var visible by remember { mutableStateOf(false) }
    LaunchedEffect(Unit) { visible = true }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp), // overall padding
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        // Logo appears with fade-in animation
        AnimatedVisibility(
            visible = visible,
            enter = fadeIn(animationSpec = tween(900)) // 0.9s fade
        ) {
            Image(
                painter = painterResource(id = R.drawable.ic_accessibility),
                contentDescription = "WorkAble Logo",
                modifier = Modifier.size(120.dp),
                contentScale = ContentScale.Fit,
                colorFilter = ColorFilter.tint(MaterialTheme.colorScheme.primary)
            )
        }

        Spacer(modifier = Modifier.height(12.dp))

        // Title slides up + fades in
        AnimatedVisibility(
            visible = visible,
            enter = slideInVertically(tween(700)) + fadeIn(tween(700))
        ) {
            Text(
                text = "WorkAble",
                fontSize = 42.sp,
                fontWeight = FontWeight.ExtraBold,
                color = MaterialTheme.colorScheme.primary
            )
        }

        Spacer(modifier = Modifier.height(10.dp))

        // Short subtitle text
        Text(
            text = "Empowering individuals with disabilities to find meaningful opportunities.",
            fontSize = 17.sp,
            color = MaterialTheme.colorScheme.onBackground,
            modifier = Modifier.padding(horizontal = 12.dp),
        )

        Spacer(modifier = Modifier.height(24.dp))

        // Reusable Get Started button component
        WorkableButton(
            text = "Get Started",
            onClick = { /* TODO: Navigate */ }
        )

        Spacer(modifier = Modifier.height(30.dp))

        // Feature section (reusable card component)
        FeatureCard(
            title = "Accessible Jobs",
            description = "Find job roles tailored to your abilities.",
            icon = R.drawable.ic_work
        )

        Spacer(modifier = Modifier.height(16.dp))

        FeatureCard(
            title = "Skill Builder",
            description = "Recommended learning based on your limitations.",
            icon = R.drawable.ic_skill
        )
    }
}
