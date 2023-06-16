package com.example.managerapp.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.managerapp.repo.MyRepository
import com.example.managerapp.model.ProductData
import kotlinx.coroutines.launch

class MyViewModel(private val repository: MyRepository) :ViewModel() {

//    private var mdata:MutableLiveData<UserData>
//        = MutableLiveData()
//
//    var ldata:LiveData<UserData> =mdata
private var mdata:MutableLiveData<List<ProductData>>
        = MutableLiveData()

    var ldata:LiveData<List<ProductData>> =mdata


//
//        viewModelScope.launch {
//            delay(1000)
//            mdata.postValue(UserData("animal","lion",8))
//            delay(4000)
//            mdata.postValue(UserData("bird","parrot",8))
//            delay(4000)
//            mdata.postValue(UserData("fish","whale",8))
//        }

       fun getdata(){
           viewModelScope.launch {
               val response=repository.getData()
               mdata.postValue(response.body()?.products)
           }

       }

}