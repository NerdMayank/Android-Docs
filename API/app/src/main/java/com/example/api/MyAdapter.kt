package com.example.api

import android.app.Activity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.imageview.ShapeableImageView
import com.squareup.picasso.Picasso

class MyAdapter(val context:Activity,  val productArrayList: List<Product>): RecyclerView.Adapter<MyAdapter.MyViewHolder>(){

    class MyViewHolder(itemView: View) :RecyclerView.ViewHolder(itemView) {
        var title:TextView
        var image: ShapeableImageView
        var rat1: ImageButton
        var rat2: ImageButton
        var rat3: ImageButton
        var rat4: ImageButton
        var rat5: ImageButton
        init{
            title= itemView.findViewById(R.id.productTitle)
            image= itemView.findViewById(R.id.productImage)
            rat1= itemView.findViewById(R.id.rat1)
            rat2= itemView.findViewById(R.id.rat2)
            rat3= itemView.findViewById(R.id.rat3)
            rat4= itemView.findViewById(R.id.rat4)
            rat5= itemView.findViewById(R.id.rat5)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView= LayoutInflater.from(context).inflate(R.layout.item,parent,false)
        return MyViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentItem= productArrayList[position]
        holder.title.text = currentItem.title
//      Showing image in imageview if the resource is a url
        Picasso.get().load(currentItem.thumbnail).into(holder.image);
        if(currentItem.rating> 3.0 && currentItem.rating<=4.0){
            holder.rat5.alpha= 0f
        }
        else if(currentItem.rating> 2.0 && currentItem.rating<=3.0){
            holder.rat5.alpha=0f
            holder.rat4.alpha=0f
        }
        else if(currentItem.rating> 1.0 && currentItem.rating<=2.0){
            holder.rat5.alpha=0f
            holder.rat4.alpha=0f
            holder.rat3.alpha=0f
        }
        else if(currentItem.rating> 0.0 && currentItem.rating<=1.0){
            holder.rat5.alpha=0f
            holder.rat4.alpha=0f
            holder.rat3.alpha=0f
            holder.rat2.alpha=0f
        }

    }

    override fun getItemCount(): Int {
        return productArrayList.size
    }

}