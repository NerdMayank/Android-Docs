package com.example.dynamicphotoviewer

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import org.w3c.dom.Text

class MainActivity : AppCompatActivity() {
    private var currentImage=0
    lateinit var image: ImageView
    var names= arrayOf("Prachi","Prachi Fir Se","Cheers")
    @SuppressLint("DiscouragedApi")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportActionBar?.hide()
        val prev: ImageButton= findViewById(R.id.prev)
        val next: ImageButton= findViewById(R.id.next)
        val name: TextView= findViewById(R.id.name)
        prev.setOnClickListener{
            val idCurrentImageString="pic${currentImage}"
//          Convert string id into integer associated within
            val idCurrentImageInt= this.resources.getIdentifier(idCurrentImageString,"id",packageName)
            image= findViewById(idCurrentImageInt)
            image.alpha=0f
            currentImage = (3+currentImage-1)%3

            val idImageToShowString="pic${currentImage}"
//          Convert string id into integer associated within
            val idImageToShowInt= this.resources.getIdentifier(idImageToShowString,"id",packageName)
            image= findViewById(idImageToShowInt)
            image.alpha=1f
            name.text=names[currentImage]
        }
        next.setOnClickListener{
            val idCurrentImageString="pic${currentImage}"
//          Convert string id into integer associated within
            val idCurrentImageInt= this.resources.getIdentifier(idCurrentImageString,"id",packageName)
            image= findViewById(idCurrentImageInt)
            image.alpha=0f
            currentImage = (3+currentImage+1)%3

            val idImageToShowString="pic${currentImage}"
//          Convert string id into integer associated within
            val idImageToShowInt= this.resources.getIdentifier(idImageToShowString,"id",packageName)
            image= findViewById(idImageToShowInt)
            image.alpha=1f
            name.text=names[currentImage]
        }

    }
}