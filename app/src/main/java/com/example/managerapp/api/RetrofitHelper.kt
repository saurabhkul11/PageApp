package com.example.managerapp.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitHelper {

    //val baseUrl = "https://dummyjson.com/"
    val BASEURL="https://api.quotable.io/"

    fun getInstance(): Retrofit {
        return Retrofit.Builder().baseUrl(BASEURL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

}