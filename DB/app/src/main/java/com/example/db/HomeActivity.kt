package com.example.db

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.example.db.SignInActivity.Companion
import com.example.db.SignInActivity.Companion.KEY1
import com.example.db.SignInActivity.Companion.KEY2
import com.example.db.SignInActivity.Companion.KEY3

class HomeActivity : AppCompatActivity() {
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        supportActionBar?.hide()
        val email=intent.getStringExtra(KEY1)
        val name= intent.getStringExtra(KEY2)
        val id=intent.getStringExtra(KEY3)

        val welcomeText:TextView=findViewById(R.id.tvWelcome)
        welcomeText.text= "WELCOME, $name"
        val btnId:Button=findViewById(R.id.btnUnique)
        btnId.text="ID: $id"
        val btnMail:Button=findViewById(R.id.btnMail)
        btnMail.text="Mail: $email"

    }
}