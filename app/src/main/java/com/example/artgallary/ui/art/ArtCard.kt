package com.example.artgallary.ui.art

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredHeight
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@OptIn(ExperimentalAnimationApi::class)
@Composable
fun ArtCard(image: Int, title: String, artist: String, desc: String) {
    var expandedState by remember { mutableStateOf(false) }
    Card(
        shape = RoundedCornerShape(10.dp),
        backgroundColor = MaterialTheme.colors.background,
        elevation = 10.dp,
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .padding(18.dp)
            .clickable(
                onClick = {
                    expandedState = !expandedState
                }
            )
    ) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Image(
                contentDescription = null,
                bitmap = ImageBitmap.imageResource(image),
                modifier = Modifier.requiredHeight(200.dp).fillMaxWidth(),
                contentScale = ContentScale.Crop
            )
            Text(
                text = title,
                modifier = Modifier.padding(top = 8.dp),
                color = MaterialTheme.colors.onBackground
            )
            Text(
                text = "by $artist",
                style = MaterialTheme.typography.body2,
                modifier = Modifier.padding(top = 8.dp, bottom = 8.dp),
                textAlign = TextAlign.Right,
                color = MaterialTheme.colors.primary
            )
            AnimatedVisibility(expandedState) {
                Text(
                    text = desc,
                    style = MaterialTheme.typography.body1,
                    modifier = Modifier.padding(12.dp),
                    color = MaterialTheme.colors.onBackground,
                    fontSize = 12.sp,
                    textAlign = TextAlign.Justify
                )
            }
        }
    }
}
