package com.example.tugasnotif

import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.graphics.BitmapFactory
import android.os.Build
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.NotificationCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.tugasnotif.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private val channelId = "NOTIFTUGAS"
    private val notifId = 90
    companion object{
        lateinit var binding: ActivityMainBinding
        var numberlike= 0
        var numberdislike= 0
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val notifManager = getSystemService(Context.NOTIFICATION_SERVICE) as
                NotificationManager
        binding.btnLike.setOnClickListener{
            numberlike++
            binding.tvLikenum.text = numberlike.toString()
        }
        binding.btnDislike.setOnClickListener{
            numberdislike++
            binding.tvDislikenum.text = numberdislike.toString()
        }
        binding.btnNotif.setOnClickListener {
            val flag = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                PendingIntent.FLAG_IMMUTABLE
            }
            else {
                0
            }
            val intentlike = Intent(this,NotifLike::class.java)

            val pendingIntentlike = PendingIntent.getBroadcast(
                this,
                0,
                intentlike,
                flag
            )

            val intentdislike = Intent(this,NotifDislike::class.java)

            val pendingIntentdislike = PendingIntent.getBroadcast(
                this,
                1,
                intentdislike,
                flag
            )
            val bitmap = BitmapFactory.decodeResource(resources, R.drawable.emoji)
            val bitmapgambar = BitmapFactory.decodeResource(resources, R.drawable.gambar)
            val builder = NotificationCompat.Builder(this, channelId)
                .setSmallIcon(R.drawable.emoji)
                .setLargeIcon(bitmap)
                .setContentTitle("Counter")
                .setContentText("ini notif dari gopan gamtenk")
                .setStyle(NotificationCompat.BigPictureStyle().bigPicture(bitmapgambar))
                .setAutoCancel(true)
                .setPriority(NotificationCompat.PRIORITY_DEFAULT)
                .addAction(0, "Like", pendingIntentlike)
                .addAction(1, "Dislike", pendingIntentdislike)

            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                val notifChannel = NotificationChannel(
                    channelId, // Id channel
                    "Notifku", // Nama channel notifikasi
                    NotificationManager.IMPORTANCE_DEFAULT
                )
                with(notifManager) {
                    createNotificationChannel(notifChannel)
                    notify(notifId, builder.build())
                }
            }
            else {
                notifManager.notify(notifId, builder.build())
            }
        }

    }

    fun nambahlike(numberlike:Int){
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        with(binding){
        }
    }
    fun nambahdislike(numberdislike:Int){
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        with(binding){
            tvDislikenum.text = numberdislike.toString()
        }
    }

}