package com.example.managerapp.view.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.get
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.managerapp.R
import com.example.managerapp.api.ApiService
import com.example.managerapp.api.RetrofitHelper
import com.example.managerapp.factory.PagingViewModelFactory
import com.example.managerapp.repo.PagingRepository
import com.example.managerapp.view.adapter.LoadAdapter
import com.example.managerapp.view.adapter.ProductPagingAdapter
import com.example.managerapp.viewmodel.PagingViewModel

class PageActivity : AppCompatActivity() {
    lateinit var viewModel: PagingViewModel
    lateinit var adp:ProductPagingAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_page)

        val recyclerView=findViewById<RecyclerView>(R.id.rec_view)
        adp= ProductPagingAdapter()
        recyclerView.apply {
            layoutManager=LinearLayoutManager(this@PageActivity)
            adapter=adp.withLoadStateHeaderAndFooter(
                header = LoadAdapter(),
                footer = LoadAdapter()
            )
        }
        val api= RetrofitHelper.getInstance().create(ApiService::class.java)
        viewModel=ViewModelProvider(this,PagingViewModelFactory(PagingRepository(api))).get(PagingViewModel::class.java)

        viewModel.data.observe(this, Observer {
            adp.submitData(lifecycle,it)
        })


    }
}