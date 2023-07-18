package com.example.recyclerview

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    private lateinit var myRecyclerView: RecyclerView
    private lateinit var newsArrayList: ArrayList<News>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportActionBar?.hide()
        myRecyclerView= findViewById(R.id.recyclerView)
        val newsImageArray= arrayOf(
            R.drawable.img1,
            R.drawable.img2,
            R.drawable.img3,
            R.drawable.img4,
            R.drawable.img5,
            R.drawable.img6
            )
        val newsArrayHeading= arrayOf(
            "U.K. Foreign Secretary James Cleverly raises issue of BBC tax searches with EAM Jaishankar",
            "Cooking gas prices hiked by ₹50 for domestic, ₹350.50 for commercial cylinders",
            "Joe Biden appoints two prominent Indian-American corporate leaders to his Export Council",
            "Sergey Lavrov will raise suspected bombing of Nord Stream II at G20: Russian Foreign Ministry",
            "Belarusian leader Lukashenko visits China amid Ukraine tensions",
            "China rips new U.S. House committee on countering Beijing",
        )
        val newsContent= arrayOf(
            getString(R.string.example),
            getString(R.string.example),getString(R.string.example),getString(R.string.example),getString(R.string.example),getString(R.string.example)
            )

        newsArrayList=ArrayList<News>()
        for(index in newsArrayHeading.indices){
            val news= News(newsArrayHeading[index],newsImageArray[index],newsContent[index])
            newsArrayList.add(news)
        }
//      to set how bhaw items under the recycler view, scrolling vertically , scrolling horizontally
        var myAdapter= MyAdapter(newsArrayList, this)
        myRecyclerView.adapter = myAdapter
        myAdapter.setOnItemClickListener(object: MyAdapter.OnItemClickListener{
            override fun onItemClicking(position: Int) {
               val intent= Intent(this@MainActivity,NewsDetailActivity::class.java)
                intent.putExtra("heading",newsArrayList[position].newsHeading)
                intent.putExtra("imageId",newsArrayList[position].newsImage)
                intent.putExtra("newsContent",newsArrayList[position].newsContent)
                startActivity(intent)
            }
        })
        myRecyclerView.layoutManager= LinearLayoutManager(this)


    }
}