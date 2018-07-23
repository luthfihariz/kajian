package com.luthfihariz.kajian.di

import com.luthfihariz.kajian.KajianApplication
import dagger.Module
import dagger.Provides

@Module
class AppModule(var application : KajianApplication){

    @Provides
    fun provideApplicationContext() : KajianApplication = application

}