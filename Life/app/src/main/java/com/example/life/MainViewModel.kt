package com.example.life

import androidx.lifecycle.ViewModel

class MainViewModel(initialVal:Int):ViewModel() {


    var count=initialVal
    fun counter() {
        count++
    }



}