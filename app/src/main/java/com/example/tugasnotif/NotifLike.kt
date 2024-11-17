package com.example.tugasnotif

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent

class NotifLike : BroadcastReceiver() {
    override fun onReceive(p0: Context?, p1: Intent?) {
        val objmainlike = MainActivity()
        if(MainActivity.numberlike!=null){
            MainActivity.numberlike++
            MainActivity.binding.tvLikenum.text = MainActivity.numberlike.toString()
        }
    }

}