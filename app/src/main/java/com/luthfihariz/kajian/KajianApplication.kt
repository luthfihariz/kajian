package com.luthfihariz.kajian

import android.app.Application
import com.luthfihariz.kajian.di.AppComponent
import com.luthfihariz.kajian.di.DaggerAppComponent

class KajianApplication : Application() {

    val appComponent: AppComponent
        get() = DaggerAppComponent.create()

    override fun onCreate() {
        super.onCreate()
    }
}