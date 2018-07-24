package com.luthfihariz.kajian.data.repository

import com.luthfihariz.kajian.data.model.Kajian
import com.luthfihariz.kajian.data.remote.ApiService
import io.reactivex.Observable

class KajianRepositoryImpl(val apiService: ApiService) : KajianRepository{

    override fun getListOfKajian(): Observable<List<Kajian>> = apiService.getListOfKajian()
}