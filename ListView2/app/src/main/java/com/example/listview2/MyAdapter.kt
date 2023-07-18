package com.example.listview2

import android.annotation.SuppressLint
import android.app.Activity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView
import de.hdodenhof.circleimageview.CircleImageView


class MyAdapter(private val context: Activity, private val arrayList: ArrayList<User>) :
    ArrayAdapter<User>(context, R.layout.eachitem, arrayList) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val inflater= LayoutInflater.from(context)
        val view= inflater.inflate(R.layout.eachitem,null)

        val image= view.findViewById<CircleImageView>(R.id.profile_image)
        val name= view.findViewById<TextView>(R.id.personName)
        val msg= view.findViewById<TextView>(R.id.personMsg)
        val time= view.findViewById<TextView>(R.id.time)

        name.text=arrayList[position].name
        msg.text=arrayList[position].lastMsg
        time.text=arrayList[position].lastMsgTime
        image.setImageResource(arrayList[position].imageId)

        return view
    }
}