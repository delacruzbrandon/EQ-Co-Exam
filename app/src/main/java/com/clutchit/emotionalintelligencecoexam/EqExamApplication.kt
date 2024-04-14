package com.clutchit.emotionalintelligencecoexam

import android.app.Application
import com.clutchit.emotionalintelligencecoexam.di.appModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class EqExamApplication: Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@EqExamApplication)
            modules(appModule)
        }
    }
}