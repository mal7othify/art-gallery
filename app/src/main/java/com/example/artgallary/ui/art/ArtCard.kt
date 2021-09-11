package com.example.artgallary.ui.art

import android.content.res.Configuration
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.expandIn
import androidx.compose.animation.expandVertically
import androidx.compose.animation.shrinkOut
import androidx.compose.animation.shrinkVertically
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
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ExpandLess
import androidx.compose.material.icons.filled.ExpandMore
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.artgallary.model.Arts

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
                modifier = Modifier
                    .requiredHeight(200.dp)
                    .fillMaxWidth(),
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
                modifier = Modifier.padding(vertical = 8.dp),
                textAlign = TextAlign.Right,
                color = MaterialTheme.colors.primary
            )
            Image(
                modifier = Modifier
                    .fillMaxWidth()
                    .align(Alignment.CenterHorizontally)
                    .padding(bottom = 8.dp),
                imageVector = if (expandedState) Icons.Filled.ExpandLess else Icons.Filled.ExpandMore,
                contentDescription = null,
                colorFilter = ColorFilter.tint(MaterialTheme.colors.onSurface)
            )
            AnimatedVisibility(
                visible = expandedState,
                enter = expandIn() + expandVertically(),
                exit = shrinkOut() + shrinkVertically(),
            ) {
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

@Preview(name = "Light theme", showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_NO)
@Preview(name = "Dark theme", showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun ArtCardPreview() {
    ArtCard(
        Arts[0].imageRes,
        Arts[0].title,
        Arts[0].artist,
        Arts[0].description,
    )
}