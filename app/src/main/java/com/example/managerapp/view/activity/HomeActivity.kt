package com.example.managerapp.view.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.example.managerapp.MainActivity
import com.example.managerapp.R
import com.example.managerapp.databinding.ActivityHomeBinding

class HomeActivity : AppCompatActivity() {
    lateinit var binding: ActivityHomeBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= DataBindingUtil.setContentView(this, R.layout.activity_home)
        binding.homeBtn.setOnClickListener {
            val intent=Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
        binding.nextBtn.setOnClickListener {
            val intent=Intent(this, SampleActivity::class.java)
            startActivity(intent)
        }
    }
}