package com.example.listview2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView

class UserActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user)
        val name= intent.getStringExtra("name")
        val phone= intent.getStringExtra("phone")
        val imageId= intent.getIntExtra("imageId",R.drawable.pic0)
        val nameTv: TextView= findViewById(R.id.name)
        val phoneTv: TextView= findViewById(R.id.phone)
        val imageV: ImageView= findViewById(R.id.profile)
        imageV.setImageResource(imageId)
        nameTv.text=name
        phoneTv.text=phone
    }
}