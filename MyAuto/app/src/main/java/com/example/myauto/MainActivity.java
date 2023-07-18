package com.example.myauto;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;

public class MainActivity extends AppCompatActivity {
AutoCompleteTextView autoC;
String ar[]={"Android","Java","Kotlin","C","C++","Mayank","Ram"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        autoC= findViewById(R.id.AutoC);
        ArrayAdapter<String> adp= new ArrayAdapter<String>(this, android.R.layout.select_dialog_item,ar);
        autoC.setThreshold(1);
        autoC.setAdapter(adp);

    }
}