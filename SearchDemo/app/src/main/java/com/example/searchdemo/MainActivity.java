package com.example.searchdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
SearchView sv;
ListView lv;

ArrayList<String> list;
ArrayAdapter<String> adp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sv= findViewById(R.id.sv);
        lv=findViewById(R.id.lv);

        list= new ArrayList<>();
        list.add("Ram");
        list.add("Alok");
        list.add("Rahul");
        list.add("Amit");

        adp= new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,list);
        lv.setAdapter(adp);
        sv.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                if(list.contains(s)){
                    adp.getFilter().filter(s);
                }
                else{
                    Toast.makeText(getApplicationContext() , "Record Not found", Toast.LENGTH_SHORT).show();
                }
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                return false;
            }
        });

    }
}