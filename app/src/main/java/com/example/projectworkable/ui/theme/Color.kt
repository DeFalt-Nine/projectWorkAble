package com.example.projectworkable.ui.theme

import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.ui.graphics.Color

// WorkAble bluish dark mode palette
val Blue = Color(0xFF1B263B)        // Primary medium blue
val BlueLight = Color(0xFF415A77)   // Lighter blue / tertiary
val BlueDark = Color(0xFF0D1B2A)    // Dark navy / secondary

val Accent = Color(0xFF778DA9)      // Accent color
val AccentDim = Color(0xFF415A77)   // Dim accent
val Background = Color(0xFF0D1B2A)  // Background
val Surface = Color(0xFF1B263B)     // Surface / cards
val WhiteText = Color(0xFFE0E1DD)   // Text on dark background
val TextLight = Color(0xFFF5F5F5)   // Secondary text

// Light theme colors
private val LightColors = lightColorScheme(
    primary = Blue,
    secondary = BlueDark,
    tertiary = BlueLight,
    background = WhiteText,
    surface = BlueLight,
    onPrimary = WhiteText,
    onSecondary = WhiteText,
    onTertiary = WhiteText,
    onBackground = BlueDark,
    onSurface = BlueDark
)

// Dark theme colors
private val DarkColors = darkColorScheme(
    primary = BlueLight,
    secondary = Blue,
    tertiary = BlueDark,
    background = Background,
    surface = Surface,
    onPrimary = WhiteText,
    onSecondary = WhiteText,
    onTertiary = WhiteText,
    onBackground = WhiteText,
    onSurface = WhiteText
)
