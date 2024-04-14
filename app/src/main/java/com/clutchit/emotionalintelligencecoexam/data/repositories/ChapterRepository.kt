package com.clutchit.emotionalintelligencecoexam.data.repositories

import com.clutchit.emotionalintelligencecoexam.data.models.LevelList
import com.clutchit.emotionalintelligencecoexam.util.Constants
import retrofit2.Response
import retrofit2.http.GET


// Define End Points methods here
interface ChapterRepository {
    @GET(Constants.CHAPTER_LIST_END_POINT)
    suspend fun fetchLevels(): Response<LevelList>

    @GET(Constants.CHAPTER_LIST_END_POINT)
    suspend fun simpleTestFetchLevelList(): LevelList // For testing

}