package com.example.managerapp.repo

import com.example.managerapp.api.ApiService

class MyRepository(private var apiService: ApiService) {
  suspend  fun getData()=apiService.getData()

}