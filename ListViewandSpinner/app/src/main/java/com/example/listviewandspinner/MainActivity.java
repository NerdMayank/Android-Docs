package com.example.listviewandspinner;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView citiesList = findViewById(R.id.citiesList);
        Spinner studentSpinner = findViewById(R.id.studentSpinner);

        ArrayList<String> students= new ArrayList<>();
        students.add("Meisam");
        students.add("Mayank");
        students.add("Aniket");
        students.add("Rahul");
        students.add("Anish");
        students.add("Vivek");

        ArrayAdapter<String> studentsAdapter= new ArrayAdapter<>(
                this, android.R.layout.simple_spinner_dropdown_item,students
        );
        studentSpinner.setAdapter(studentsAdapter);

        studentSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(MainActivity.this, students.get(position)+" selected", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        ArrayList<String> cities= new ArrayList<>();
        cities.add("Zurich");
        cities.add("New York");
        cities.add("New Delhi");
        cities.add("Berlin");
        cities.add("Moscow");
        cities.add("Madrid");
        ArrayAdapter<String> citiesAdapter= new ArrayAdapter<>(
                this, android.R.layout.simple_list_item_1, cities
        );
        citiesList.setAdapter(citiesAdapter);

        citiesList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(MainActivity.this, cities.get(position)+" Selected", Toast.LENGTH_SHORT).show();
            }
        });
    }
}