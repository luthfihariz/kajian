package com.luthfihariz.kajian.ui.home

import dagger.Subcomponent
import luthfihariz.com.kajian.ui.home.HomeActivity


@Subcomponent(modules = [HomeModule::class])
interface HomeComponent{
    fun inject(activity: HomeActivity)
}