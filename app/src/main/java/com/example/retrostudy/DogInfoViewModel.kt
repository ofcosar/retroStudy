package com.example.retrostudy

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.retrostudy.model.DogInfo
import com.example.retrostudy.repository.Repository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import retrofit2.Response

class DogInfoViewModel : ViewModel() {
    private var _dogInfo = MutableLiveData("dog information")
    val dogInfo: LiveData<String> get() = _dogInfo
    private var _isInfoAppeared = MutableLiveData(false)
    val isInfoAppeared: LiveData<Boolean> get() = _isInfoAppeared
    private val repository = Repository()

    fun fetchRandomInfo() {
        _isInfoAppeared.value = false
        viewModelScope.launch {
            val response : Response<DogInfo>?
            withContext(Dispatchers.IO) {
                response = repository.dogInfoService.getDogInfo()
            }
            delay(1000)
            _dogInfo.value = response?.body()?.facts?.first()
            _isInfoAppeared.value = true
        }


    }
}