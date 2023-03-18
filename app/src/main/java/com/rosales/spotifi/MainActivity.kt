package com.rosales.spotifi

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LazyColumn(
                modifier = Modifier
                    .background(appBackground())
                    .fillMaxSize()
            ) {
                item {
                    Text(text = "Album 1", style = textTitleStyle(), color = textColorTitle())
                }
                items(3) { index ->
                    ItemMusicList(
                        modifier = Modifier
                            .padding(8.dp),
                        onItemClicked = {
                            Toast.makeText(this@MainActivity, "Clicked album 1 index: $index", Toast.LENGTH_SHORT).show()
                        }
                    )
                }
                item {
                    Text(text = "Album 2", style = textTitleStyle(), color = textColorTitle())
                }
                items(5) {
                    ItemMusicList(
                        modifier = Modifier
                            .padding(8.dp)
                    )
                }
            }
        }
    }
}

@Preview
@Composable
fun ItemMusicList(modifier: Modifier = Modifier, onItemClicked: () -> Unit = {}) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .height(IntrinsicSize.Min)
            .clickable { onItemClicked() }
    ) {
        Box(
            modifier = Modifier
                .background(Color.Red)
                .aspectRatio(1f)
                .fillMaxHeight()
        ) {}
        Column(
            modifier = Modifier
                .fillMaxWidth()
        ) {
            Text(text = "Title", style = textTitleStyle(), color = textColorTitle())
            Text(text = "Content", style = textContentStyle(), color = textColorContent())
        }
    }
}

// StyleTexts.kt
@Composable
fun textTitleStyle(): TextStyle = MaterialTheme.typography.h6

@Composable
fun textContentStyle(): TextStyle = MaterialTheme.typography.body1

// Colors.kt
@Composable
fun appBackground(): Color = colorResource(R.color.app_background)

@Composable
fun textColorTitle(): Color = MaterialTheme.colors.onPrimary

@Composable
fun textColorContent(): Color = colorResource(R.color.purple_200)
