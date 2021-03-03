package com.example.artgallary.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

private val DarkColorPalette = darkColors(
    primary = lightGray,
    primaryVariant = darkGray,
    secondary = teal200,
    onBackground = Color.White
)

private val LightColorPalette = lightColors(
    primary = lightGray,
    primaryVariant = darkGray,
    secondary = teal200,
    onBackground = Color.DarkGray
)

@Composable
fun ArtGallaryTheme(darkTheme: Boolean = isSystemInDarkTheme(), content: @Composable() () -> Unit) {
    val colors = if (darkTheme) {
        DarkColorPalette
    } else {
        LightColorPalette
    }

    MaterialTheme(
        colors = colors,
        typography = typography,
        shapes = shapes,
        content = content
    )
}
