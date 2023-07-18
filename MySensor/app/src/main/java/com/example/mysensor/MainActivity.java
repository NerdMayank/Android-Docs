package com.example.mysensor;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Build;
import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity  implements SensorEventListener {
    LinearLayout ly;
    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ly= findViewById(R.id.ly);
        textView=findViewById(R.id.textView);

        SensorManager sm=(SensorManager) getSystemService(SENSOR_SERVICE);
//        int i= Sensor.TYPE_ORIENTATION;
        int i= Sensor.TYPE_PROXIMITY;
        Sensor s= sm.getDefaultSensor(i);
        sm.registerListener(this,s,sm.SENSOR_DELAY_NORMAL);
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    public void onSensorChanged(SensorEvent event) {
//        float []data =event.values;
//        float x=data[0];
//        float y=data[1];
//        float z= data[2];

//        String st= "ORIENTATION SENSOR : ";
//        st+="\nPITCH = "+x;
//        st+="\nROLL = "+y;
//        st+="\nAZIMUTH = "+z;
//
//
//        textView.setText(st);
//        ly.setBackgroundColor(Color.rgb(x,y,z));
        float [] data= event.values;
        float x=data[0];
        if(x==0){
            ly.setBackgroundColor(Color.RED);
        }
        else{
            ly.setBackgroundColor(Color.GREEN);
        }

    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }
}