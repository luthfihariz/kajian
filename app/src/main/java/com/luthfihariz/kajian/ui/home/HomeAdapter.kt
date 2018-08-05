package com.luthfihariz.kajian.ui.home

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.luthfihariz.kajian.R
import com.luthfihariz.kajian.common.extension.formatTimestamp
import com.luthfihariz.kajian.data.model.Kajian
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.item_kajian.view.*

class HomeAdapter : RecyclerView.Adapter<HomeAdapter.HomeViewHolder>() {

    var listOfKajian : List<Kajian> = ArrayList()

    fun update(items: List<Kajian>?) {
        items?.let {
            listOfKajian = it
            notifyDataSetChanged()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeViewHolder {
        return HomeViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_kajian, parent, false))
    }

    override fun getItemCount(): Int  = listOfKajian.size

    override fun onBindViewHolder(holder: HomeViewHolder, position: Int) {
        holder.bind(listOfKajian[position])
    }

    class HomeViewHolder(val view: View) : RecyclerView.ViewHolder(view) {

        fun bind(kajian: Kajian) {
            view.tvTitle.text =  kajian.title
            view.tvUstadz.text = kajian.ustadz
            view.tvStartDate.text = kajian.startDate.formatTimestamp("dd MMMM yyyy hh:mm")
            view.tvPlace.text = kajian.place + " " + kajian.city
            if(kajian.main_images.isNotEmpty()){
                Picasso.get().load(kajian.main_images).into(view.ivThumbnail)
            }
        }
    }
}

