package com.example.checkboxes;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ProgressBar;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private CheckBox checkboxHarry,checkboxMatrix,checkboxJoker;
    private RadioGroup rgMaritalStatus;
    private ProgressBar progressBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        checkboxHarry=findViewById(R.id.checkboxHarry);
        checkboxMatrix=findViewById(R.id.checkboxMatrix);
        checkboxJoker= findViewById(R.id.checkboxJoker);
        checkboxHarry.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    Toast.makeText(MainActivity.this, "You've watched Harry Potter, YayY", Toast.LENGTH_SHORT).show();
                }
                else{
                    Toast.makeText(MainActivity.this, "You NEED to watch Harry Potter", Toast.LENGTH_SHORT).show();
                }
            }
        });
        checkboxJoker.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    Toast.makeText(MainActivity.this, "You've watched Joker, YayY", Toast.LENGTH_SHORT).show();
                }
                else{
                    Toast.makeText(MainActivity.this, "You NEED to watch Joker", Toast.LENGTH_SHORT).show();
                }
            }
        });
        checkboxMatrix.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    Toast.makeText(MainActivity.this, "You've watched Matrix, YayY", Toast.LENGTH_SHORT).show();
                }
                else{
                    Toast.makeText(MainActivity.this, "You NEED to watch Matrix", Toast.LENGTH_SHORT).show();
                }
            }
        });
        progressBar= findViewById(R.id.progressBar);
        Thread thread= new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i=0;i<10;i++){
                    progressBar.incrementProgressBy(10);
                    SystemClock.sleep(500);
                }
            }


        });
        thread.start();

        rgMaritalStatus= findViewById(R.id.rgMaritalStatus);
        rgMaritalStatus.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId){
                    case R.id.msMarried:
                        Toast.makeText(MainActivity.this, "Married", Toast.LENGTH_SHORT).show();

                        break;
                    case R.id.msSingle:
                        Toast.makeText(MainActivity.this, "Single", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.msRelationship:
                        Toast.makeText(MainActivity.this, "In a relationship", Toast.LENGTH_SHORT).show();

                        break;
                    default:
                        break;
                }
            }
        });
    }

}