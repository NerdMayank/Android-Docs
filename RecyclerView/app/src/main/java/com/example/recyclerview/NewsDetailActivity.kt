package com.example.recyclerview

import android.media.Image
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView

class NewsDetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_news_detail)
        val heading= intent.getStringExtra("heading")
        val imageId= intent.getIntExtra("imageId",R.drawable.img1)
        val newsContent= intent.getStringExtra("newsContent")
        val head: TextView= findViewById(R.id.heading)
        val image: ImageView= findViewById(R.id.image)
        val content: TextView= findViewById(R.id.content)
        head.text= heading
        content.text=newsContent
        image.setImageResource(imageId)

    }
}