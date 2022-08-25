package com.example.retrostudy.dependencyinjection

import com.example.retrostudy.service.GetDogInfoService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DIModule {
   @Singleton
   @Provides
   fun provideRetrofitInstance() :GetDogInfoService{
            val baseUrl ="https://dog-api.kinduff.com/"
            val retrofitInstance = Retrofit.Builder()
           .baseUrl(baseUrl)
           .addConverterFactory(GsonConverterFactory.create())
           .build()

       return retrofitInstance.create(GetDogInfoService::class.java)
   }

}