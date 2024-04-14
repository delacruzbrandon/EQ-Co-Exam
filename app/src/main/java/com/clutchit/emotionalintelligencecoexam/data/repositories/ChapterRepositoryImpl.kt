package com.clutchit.emotionalintelligencecoexam.data.repositories

import com.clutchit.emotionalintelligencecoexam.data.models.LevelList
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Response
//business logic related to data retrieval and manipulation here (How is it retrieved)
class ChapterRepositoryImpl(
    private val chapterRepository: ChapterRepository
) : ChapterRepository {

    override suspend fun fetchLevels(): Response<LevelList> {
        return withContext(Dispatchers.IO) {
            chapterRepository.fetchLevels()
        }
    }
    override suspend fun simpleTestFetchLevelList(): LevelList {
        return withContext(Dispatchers.IO) {
            chapterRepository.simpleTestFetchLevelList()
        }
    }

}