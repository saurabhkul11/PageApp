package com.example.managerapp.util

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.widget.Toast

class AiroplaneBroadcast : BroadcastReceiver() {
    override fun onReceive(context: Context?, intent: Intent?) {

        //val isAirplaneModeEnabled = intent?.getBooleanExtra("state", false) ?: return

        if (intent != null) {
            if (intent.action== Intent.ACTION_AIRPLANE_MODE_CHANGED) {
                Toast.makeText(context, "Airplane Mode Enabled", Toast.LENGTH_LONG).show()
            } else if(intent.action==Intent.ACTION_POWER_CONNECTED) {
                Toast.makeText(context, "Power Enabled", Toast.LENGTH_LONG).show()
            }
            else if(intent.action==Intent.ACTION_POWER_DISCONNECTED){
                Toast.makeText(context, "Power Disabled", Toast.LENGTH_LONG).show()

            }
        }
    }
}