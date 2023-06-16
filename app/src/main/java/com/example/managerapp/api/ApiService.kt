package com.example.managerapp.api

import com.example.managerapp.PageData
import com.example.managerapp.model.Product
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("products")
    suspend fun getData():Response<Product>
    @GET("quotes")
    suspend fun getpageData(@Query("page_no")page:Int):PageData

}