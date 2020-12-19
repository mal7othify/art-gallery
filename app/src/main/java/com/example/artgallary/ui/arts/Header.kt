package com.example.artgallary.ui.arts

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredHeight
import androidx.compose.foundation.layout.requiredWidth
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.artgallary.R

@Composable
fun Header() {
    Box(
        modifier = Modifier.fillMaxWidth()
    ) {
        Image(
            imageVector = ImageVector.vectorResource(R.drawable.ic_baseline_brush_24),
            contentDescription = null,
            colorFilter = ColorFilter.tint(MaterialTheme.colors.primary),
            modifier = Modifier.padding(start = 15.dp)
                .align(Alignment.TopCenter)
                .requiredHeight(24.dp)
                .requiredWidth(24.dp)
        )
        Text(
            "Art Gallery",
            style = MaterialTheme.typography.h1,
            modifier = Modifier.padding(start = 15.dp, top = 20.dp, bottom = 8.dp)
                .align(Alignment.CenterStart)
        )
    }
    Text(
        "“Painting is poetry that is seen rather than felt, and poetry is painting that is felt rather than seen.”",
        style = MaterialTheme.typography.body2,
        textAlign = TextAlign.Justify,
        modifier = Modifier.padding(8.dp)
    )
    Text(
        "― Leonardo da Vinci",
        style = MaterialTheme.typography.caption,
        modifier = Modifier.padding(start = 40.dp, bottom = 15.dp)
    )
}

@Preview
@Composable
fun HeaderPreview() {
    Header()
}
