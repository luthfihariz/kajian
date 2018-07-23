package com.luthfihariz.kajian.ui.base

import android.os.Bundle
import android.os.PersistableBundle
import android.support.v7.app.AppCompatActivity
import com.luthfihariz.kajian.KajianApplication
import com.luthfihariz.kajian.di.AppComponent

abstract class BaseActivity : AppCompatActivity(){

    val component : AppComponent
        get() = (application as KajianApplication).appComponent

    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)

        setupActivityComponent()
    }

    abstract fun setupActivityComponent()

}
