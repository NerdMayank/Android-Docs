package com.example.gfbotlayout

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.imageview.ShapeableImageView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val bg= findViewById<ImageButton>(R.id.send_btn)
        bg.setOnClickListener{
            startActivity(Intent(this,LandingActivity::class.java))
        }
    }
}