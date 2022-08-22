package com.example.retrostudy.model

import com.google.gson.annotations.SerializedName

data class DogInfo(

    @SerializedName("facts"   ) var facts   : ArrayList<String> = arrayListOf(),
    @SerializedName("success" ) var success : Boolean?          = null

)