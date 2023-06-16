package com.example.managerapp.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.cachedIn
import com.example.managerapp.repo.PagingRepository

class PagingViewModel(private var repository: PagingRepository):ViewModel() {

    val data=repository.getData().cachedIn(viewModelScope)


}