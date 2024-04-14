package com.clutchit.emotionalintelligencecoexam

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import com.clutchit.emotionalintelligencecoexam.ui.screens.HomeScreen
import com.clutchit.emotionalintelligencecoexam.ui.theme.EmotionalIntelligenceCoExamTheme
import com.clutchit.emotionalintelligencecoexam.ui.viewmodels.HomeViewModel
import org.koin.androidx.viewmodel.ext.android.getViewModel

class MainActivity() : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            EmotionalIntelligenceCoExamTheme {
                val homeViewModel = getViewModel<HomeViewModel>()

                Surface(
                    modifier = Modifier.wrapContentHeight(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    HomeScreen(
                        homeViewModel = homeViewModel
                    )
                }
            }
        }
    }
}
