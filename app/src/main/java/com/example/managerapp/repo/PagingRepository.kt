package com.example.managerapp.repo

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.liveData
import com.example.managerapp.api.ApiService
import com.example.managerapp.paging.ProductResource

class PagingRepository(val apiService: ApiService) {

    fun getData()= Pager(
        config = PagingConfig(5,12, maxSize = 40),
        pagingSourceFactory = {ProductResource(apiService)}
    ).liveData
}