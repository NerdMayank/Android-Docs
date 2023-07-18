package com.example.gallery;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

import java.io.File;
import java.util.ArrayList;
import java.util.Collection;

public class MainActivity extends AppCompatActivity {
    ArrayList<File> list;
    GridView imgView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imgView = findViewById(R.id.imgGrid);
        list= imageReader(Environment.getExternalStorageDirectory());

        imgView.setAdapter(new GridAdapter());
        imgView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent= new Intent(MainActivity.this, FullImage.class);
                intent.putExtra("img",list.get(position).toString());
                startActivity(intent);
            }
        });
    }



public class GridAdapter extends BaseAdapter{

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @SuppressLint("ViewHolder")
    @Override
    public View getView(int position, View view, ViewGroup parent) {

        View convertView = null;
        convertView=getLayoutInflater().inflate(R.layout.row_layout, parent, false);
        ImageView myImage= convertView.findViewById(R.id.myImage);
        myImage.setImageURI(Uri.parse(list.get(position).toString()));
        return convertView;



    }
}

    private ArrayList<File> imageReader(File externalStorageDirectory) {
        ArrayList<File> b = new ArrayList<>();
        File [] files= externalStorageDirectory.listFiles();

        assert files != null;
        for(File i: files){
            if(i.isDirectory()){
                b.addAll(imageReader(i));
            }else{
                if(i.getName().endsWith(".jpg")){
                    b.add(i);
                }
            }
        }
        return b;
    }
}