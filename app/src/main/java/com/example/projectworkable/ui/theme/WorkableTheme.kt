package com.example.projectworkable.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable

// Temporary free colors – you can change later
private val LightColors = lightColorScheme(
    primary = Blue,
    secondary = BlueDark,
    tertiary = BlueLight
)

private val DarkColors = darkColorScheme(
    primary = BlueLight,
    secondary = Blue,
    tertiary = BlueDark
)

@Composable
fun WorkableTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colors = if (darkTheme) DarkColors else LightColors

    MaterialTheme(
        colorScheme = colors,
        typography = Typography,
        shapes = Shapes,
        content = content
    )
}
