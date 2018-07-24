package com.luthfihariz.kajian.ui.home

import android.arch.lifecycle.Observer
import android.os.Bundle
import com.luthfihariz.kajian.R
import com.luthfihariz.kajian.data.Resource
import com.luthfihariz.kajian.data.Status
import com.luthfihariz.kajian.data.model.Kajian
import com.luthfihariz.kajian.ui.base.BaseActivity
import kotlinx.android.synthetic.main.activity_home.*
import org.koin.android.architecture.ext.viewModel

class HomeActivity : BaseActivity(){

    val viewModel by viewModel<HomeViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)


        viewModel.listOfKajianResource.observe(this, Observer<Resource<List<Kajian>>> { t -> observer(t) })
    }

    private fun observer(value: Resource<List<Kajian>>?) {
        when(value?.status){
            Status.LOADING -> {}
            Status.ERROR -> {}
            Status.SUCCESS -> {
                tvResponse.text = value.data.toString()
            }
        }
    }
}