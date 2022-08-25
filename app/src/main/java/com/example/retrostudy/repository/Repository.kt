package com.example.retrostudy.repository

import com.example.retrostudy.service.GetDogInfoService
import javax.inject.Inject

class Repository @Inject constructor(val dogInfoService: GetDogInfoService)