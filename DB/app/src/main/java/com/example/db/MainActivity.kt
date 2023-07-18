package com.example.db

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class MainActivity : AppCompatActivity() {
    private lateinit var database: DatabaseReference
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportActionBar?.hide()
        val signButton:Button=findViewById(R.id.signButton)
        val etName: EditText= findViewById(R.id.etName)
        val etMail: EditText=findViewById(R.id.etEmail)
        val userId: EditText=findViewById(R.id.etId)
        val userPass: EditText=findViewById(R.id.etPass)
        signButton.setOnClickListener{
            val name= etName.text.toString()
            val mail= etMail.text.toString()
            val uniqueId= userId.text.toString()
            val password= userPass.text.toString()
            val user= User(name,mail,password,uniqueId)

            database= FirebaseDatabase.getInstance().getReference("Users")
            database.child(uniqueId).setValue(user).addOnSuccessListener {
                Toast.makeText(this,"User registration successful",Toast.LENGTH_SHORT).show()
            }.addOnCanceledListener {
                Toast.makeText(this,"Failed",Toast.LENGTH_SHORT).show()
            }
        }
        val lastTv:TextView=findViewById(R.id.lastTv)
        lastTv.setOnClickListener {
            val intent= Intent(this,SignInActivity::class.java)
            startActivity(intent)
        }
    }
}