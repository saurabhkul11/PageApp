package com.example.managerapp.view.activity

import android.content.Intent.ACTION_AIRPLANE_MODE_CHANGED
import android.content.IntentFilter
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.managerapp.util.AiroplaneBroadcast
import com.example.managerapp.R

class NotifyActivity : AppCompatActivity() {
    lateinit var airoplaneBroadcast: AiroplaneBroadcast
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_notify)


        airoplaneBroadcast= AiroplaneBroadcast()

        IntentFilter(ACTION_AIRPLANE_MODE_CHANGED).apply {
            registerReceiver(airoplaneBroadcast,this)
        }
    }
    override fun onStop() {
        super.onStop()
        unregisterReceiver(airoplaneBroadcast)
    }
}