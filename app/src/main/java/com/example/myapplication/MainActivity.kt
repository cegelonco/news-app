package com.example.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myapplication.ui.theme.MyApplicationTheme

data class NewsItem(
    val title: String,
    val description: String,
    val imageRes: Int
)

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MyApplicationTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    NewsScreen()
                }
            }
        }
    }
}

@Composable
fun NewsScreen() {
    val newsList = listOf(
        NewsItem(
            title = "Android 15 released",
            description = "Google releases Android 15 with new privacy and battery features.",
            imageRes = R.drawable.ic_launcher_foreground
        ),
        NewsItem(
            title = "Kotlin 2.0 announced",
            description = "The Kotlin team introduces new language features and performance boosts.",
            imageRes = R.drawable.ic_launcher_background
        ),
        NewsItem(
            title = "Jetpack Compose update",
            description = "Compose gets better performance and more Material 3 components.",
            imageRes = R.drawable.ic_launcher_foreground
        ),
        NewsItem(
            title = "New Pixel phones",
            description = "Google reveals its latest Pixel devices with AI features.",
            imageRes = R.drawable.ic_launcher_background
        ),
        NewsItem(
            title = "Play Store policy changes",
            description = "New rules aim to improve app quality and security.",
            imageRes = R.drawable.ic_launcher_foreground
        ),
        NewsItem(
            title = "Security update released",
            description = "Monthly security patch fixes critical vulnerabilities.",
            imageRes = R.drawable.ic_launcher_background
        )
    )

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Text(
            text = "News",
            style = MaterialTheme.typography.headlineMedium,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(bottom = 16.dp)
        )

        Surface(
            modifier = Modifier.fillMaxSize(),
            color = Color(0xFFF9EAF9),
            shape = RoundedCornerShape(16.dp)
        ) {
            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp)
            ) {
                itemsIndexed(newsList) { index, item ->
                    NewsRow(item)

                    if (index < newsList.lastIndex) {
                        Divider(
                            color = Color.LightGray,
                            thickness = 1.dp,
                            modifier = Modifier.padding(vertical = 12.dp)
                        )
                    }
                }
            }
        }
    }
}

@Composable
fun NewsRow(item: NewsItem) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Box(
            modifier = Modifier
                .size(48.dp)
                .clip(CircleShape)
                .background(Color(0xFF4CAF50)),
            contentAlignment = Alignment.Center
        ) {
            Image(
                painter = painterResource(id = item.imageRes),
                contentDescription = null,
                modifier = Modifier.size(32.dp)
            )
        }

        Spacer(modifier = Modifier.width(16.dp))

        Column {
            Text(
                text = item.title,
                fontWeight = FontWeight.Bold,
                fontSize = 16.sp
            )
            Text(
                text = item.description,
                fontSize = 14.sp,
                color = Color.DarkGray
            )
        }
    }
}
