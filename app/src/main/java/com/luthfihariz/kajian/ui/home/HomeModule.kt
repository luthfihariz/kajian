package com.luthfihariz.kajian.ui.home

import android.arch.lifecycle.ViewModelProviders
import dagger.Module
import dagger.Provides
import luthfihariz.com.kajian.ui.home.HomeActivity

@Module
class HomeModule(val activity: HomeActivity){

    @Provides
    fun provideHomeActivity() : HomeActivity = activity

}