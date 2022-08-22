package com.example.retrostudy

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.ViewModel
import com.example.retrostudy.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private val vm: DogInfoViewModel by viewModels()
    private lateinit var binding : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        binding.viewModel = vm
        binding.lifecycleOwner = this
        setContentView(binding.root)
    }
}