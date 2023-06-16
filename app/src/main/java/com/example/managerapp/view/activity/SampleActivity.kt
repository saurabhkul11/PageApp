package com.example.managerapp.view.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.managerapp.R
import com.example.managerapp.viewmodel.SampleViewModel
import com.example.managerapp.databinding.ActivitySampleBinding

class SampleActivity : AppCompatActivity() {
    lateinit var binding: ActivitySampleBinding
    lateinit var viewModel: SampleViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= DataBindingUtil.setContentView(this, R.layout.activity_sample)

        viewModel=ViewModelProvider(this).get(SampleViewModel::class.java)
        binding.mydata=viewModel
        binding.lifecycleOwner=this

    }
}