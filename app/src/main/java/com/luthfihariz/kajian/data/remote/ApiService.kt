package com.luthfihariz.kajian.data.remote

import com.luthfihariz.kajian.data.model.Kajian
import io.reactivex.Observable
import retrofit2.http.GET

interface ApiService{

    @GET("kajian")
    fun getListOfKajian() : Observable<List<Kajian>>

}