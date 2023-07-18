package com.example.gallery;

import androidx.appcompat.app.AppCompatActivity;

import android.net.Uri;
import android.os.Bundle;
import android.widget.ImageView;

public class FullImage extends AppCompatActivity {
    ImageView full;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_full_image);
        full= findViewById(R.id.full);

        String data= getIntent().getExtras().getString("img");
        full.setImageURI(Uri.parse(data));
    }
}