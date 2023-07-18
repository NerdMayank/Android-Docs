package com.example.notifications

import android.annotation.SuppressLint
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.annotation.RequiresApi
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat

class MainActivity : AppCompatActivity() {

    val CHANNEL_ID= "channelId"
    val CHANNEL_NAME="channelName"
    val notificationId=0
    @RequiresApi(Build.VERSION_CODES.S)
    @SuppressLint("MissingPermission")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        createNotificationChannel()

//        Pending Intent
        val intent= Intent(this,MainActivity::class.java)
        val pendingIntent= PendingIntent.getActivity(this,0,intent,PendingIntent.FLAG_MUTABLE)

        val notification= NotificationCompat.Builder(this,CHANNEL_ID)
            .setContentTitle("Hello Baccho")
            .setContentText("Congrats for showing up today")
            .setSmallIcon(R.drawable.ic_baseline_3p_24)
            .setPriority(NotificationCompat.PRIORITY_HIGH)
            .setContentIntent(pendingIntent)
            .build()

        val tv= findViewById<Button>(R.id.tv)
        val notificationManager= NotificationManagerCompat.from(this)
        tv.setOnClickListener {
            notificationManager.notify(notificationId ,notification)
        }

    }

    private fun createNotificationChannel(){
        if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.O){
            val channel= NotificationChannel(CHANNEL_ID,CHANNEL_NAME,NotificationManager.IMPORTANCE_DEFAULT).apply {
                description="This is my notification channel"
            }

            val manager= getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
            manager.createNotificationChannel(channel)
        }
    }


}