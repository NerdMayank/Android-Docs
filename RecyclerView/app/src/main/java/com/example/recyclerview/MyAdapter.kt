package com.example.recyclerview

import android.app.Activity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.imageview.ShapeableImageView

class MyAdapter(var newsArrayList: ArrayList<News>, var context: Activity)
    : RecyclerView.Adapter<MyAdapter.MyViewHolder>() {

    private lateinit var myListener: OnItemClickListener
    interface OnItemClickListener{
        fun onItemClicking(position: Int)

    }

    fun setOnItemClickListener(listener: OnItemClickListener){
        myListener=listener
    }


//    How many list items are present in arraylist

     override fun getItemCount(): Int {
         return newsArrayList.size
     }

//when layout manager fails to find a suitable view for each item
     override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView= LayoutInflater.from(parent.context).inflate(R.layout.item,parent,false)
        return MyViewHolder(itemView,myListener)

     }
//    populate item with data
     override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentItem= newsArrayList[position]
        holder.hTitle.text= currentItem.newsHeading
        holder.hImage.setImageResource(currentItem.newsImage)
     }

     class MyViewHolder(itemView: View,listener: OnItemClickListener) : RecyclerView.ViewHolder(itemView){
            val hTitle: TextView =itemView.findViewById<TextView>(R.id.headingTitle)
            val hImage: ShapeableImageView = itemView.findViewById<ShapeableImageView>(R.id.headingImage)
         init{
             itemView.setOnClickListener {
                 listener.onItemClicking(adapterPosition)
             }
         }

     }

 }