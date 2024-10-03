package com.example.androidmvvm.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.androidmvvm.model.MainResponse
import com.example.androidmvvm.model.repository.MainRepository
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainViewModel(
    private val repo: MainRepository ): ViewModel() {

    private val _data = MutableLiveData<MainResponse>()
    val data: LiveData<MainResponse> = _data

    private val _error = MutableLiveData<String>()
    val error: LiveData<String> = _error


    fun getData() {
        repo.getData().enqueue( object : Callback<Any> {

            override fun onResponse(call: Call<Any>, response: Response<Any>) {
                response.body()?.let {
                        _data.postValue( MainResponse(it.toString()) )
                    } ?: _error.postValue("Error")
                }

                override fun onFailure(call: Call<Any>, t: Throwable) {
                }
            }
        )
    }
}