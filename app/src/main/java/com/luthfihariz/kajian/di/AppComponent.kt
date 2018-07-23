package com.luthfihariz.kajian.di

import com.luthfihariz.kajian.ui.home.HomeComponent
import com.luthfihariz.kajian.ui.home.HomeModule
import javax.inject.Singleton
import dagger.Component

@Singleton
@Component(modules = [AppModule::class, NetworkModule::class])
interface AppComponent{

    fun plus(module: HomeModule) : HomeComponent

}
