package com.example.listviewdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private ListView class_schedule;
    final String[] CLASSES = {"CSCI230", "ARTS319", "JPNS201", "ECON101", "ARTH101", "THRT230"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        class_schedule = findViewById(R.id.class_schedule);

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_dropdown_item_1line, CLASSES);

        class_schedule.setAdapter(adapter);

        class_schedule.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String className = (String)adapter.getItem(position);
                Toast.makeText(getApplicationContext(), className, Toast.LENGTH_SHORT).show();
            }
        });

        class_schedule.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                String className = (String)adapter.getItem(position);
                Toast.makeText(getApplicationContext(), className + " Long", Toast.LENGTH_SHORT).show();
                return true;
            }
        });
    }
}