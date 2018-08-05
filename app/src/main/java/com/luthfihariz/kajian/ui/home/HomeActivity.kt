package com.luthfihariz.kajian.ui.home

import android.arch.lifecycle.Observer
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.widget.LinearLayoutManager
import android.widget.Toast
import com.luthfihariz.kajian.R
import com.luthfihariz.kajian.common.extension.gone
import com.luthfihariz.kajian.common.extension.visible
import com.luthfihariz.kajian.data.Resource
import com.luthfihariz.kajian.data.Status
import com.luthfihariz.kajian.data.model.Kajian
import com.luthfihariz.kajian.ui.base.BaseActivity
import kotlinx.android.synthetic.main.activity_home.*
import kotlinx.android.synthetic.main.view_toolbar.*
import org.koin.android.architecture.ext.viewModel

class HomeActivity : BaseActivity(){

    val viewModel by viewModel<HomeViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        setupRecyclerView()
        setupToolbar()
        viewModel.listOfKajianResource.observe(this, Observer<Resource<List<Kajian>>> { t -> observer(t) })
    }

    private fun setupToolbar() {
        setSupportActionBar(toolbar)
        supportActionBar?.let {
            it.title = "Jadwal Kajian"
        }
    }

    private fun setupRecyclerView(){
        rvListOfKajian.layoutManager = LinearLayoutManager(this)
        rvListOfKajian.adapter = HomeAdapter()
    }

    private fun observer(value: Resource<List<Kajian>>?) {
        when(value?.status){
            Status.LOADING -> {
                pbLoading.visible()
            }
            Status.ERROR -> {
                pbLoading.gone()
                Toast.makeText(this, value.error, Toast.LENGTH_LONG).show()
            }
            Status.SUCCESS -> {
                pbLoading.gone()
                (rvListOfKajian.adapter as HomeAdapter).update(value.data)
            }
        }
    }
}