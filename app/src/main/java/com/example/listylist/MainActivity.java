/*
// file name: MainActivity.java
Classname: CMPUT301
Version information: first version
Date: January 13rd, 2026
Copyright: Kyumin Park
 */

package com.example.listylist;

import android.os.Bundle;
import android.widget.ListView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import androidx.appcompat.app.AlertDialog;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import java.util.ArrayList;
import java.util.Arrays;



public class MainActivity extends AppCompatActivity {

    //Declare variable so i can be able to reference it later
    ArrayList<String> dataList;
    ListView cityList;
    ArrayAdapter<String> cityAdapter;

    Button addButton;
    Button deleteButton;
    int selectedIndex = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cityList = findViewById(R.id.city_list);
        addButton = findViewById(R.id.add_button);
        deleteButton = findViewById(R.id.delete_city_button);

        String []cities = {"Edmonton", "Vancouver", "Moscow", "Sydney", "Berlin", "Vienna", "Tokyo", "Beijing", "Osaka", "New Delhi"};

        dataList = new ArrayList<>();
        dataList.addAll(Arrays.asList(cities));

        //set adapter
        cityAdapter = new ArrayAdapter<>(this, R.layout.content, dataList);
        cityList.setAdapter(cityAdapter);

        // for select city
        cityList.setOnItemClickListener((parent, view, position, id) -> {
            selectedIndex = position;
        });

        //click add city
        addButton.setOnClickListener(v -> {
            EditText input = new EditText(this);
            input.setHint("Enter city name");

            new AlertDialog.Builder(this)
                    .setTitle("Add City")
                    .setView(input)
                    .setPositiveButton("CONFIRM", (dialog, which) -> {
                        String city = input.getText().toString();

                        if (!city.isEmpty()) {
                            dataList.add(city);
                            cityAdapter.notifyDataSetChanged();
                            cityList.smoothScrollToPosition(dataList.size() - 1);
                        }
                    })
                    .setNegativeButton("CANCEL", null)
                    .show();
        });

        // click delete city
        deleteButton.setOnClickListener(v -> {
            if (selectedIndex != -1) {
                String cityName = dataList.get(selectedIndex);

                new AlertDialog.Builder(this)
                        .setTitle("Delete City")
                        .setMessage("Do you want to delete '" + cityName + "'?")
                        .setPositiveButton("CONFIRM", (dialog, which) -> {
                            dataList.remove(selectedIndex);
                            cityAdapter.notifyDataSetChanged();
                            selectedIndex = -1;
                        })
                        .setNegativeButton("CANCEL", null)
                        .show();
            }
        });



    }


    }
