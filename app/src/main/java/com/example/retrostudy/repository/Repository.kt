package com.example.retrostudy.repository

import com.example.retrostudy.service.RetrofitInstance

class Repository {
    val dogInfoService = RetrofitInstance.getDogInfoService()

}