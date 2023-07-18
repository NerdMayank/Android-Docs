package com.example.api

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import retrofit2.*
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {
    lateinit var recyclerView: RecyclerView
    lateinit var myAdapter: MyAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView= findViewById(R.id.recyclerView)

        val retrofitBuilder= Retrofit.Builder()
            .baseUrl("https://dummyjson.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApiInterface::class.java)

        val retrofitData= retrofitBuilder.getProductData()
        retrofitData.enqueue(object : Callback<MyData?> {
            override fun onResponse(call: Call<MyData?>, response: Response<MyData?>) {
//                if Api call is a success then use the data and show in your app
                val responseBody= response.body()
                val productList= responseBody?.products!!
                myAdapter= MyAdapter(this@MainActivity,productList)

                recyclerView.adapter= myAdapter
                recyclerView.layoutManager= LinearLayoutManager(this@MainActivity)
            }

            override fun onFailure(call: Call<MyData?>, t: Throwable) {
//              if API calls fails
                Log.d("Mayank","onFailure ${t.message}")
            }
        })
    }
}