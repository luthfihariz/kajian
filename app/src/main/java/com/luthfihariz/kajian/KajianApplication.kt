package com.luthfihariz.kajian

import android.app.Application
import com.luthfihariz.kajian.di.appModule
import org.koin.android.ext.android.startKoin

class KajianApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin(this, arrayListOf(appModule))
    }
}