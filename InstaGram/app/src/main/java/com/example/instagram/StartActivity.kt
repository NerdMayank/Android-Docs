package com.example.instagram


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.animation.Animation

import android.view.animation.TranslateAnimation
import android.widget.ImageView
import com.example.instagram.databinding.ActivityStartBinding

class StartActivity : AppCompatActivity() {
    lateinit var binding: ActivityStartBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityStartBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.linearLayout.animate().alpha(0f).duration=1

        val animation=TranslateAnimation(0F, 0F, 0F,-1000F)
        animation.duration=1000
        animation.fillAfter=false
        animation.setAnimationListener(MyAnimationListener())

        binding.iconImage.animation=animation


    }

    inner class MyAnimationListener : Animation.AnimationListener {
        override fun onAnimationStart(p0: Animation?) {
            TODO("Not yet implemented")
        }

        override fun onAnimationEnd(p0: Animation?) {
            binding.iconImage.clearAnimation()
            binding.iconImage.visibility=View.INVISIBLE
            binding.linearLayout.animate().alpha(1f).duration=1000
        }

        override fun onAnimationRepeat(p0: Animation?) {
            TODO("Not yet implemented")
        }
    }

}