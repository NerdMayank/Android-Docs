package com.example.db

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import java.security.Key

class SignInActivity : AppCompatActivity() {
    lateinit var databaseReference: DatabaseReference
    companion object{
        const val KEY1="com.example.db.SignActivity.mail"
        const val KEY2="com.example.db.SignActivity.name"
        const val KEY3="com.example.db.SignActivity.id"

    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_in)
        supportActionBar?.hide()
        val signInBtn:Button=findViewById(R.id.signInButton)
        val userName: EditText= findViewById(R.id.userNameEditText)

        signInBtn.setOnClickListener{
//            Take reference till node "Users"
                val uniqueId= userName.text.toString()
            if(uniqueId!=""){
                readData(uniqueId)
            }
            else{
                Toast.makeText(this,"Enter Username",Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun readData(uniqueId: String) {
        databaseReference= FirebaseDatabase.getInstance().getReference("Users")
        databaseReference.child(uniqueId).get().addOnSuccessListener {
            if(it.exists()){
//               Welcome user in your app with intent
                val email= it.child("email").value
                val name=it.child("name").value
                val userId= it.child("uniqueId").value
                val intent= Intent(this,HomeActivity::class.java)
                intent.putExtra(KEY1,email.toString())
                intent.putExtra(KEY2,name.toString())
                intent.putExtra(KEY3, userId.toString())
                startActivity(intent)
            }
            else{
                Toast.makeText(this,"User doesn't exist",Toast.LENGTH_SHORT).show()
            }
        }.addOnFailureListener{
            Toast.makeText(this,"Failed",Toast.LENGTH_SHORT).show()
        }
    }
}