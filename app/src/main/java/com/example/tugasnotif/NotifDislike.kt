package com.example.tugasnotif

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent

class NotifDislike : BroadcastReceiver() {
    override fun onReceive(p0: Context?, p1: Intent?) {
        val objmaindislike = MainActivity()
        if(MainActivity.numberdislike!=null) {
            MainActivity.numberdislike++
            MainActivity.binding.tvDislikenum.text = MainActivity.numberdislike.toString()
        }
    }
}