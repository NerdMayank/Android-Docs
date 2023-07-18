package com.example.birthdaycard

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val createCardBtn=findViewById<Button>(R.id.createCardBtn)
        createCardBtn.setOnClickListener {
            val inputText=findViewById<EditText>(R.id.inputText);
            val name=inputText.text
            val intent= Intent(this,BirthdayCard::class.java)
            intent.putExtra(BirthdayCard.NAME_EXTRA,name)
            startActivity(intent)
        }
    }
}