package com.example.app;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    ListView lv;

    String arr[]={"List View Demo","Example1","Example2","Example3","Example4"};
    Class c[]= {MyList.class};

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        lv=findViewById(R.id.lv);
        ArrayAdapter<String> adp= new ArrayAdapter<String>(this, android.R.layout.simple_expandable_list_item_1,arr);
        lv.setAdapter(adp);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                try {
                    Intent obj= new Intent(MainActivity.this,c[i]);
                    startActivity(obj);
                } catch (Exception e){
                    e.printStackTrace();
                }
            }
        });
    }


}