package com.example.myservice;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button buttonPlay,buttonStop;

    Intent obj;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonPlay=findViewById(R.id.buttonPlay);
        buttonStop= findViewById(R.id.buttonStop);

        buttonStop.setOnClickListener(this);
        buttonPlay.setOnClickListener(this);

        obj= new Intent(MainActivity.this,MusicDemo.class);

    }


    @Override
    public void onClick(View view) {
        if(buttonPlay==view){
            startService(obj);
        }
        else if(buttonStop==view){
            stopService(obj);
        }
    }
}