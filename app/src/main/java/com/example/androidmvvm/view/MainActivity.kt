package com.example.androidmvvm.view

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.example.androidmvvm.R
import com.example.androidmvvm.data.ApiBuilder
import com.example.androidmvvm.model.repository.MainRepository
import com.example.androidmvvm.viewmodel.MainViewModel
import com.example.androidmvvm.viewmodel.MainViewModelFactory

class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        
        val repo = MainRepository(ApiBuilder())
        val factory = MainViewModelFactory(repo)
        viewModel = ViewModelProvider(this, factory)[MainViewModel::class.java]

        fetchInfo()
        setupObservers()
    }

    private fun fetchInfo() {
        viewModel.getData()
    }

    private fun setupObservers()  {
        viewModel.data.observe(this) {
            findViewById<TextView>(R.id.tv_main).text = it.response.toString()
        }

        viewModel.error.observe(this) {
            findViewById<TextView>(R.id.tv_main).text = "Endpoint call error"

        }
    }
}
