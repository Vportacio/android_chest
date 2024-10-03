package com.example.androidmvvm.model.repository

import com.example.androidmvvm.data.ApiBuilder
import com.example.androidmvvm.data.service.MainService

class MainRepository( private val service: ApiBuilder ) {

    fun getData() = getMainService().getData()

    /***
     *
     * USE fun getData() = getMainService().getTestData()
     * for test real endpoint
     * ****/

    private fun getMainService() = service.createService().create(MainService::class.java)
}