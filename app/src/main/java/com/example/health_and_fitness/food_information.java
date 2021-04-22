package com.example.health_and_fitness;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class food_information extends AppCompatActivity {

    String[]column = new String[]{};

    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.food_information);

        ImageButton back = (ImageButton) findViewById(R.id.back);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        Intent intent = getIntent();

        if(intent.getExtras() != null)
        {
            ImageView foodimage = findViewById(R.id.image);
            TextView foodname = (TextView)findViewById(R.id.textView0);
            TextView calories = (TextView)findViewById(R.id.textView1);
            TextView protein = (TextView)findViewById(R.id.textView2);
            TextView fats = (TextView)findViewById(R.id.textView3);
            TextView sugar = (TextView)findViewById(R.id.textView4);

            String selectedNames = intent.getStringExtra("name");
            int selectedImage = intent.getIntExtra("image",0);
            foodimage.setImageResource(selectedImage);
            Cursor mCursor;
            DatabaseManager dbm = new DatabaseManager(this);
            dbm.open();
            mCursor = dbm.SearchFoodInformation(0,selectedNames);

            foodname.setText(selectedNames);
            calories.setText("calories per 100 GRAM: " + mCursor.getString(1));
            protein.setText("protein per 100 GRAM: " + mCursor.getString(2));
            fats.setText("fats per 100 GRAM: " + mCursor.getString(3));
            sugar.setText("sugar per 100 GRAM: " + mCursor.getString(4));

        }

    }

}
