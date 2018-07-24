package com.luthfihariz.kajian.common.extension

import com.luthfihariz.kajian.data.Resource
import io.reactivex.Observable
import io.reactivex.rxkotlin.subscribeBy

fun <T : Any> Observable<T>.asResource() : Resource<T>{

    subscribeBy(
            onError = {

            },
            onNext = {

            }
    )
}