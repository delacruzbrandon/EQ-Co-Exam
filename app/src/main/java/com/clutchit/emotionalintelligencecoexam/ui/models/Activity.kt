package com.clutchit.emotionalintelligencecoexam.ui.models

data class Activity(
    val id: String,
    val challenge: String,
    val type: String,
    val title: String,
    val title2: String? = "",
    val description: String,
    val description2: String? = "",
    val state: String,
    val icon: Icon
)
