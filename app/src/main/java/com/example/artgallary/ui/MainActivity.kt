package com.example.artgallary.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import com.example.artgallary.model.Arts
import com.example.artgallary.ui.arts.AllArts
import com.example.artgallary.ui.theme.ArtGallaryTheme

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalAnimationApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ArtGallaryTheme {
                Surface(color = MaterialTheme.colors.background) {
                    AllArts(Arts)
                }
            }
        }
    }
}
