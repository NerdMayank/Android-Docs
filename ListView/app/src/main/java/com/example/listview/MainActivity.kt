package com.example.listview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Adapter
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportActionBar?.hide()
        val listView: ListView= findViewById(R.id.listView)


        val taskList= arrayListOf<String>()
        taskList.add("Attend Exam")
        taskList.add("Complete App Dev project")
        taskList.add("Buy bhindi from market")
        taskList.add("Work on resume")
        taskList.add("improve internet presence")

        val adapterForMyListView= ArrayAdapter(this,android.R.layout.simple_list_item_1,taskList)
        listView.adapter=adapterForMyListView
        listView.setOnItemClickListener { adapterView, view, i, l ->
            val text= "Clicked on item "+ (view as TextView).text.toString()
            Toast.makeText(this,text,Toast.LENGTH_SHORT).show()
        }
    }
}