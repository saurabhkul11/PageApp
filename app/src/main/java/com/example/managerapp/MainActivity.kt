package com.example.managerapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.managerapp.api.ApiService
import com.example.managerapp.api.RetrofitHelper
import com.example.managerapp.databinding.ActivityMainBinding
import com.example.managerapp.repo.MyRepository
import com.example.managerapp.view.adapter.ProductAdapter
import com.example.managerapp.viewmodel.MyViewModel
import com.example.managerapp.factory.MyViewModelFactory

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    lateinit var viewModel: MyViewModel
    lateinit var adp: ProductAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= DataBindingUtil.setContentView(this,R.layout.activity_main)

//        var viewModel= MyViewModel(repository)
//        binding.data=viewModel
//        binding.lifecycleOwner=this

         getDetails()
        viewModel.getdata()
        binding.btn.visibility=View.GONE

    }

    fun getDetails(){
        val api= RetrofitHelper.getInstance().create(ApiService::class.java)
        viewModel=ViewModelProvider(this, MyViewModelFactory(MyRepository(api))).get(MyViewModel::class.java)
        viewModel.ldata.observe(this, Observer {
            adp= ProductAdapter(this, it)
            binding.recv.apply {
                layoutManager=LinearLayoutManager(context)
                adapter=adp

            }
        })

    }

}

