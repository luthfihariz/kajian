package com.luthfihariz.kajian.data.model

import com.google.gson.annotations.SerializedName

data class Kajian (val id : Int,
                   val title : String,
                   val images : ArrayList<String>,
                   val main_images : String,
                   val lat : Double,
                   val long : Double,
                   val place : String,
                   val city: String,
                   val ustadz : String,
                   @SerializedName("full_address") val fullAddress : String )