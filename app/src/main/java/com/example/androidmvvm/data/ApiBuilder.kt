package com.example.androidmvvm.data

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/****
 *
 * Use this api url for testing : {https://pokeapi.co/api/v2/}
 *
 *
 * ****/

class ApiBuilder {

    fun createService() : Retrofit {
        val client = OkHttpClient.Builder()
            .build()

        return Retrofit.Builder()
            .baseUrl("[your-api-url]")
            .addConverterFactory(GsonConverterFactory.create())
            .client(client)
            .build()
    }

}