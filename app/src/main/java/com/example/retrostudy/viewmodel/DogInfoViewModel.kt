package com.example.retrostudy.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.retrostudy.model.DogInfo
import com.example.retrostudy.repository.Repository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import retrofit2.Response
import javax.inject.Inject
@HiltViewModel
class DogInfoViewModel @Inject constructor(private val repository: Repository) : ViewModel() {
    private var _dogInfo = MutableLiveData("dog information")
    val dogInfo: LiveData<String> get() = _dogInfo
    private var _isInfoAppeared = MutableLiveData(false)
    val isInfoAppeared: LiveData<Boolean> get() = _isInfoAppeared


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