package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    ListView lv;

    String arr[] = {"List View Demo", "Grid View Demo", "Web View Demo", "Option Menu", "Context Menu","Intent Demo","Sending Email","Check Box Demo","Radio Demo","Rating Demo","Spinner Demo","Alert Demo","Auto Complete text View","Search Demo"};

    Class c[] = {MyList.class,MyGrid.class,MyWeb.class,Myoption.class,MyContext.class,MyIntent.class,MyEmailDemo.class,MyCheck.class,MyRadio.class,MyRating.class,MySpinner.class,MyAlert.class,MyAuto.class,MySearch.class} ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lv = findViewById(R.id.lv);

        ArrayAdapter<String> adp = new ArrayAdapter<String>
                (this, android.R.layout.simple_expandable_list_item_1,arr);

        lv.setAdapter(adp);
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
//                String str = arr[i];
//                Toast.makeText(getApplicationContext(),"" + str,Toast.LENGTH_LONG).show();
                try {
                    Intent obj = new Intent(MainActivity.this,c[i]);
                    startActivity(obj);

                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        });
    }
}