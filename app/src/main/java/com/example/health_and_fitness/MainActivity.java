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
        dbm.insertFood(8,"yogurt");
        dbm.insertFood(9,"beans");
        dbm.insertFood(10,"cottage cheese");
        dbm.insertFood(11,"avocado");
        dbm.insertFood(12,"olive oil");
        dbm.insertFood(13,"potatoes");
        dbm.insertFood(14,"coconut oil");


        dbm.insertFoodInformation(0,"apple",52,0.3,0.2,10.4);
        dbm.insertFoodInformation(1,"nuts",654,15,65,2.6);
        dbm.insertFoodInformation(2,"banana",89,1.1,0.3,12);
        dbm.insertFoodInformation(3,"spinach",7,0.86,0,0);
        dbm.insertFoodInformation(4,"egg",155,13,11,1.1);
        dbm.insertFoodInformation(5,"salmon",208,20,13,0);
        dbm.insertFoodInformation(6,"lean beef",250,26,15,0);
        dbm.insertFoodInformation(7,"chicken",239,27,14,0);
        dbm.insertFoodInformation(8,"yogurt",59,10,0.4,3.2);
        dbm.insertFoodInformation(9,"beans",347,21,1.2,2.1);
        dbm.insertFoodInformation(10,"cottage cheese",98,11,4.3,2.7);
        dbm.insertFoodInformation(11,"avocado",160,2,15,0.7);
        dbm.insertFoodInformation(12,"olive oil",884,0,100,0);
        dbm.insertFoodInformation(13,"potatoes",77,2,0.1,0);
        dbm.insertFoodInformation(14,"coconut oil",862,0,100,0.8);

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