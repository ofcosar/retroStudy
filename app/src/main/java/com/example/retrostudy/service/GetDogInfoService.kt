package com.example.retrostudy.service

import com.example.retrostudy.model.DogInfo
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET

interface GetDogInfoService {

    @GET("api/facts")
    suspend fun getDogInfo(): Response<DogInfo>


}