package com.example.life

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider

class MainActivity : AppCompatActivity() {

    private lateinit var tv:TextView
    private lateinit var count:Button

    lateinit var mainViewModel: MainViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        tv=findViewById(R.id.tv)


        mainViewModel= ViewModelProvider(this,MainViewModelFactory(10))[MainViewModel::class.java]
        setText()
    }


    private fun setText(){
        tv.text=mainViewModel.count.toString()
    }


    fun counter(view: View) {
        mainViewModel.counter()
        setText()
    }
}