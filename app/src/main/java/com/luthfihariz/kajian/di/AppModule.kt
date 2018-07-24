package com.luthfihariz.kajian.di

import com.google.gson.GsonBuilder
import com.helpster.staff.common.rx.SchedulerProvider
import com.helpster.staff.common.rx.SchedulerProviderImpl
import com.luthfihariz.kajian.BuildConfig
import com.luthfihariz.kajian.data.remote.ApiService
import com.luthfihariz.kajian.data.repository.KajianRepository
import com.luthfihariz.kajian.data.repository.KajianRepositoryImpl
import com.luthfihariz.kajian.ui.home.HomeViewModel
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.android.architecture.ext.viewModel
import org.koin.dsl.module.applicationContext
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit


val appModule = applicationContext {

    viewModel { HomeViewModel(get(), get()) }

    bean { KajianRepositoryImpl(get()) as KajianRepository }

    bean {
        SchedulerProviderImpl() as SchedulerProvider
    }

    bean {
        Retrofit.Builder()
                .baseUrl(BuildConfig.API_URL)
                .client(get())
                .addConverterFactory(GsonConverterFactory.create(GsonBuilder().setLenient().serializeNulls().create()))
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build()
                .create(ApiService::class.java)
    }

    bean {
        val httpLoggingInterceptor = HttpLoggingInterceptor()
        httpLoggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
        OkHttpClient.Builder()
                .addInterceptor(httpLoggingInterceptor)
                .readTimeout(120, TimeUnit.SECONDS)
                .connectTimeout(120, TimeUnit.SECONDS)
                .build()
    }
}