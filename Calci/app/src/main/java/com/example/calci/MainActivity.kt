package com.example.calci

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    private var tvInput: TextView?= null
    private var onDecimal: Boolean=true
    private var onNumeric: Boolean=false
    private var operator: Boolean=true
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        tvInput=findViewById(R.id.tvInput)
    }
    fun onDigit(view: View) {
        tvInput?.append((view as Button).text)
        onNumeric=true
    }
    fun clear(view: View) {
        tvInput?.text=""
        onDecimal=true
        onNumeric=false
        operator=false
    }

    fun onDec(view: View) {
        if(onDecimal){
            tvInput?.append((view as Button).text)
            onDecimal=false
        }
    }
    fun result(view: View) {
        if(isOperator(tvInput)) {

        }
    }
    fun onOperator(view: View) {
        if(onNumeric && !isOperator(tvInput)){
            tvInput?.append((view as Button).text)
        }

    }
    private fun isOperator(tvInput: TextView?): Boolean {
        if(tvInput?.text?.startsWith('-')==true){
            return false
        }
        else{
            return if(tvInput?.text?.contains('+')==true || tvInput?.text?.contains('-')==true|| tvInput?.text?.contains('*')==true||tvInput?.text?.contains('/')==true){
                true
            }
            else{
                return false;
            }
        }
    }



}