package com.luthfihariz.kajian.ui.home

import android.app.job.JobInfo
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import com.helpster.staff.common.rx.SchedulerProvider
import com.luthfihariz.kajian.data.Resource
import com.luthfihariz.kajian.data.model.Kajian
import com.luthfihariz.kajian.data.repository.KajianRepository
import com.luthfihariz.kajian.ui.base.BaseViewModel
import io.reactivex.rxkotlin.subscribeBy

class HomeViewModel(repository: KajianRepository, scheduler:  SchedulerProvider) : ViewModel(){

    val listOfKajianResource = MutableLiveData<Resource<List<Kajian>>>()

    init {
        listOfKajianResource.postValue(Resource.loading(null))
        repository.getListOfKajian()
                .observeOn(scheduler.ui())
                .subscribeOn(scheduler.io())
                .subscribeBy(
                        onNext = {
                            listOfKajianResource.postValue(Resource.success(it))
                        },
                        onError = {
                            listOfKajianResource.postValue(Resource.error(it.message))
                        }
                )
    }

}