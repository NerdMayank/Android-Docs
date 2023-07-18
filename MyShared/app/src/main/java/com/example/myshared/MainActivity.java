package com.example.myshared;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    private EditText editText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText= findViewById(R.id.editText);
        SharedPreferences sp= getSharedPreferences("mm",0);
        editText.setText(sp.getString("myText", ""));
    }

    @Override
    protected void onStop() {
        super.onStop();
        SharedPreferences sp= getSharedPreferences("mm",0);
        SharedPreferences.Editor editor=sp.edit();
        editor.putString("myText", editText.getText().toString());
        editor.commit();
    }
}