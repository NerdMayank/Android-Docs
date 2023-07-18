package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ListActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MyList extends AppCompatActivity {
    private String arr[]={"Example","Example1","Example2","Example3","Example4"};
    private ArrayAdapter<String> fileList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_list);
        setContentView(R.layout.activity_my_list);

    }
}





