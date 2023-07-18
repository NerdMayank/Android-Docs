package com.example.listview2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ListView
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    lateinit var userArrayList: ArrayList<User>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val name= arrayOf("Mayank Pradhan","Shivam","Aakash")
        val lastMsg= arrayOf("Hey! wssup","Cool","Yeah!")
        val lastMsgTime= arrayOf("06:30 PM","05:00 AM","06:12 PM")
        val phoneNumber= arrayOf("6299886629" ,"9652323523","6352122865")
        val imgId= intArrayOf(R.drawable.pic0,R.drawable.pic1,R.drawable.pic2)

        userArrayList= ArrayList()
        for(index in name.indices){
            val user= User(name[index],lastMsg[index],lastMsgTime[index],phoneNumber[index],imgId[index])
            userArrayList.add(user)
        }
        val listView: ListView= findViewById(R.id.listView)
        listView.isClickable=true
        listView.adapter= MyAdapter(this,userArrayList)

        listView.setOnItemClickListener { adapterView, view, i, l ->
            val userName= userArrayList[i].name;
            val userPhone= userArrayList[i].phoneNumber
            val imageId= userArrayList[i].imageId;

            val intent= Intent(this,UserActivity::class.java)
            intent.putExtra("name",userName)
            intent.putExtra("phone",userPhone)
            intent.putExtra("imageId",imageId)
            startActivity(intent)

        }

    }
}