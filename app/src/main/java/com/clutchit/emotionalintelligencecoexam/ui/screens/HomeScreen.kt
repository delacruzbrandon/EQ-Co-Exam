package com.clutchit.emotionalintelligencecoexam.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import com.clutchit.emotionalintelligencecoexam.ui.viewmodels.HomeViewModel

@Composable
fun HomeScreen (
    homeViewModel: HomeViewModel
) {
    val modifier = Modifier
    val levelListState by homeViewModel.levelList.collectAsState()

    LaunchedEffect(key1 = true) {
        homeViewModel.getLevelList()
    }

    Scaffold(
        topBar = { HomeTopBar() },
        content = { contentPadding ->
            Column(
                modifier = modifier.padding(contentPadding)
            ) {
                HomeContent(
                    levelListState = levelListState
                )
            }
        }
    )
}