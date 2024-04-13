package com.clutchit.emotionalintelligencecoexam.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun HomeScreen() {
    val modifier = Modifier
    Scaffold(
        topBar = { HomeTopBar() },
        content = { contentPadding ->
            Column(
                modifier = modifier.padding(contentPadding)
            ) {
                HomeContent()
            }
        }
    )
}

@Preview
@Composable
fun PreviewHomeScreen() {
    HomeScreen()
}
