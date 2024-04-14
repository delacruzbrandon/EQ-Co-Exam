package com.clutchit.emotionalintelligencecoexam.ui.viewmodels

import kotlinx.coroutines.runBlocking
import com.clutchit.emotionalintelligencecoexam.levelsJson
import com.clutchit.emotionalintelligencecoexam.data.models.LevelList
import com.clutchit.emotionalintelligencecoexam.data.repositories.ChapterRepositoryImpl
import com.clutchit.emotionalintelligencecoexam.data.repositories.ChapterRepository
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import junit.framework.TestCase.assertNull
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.setMain
import okhttp3.OkHttpClient
import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.MockWebServer
import org.junit.After
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class HomeViewModelTest {
    private val dispatcher = Dispatchers
    private val mockWebServer = MockWebServer()
    private val okHttpClient = OkHttpClient.Builder().build()
    val gson = Gson()

    private lateinit var viewModel: HomeViewModel
    private lateinit var chapterRepository: ChapterRepositoryImpl
    private lateinit var chapterService: ChapterRepository
    private lateinit var retrofit: Retrofit

    @OptIn(ExperimentalCoroutinesApi::class)
    @Before
    fun setUp() {
        dispatcher.setMain(Dispatchers.Unconfined)
        retrofit = Retrofit.Builder()
            .baseUrl(mockWebServer.url("/"))
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        chapterService = retrofit.create(ChapterRepository::class.java)
        chapterRepository = ChapterRepositoryImpl(chapterService)

        viewModel = HomeViewModel(chapterRepository)
    }

    @OptIn(ExperimentalCoroutinesApi::class)
    @After
    fun tearDown() {
        dispatcher.resetMain()
    }

    @Test
    fun `testing levels fetch`() = runBlocking {
        val levelResponse = MockResponse().setResponseCode(200).setBody(levelsJson.trimIndent())
        mockWebServer.enqueue(response = levelResponse)

        val levelResults = viewModel.getLevelList()

        // Parser for levelsJson String
        val levelListType = object : TypeToken<LevelList>() {}.type
        val expectedLevelList: LevelList = gson.fromJson(levelsJson.trimIndent(), levelListType)

        Assert.assertEquals(expectedLevelList, levelResults)
    }

    @Test
    fun `testing failure level fetch`() = runBlocking {
        val levelResponse = MockResponse().setResponseCode(400).setBody("Bad Request")
        mockWebServer.enqueue(response = levelResponse)

        val levelResults = viewModel.simpleGetLevelList()

        assertNull(levelResults)
    }
}