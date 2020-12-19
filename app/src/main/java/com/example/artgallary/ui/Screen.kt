package com.example.artgallary.ui

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.artgallary.model.Arts
import com.example.artgallary.ui.arts.AllArts
import com.example.artgallary.ui.theme.ArtGallaryTheme

@OptIn(ExperimentalAnimationApi::class)
@Composable
fun Screen() {
    AllArts(Arts)
}

@OptIn(ExperimentalAnimationApi::class)
@Preview(showBackground = true)
@Composable
fun ScreenPreview() {
    ArtGallaryTheme {
        Screen()
    }
}
