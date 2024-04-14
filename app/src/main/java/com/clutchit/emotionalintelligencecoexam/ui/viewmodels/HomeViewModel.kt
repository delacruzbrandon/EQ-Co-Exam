package com.clutchit.emotionalintelligencecoexam.ui.viewmodels

import android.util.Log
import androidx.lifecycle.ViewModel
import com.clutchit.emotionalintelligencecoexam.data.models.Activity
import com.clutchit.emotionalintelligencecoexam.data.models.LevelList
import com.clutchit.emotionalintelligencecoexam.data.repositories.ChapterRepository
import com.clutchit.emotionalintelligencecoexam.util.RequestState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import retrofit2.HttpException

class HomeViewModel(
    private val chapterRepository: ChapterRepository
) : ViewModel() {

    fun printSomething() {
        Log.d("HomeViewModel", "printSomething: Koin is working?")
    }

    val dayList = listOf(
        "MON",
        "TUE",
        "WEN",
        "THU",
        "FRI",
        "SAT",
        "SUN",
    )

    private val _levelList = MutableStateFlow<RequestState<LevelList>>(RequestState.Idle)
    val levelList: StateFlow<RequestState<LevelList>> = _levelList

    suspend fun simpleGetLevelList(): LevelList { // For Testing
        return chapterRepository.simpleTestFetchLevelList()
    }

    suspend fun getLevelList() {
        if (_levelList.value is RequestState.Idle)
            _levelList.value = RequestState.Loading

        try {
            val response = chapterRepository.fetchLevels()
            val levels = response.body()
            if (response.isSuccessful && levels != null) {
                _levelList.value = RequestState.Success(levels)
            } else {
                println("${response.errorBody()}")
                _levelList.value = RequestState.Idle
            }
        } catch (e: HttpException) {
            println("fetchLevelListFromApi $e")
            _levelList.value = RequestState.Error(e)
        }

    }
}