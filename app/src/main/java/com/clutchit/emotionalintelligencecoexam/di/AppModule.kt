package com.clutchit.emotionalintelligencecoexam.di

import com.clutchit.emotionalintelligencecoexam.data.repositories.ChapterRepository
import com.clutchit.emotionalintelligencecoexam.data.repositories.ChapterRepositoryImpl
import com.clutchit.emotionalintelligencecoexam.ui.viewmodels.HomeViewModel
import com.clutchit.emotionalintelligencecoexam.util.Constants
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val appModule = module {
    single {
        Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(
                ChapterRepository::class.java
            )
    }
    single { ChapterRepositoryImpl(get()) }

    viewModel {
        HomeViewModel(get())
    }
}