package com.example.managerapp.factory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.managerapp.repo.PagingRepository
import com.example.managerapp.viewmodel.MyViewModel
import com.example.managerapp.viewmodel.PagingViewModel

class PagingViewModelFactory(private var repository: PagingRepository):ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(PagingViewModel::class.java)) {
            return PagingViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }

}