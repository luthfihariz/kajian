package com.luthfihariz.kajian.data.repository

import com.luthfihariz.kajian.data.model.Kajian
import io.reactivex.Observable

interface KajianRepository {

    fun getListOfKajian() : Observable<List<Kajian>>
}