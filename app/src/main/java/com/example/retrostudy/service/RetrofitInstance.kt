package com.example.retrostudy.service

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitInstance {
    companion object{
        private var retrofitInstance :Retrofit? = null
        private val BASE_URL ="https://dog-api.kinduff.com/"
        fun getDogInfoService() : GetDogInfoService{
            if (retrofitInstance == null){
                retrofitInstance = Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
            }
            return retrofitInstance!!.create(GetDogInfoService::class.java)
        }
    }

}