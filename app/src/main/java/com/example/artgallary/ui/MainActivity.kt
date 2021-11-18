package com.example.artgallary.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.material.Surface
import androidx.compose.material3.MaterialTheme
import com.example.artgallary.model.Arts
import com.example.artgallary.ui.arts.AllArts
import com.example.artgallary.ui.theme.ArtGallaryTheme

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalAnimationApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ArtGallaryTheme {
                Surface(color = MaterialTheme.colorScheme.inverseOnSurface) {
                    AllArts(Arts)
                }
            }
        }
    }
}
