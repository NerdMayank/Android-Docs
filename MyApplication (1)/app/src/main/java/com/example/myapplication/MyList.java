package com.example.myapplication;

import android.app.ListActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MyList extends ListActivity {
    String arr[]={"Example","Example1","Example2","Example3","Example4"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_my_list2);
        setListAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_expandable_list_item_1,arr));
    }

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);
        String str= arr[position];
        Toast.makeText(getApplicationContext(),""+str,Toast.LENGTH_LONG).show();
    }
}