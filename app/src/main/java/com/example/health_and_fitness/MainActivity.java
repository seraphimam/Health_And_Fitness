package com.example.health_and_fitness;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity {

    DatabaseManager dbm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dbm = new DatabaseManager(this);
        dbm.open();

        dbm.insertFood(0,"apple");
        dbm.insertFood(1,"nuts");
        dbm.insertFood(2,"banana");
        dbm.insertFood(3,"spinach");
        dbm.insertFood(4,"egg");
        dbm.insertFood(5,"salmon");
        dbm.insertFood(6,"lean beef");
        dbm.insertFood(7,"chicken");

        dbm.insertFoodInformation(0,"apple",52,0.3,0.2,10.4);
        dbm.insertFoodInformation(1,"nuts",654,15,65,2.6);
        dbm.insertFoodInformation(2,"banana",89,1.1,0.3,12);
        dbm.insertFoodInformation(3,"spinach",7,0.86,0,0);
        dbm.insertFoodInformation(4,"egg",155,13,11,1.1);
        dbm.insertFoodInformation(5,"salmon",208,20,13,0);
        dbm.insertFoodInformation(6,"lean beef",250,26,15,0);
        dbm.insertFoodInformation(7,"chicken",239,27,14,0);


        ImageButton start = (ImageButton) findViewById(R.id.start);

        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, Home.class);

                startActivity(i);
            }
        });

        dbm.close();
    }
}