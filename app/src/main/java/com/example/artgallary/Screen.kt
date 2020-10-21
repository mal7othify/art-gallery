package com.example.artgallary

import androidx.compose.animation.animatedFloat
import androidx.compose.foundation.Image
import androidx.compose.foundation.ScrollableColumn
import androidx.compose.foundation.Text
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.preferredHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.state
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.ui.tooling.preview.Preview
import com.example.artgallary.ui.ArtGallaryTheme


@Composable
fun Screen() {
    Column {
        TopAppBar(
            title = { Text(text = "Art Gallery") },
            backgroundColor = MaterialTheme.colors.primary,
            contentColor = Color.White
        )
        Content()
    }
}

@Composable
fun Content() {
    ScrollableColumn {
        Art(
            R.drawable.p1, "Home mini image found in unsplash", "Lorem Ipsum is simply dummy " +
                    "text of the printing and typesetting industry. Lorem Ipsum has been the industry's " +
                    "standard dummy text ever since the 1500s, when an unknown printer took a galley of " +
                    "type and scrambled it to make a type specimen book. It has survived not only five " +
                    "centuries, but also the leap into electronic typesetting, remaining essentially" +
                    " unchanged. It was popularised in the 1960s with the release of Letraset sheets " +
                    "containing Lorem Ipsum passages, and more recently with desktop publishing software " +
                    "like Aldus PageMaker including versions of Lorem Ipsum."
        )
        Art(
            R.drawable.p2, "Pixel phone image found in unsplash", "Lorem Ipsum is simply dummy " +
                    "text of the printing and typesetting industry. Lorem Ipsum has been the industry's " +
                    "standard dummy text ever since the 1500s, when an unknown printer took a galley of " +
                    "type and scrambled it to make a type specimen book. It has survived not only five " +
                    "centuries, but also the leap into electronic typesetting, remaining essentially" +
                    " unchanged. It was popularised in the 1960s with the release of Letraset sheets " +
                    "containing Lorem Ipsum passages, and more recently with desktop publishing software " +
                    "like Aldus PageMaker including versions of Lorem Ipsum."
        )
        Art(
            R.drawable.p3, "Pixel Buds image found in unsplash", "Lorem Ipsum is simply dummy " +
                    "text of the printing and typesetting industry. Lorem Ipsum has been the industry's " +
                    "standard dummy text ever since the 1500s, when an unknown printer took a galley of " +
                    "type and scrambled it to make a type specimen book. It has survived not only five " +
                    "centuries, but also the leap into electronic typesetting, remaining essentially" +
                    " unchanged. It was popularised in the 1960s with the release of Letraset sheets " +
                    "containing Lorem Ipsum passages, and more recently with desktop publishing software " +
                    "like Aldus PageMaker including versions of Lorem Ipsum."
        )
    }
}

@Composable
fun Art(image: Int, title: String, desc: String) {
    val expandedState = state { false }
    val viewHeight = if (expandedState.value) animatedFloat(450f)
    else animatedFloat(280f)
    Card(
        shape = RoundedCornerShape(10.dp),
        backgroundColor = Color.White,
        elevation = 10.dp,
        modifier = Modifier
            .fillMaxWidth().preferredHeight(viewHeight.value.dp)
            .padding(18.dp)
            .clickable(
                onClick = {
                    expandedState.value = !expandedState.value
                }
            )
    ) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            val imageModifier = Modifier.preferredHeight(200.dp)
                .fillMaxWidth()
            Image(
                imageResource(id = image),
                imageModifier,
                contentScale = ContentScale.Crop
            )
            Text(
                text = title,
                modifier = Modifier.padding(8.dp),
                color = Color.DarkGray
            )
            Text(
                text = desc,
                modifier = Modifier.padding(12.dp),
                color = Color.DarkGray,
                fontSize = 12.sp,
                textAlign = TextAlign.Justify
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ScreenPreview() {
    ArtGallaryTheme {
        Screen()
    }
}

@Preview(showBackground = true)
@Composable
fun ContentPreview() {
    ArtGallaryTheme {
        Content()
    }
}