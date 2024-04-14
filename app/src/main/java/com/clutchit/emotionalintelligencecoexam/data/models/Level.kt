package com.clutchit.emotionalintelligencecoexam.data.models

data class LevelList(
    val levels: List<Level>
)
data class Level(
    val level: String,
    val title: String,
    val description: String,
    val state: String,
    val activities: List<Activity>
)

data class Activity(
    val id: String,
    val challengeId: String,
    val type: String,
    val title: String,
    val description: String,
    val state: String,
    val icon: Icon,
    val lockedIcon: Icon
)

data class Icon(
    val file: File,
    val title: String,
    val description: String
)

data class File(
    val url: String,
    val details: Details,
    val fileName: String,
    val contentType: String
)

data class Details(
    val size: Int
)