package com.example.assignment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    MyAdapter adapter;
    ArrayList<String> list;
    Integer counter=0;

    FloatingActionButton btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView=findViewById(R.id.recyclerView);
        btn=findViewById(R.id.btn);

        list=new ArrayList<String>();
        RecyclerView.LayoutManager lm= new LinearLayoutManager(MainActivity.this);
        recyclerView.setLayoutManager(lm);
                adapter=new MyAdapter(list);
        recyclerView.setAdapter(adapter);

        btn.setOnClickListener(view -> {
            counter++;
            list.add(counter.toString());
            recyclerView.smoothScrollToPosition(adapter.getItemCount());
            adapter.notifyDataSetChanged();

        });

    }
}