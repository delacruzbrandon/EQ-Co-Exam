package com.clutchit.emotionalintelligencecoexam.ui.models

data class Level(
    val level: String,
    val title: String,
    val description: String,
    val state: String,
    val activities: List<Activity>
)