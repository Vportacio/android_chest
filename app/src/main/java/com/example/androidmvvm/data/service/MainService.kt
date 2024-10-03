package com.example.androidmvvm.data.service

import com.example.androidmvvm.model.MainResponse
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET

interface MainService {

    @GET("/[try-your-endpoint]")
    fun getData(): Call<Any>


    /**
     * Use this endpoint for testing
     *
     * **/
    @GET("pokemon/ditto")
    fun getTestData(): Call<Any>
}