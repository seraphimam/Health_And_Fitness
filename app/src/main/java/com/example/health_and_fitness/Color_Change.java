package com.example.health_and_fitness;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

public class Color_Change extends AppCompatActivity {
    int selection = 0;
    String[] color_name = {
      "red", "cyan", "green",
      "blue", "yellow", "purple",
      "pink"
    };
    int[] color_list = {
      0xff0000, 0x00FFFF, 0x008000,
      0x0000ff, 0xffff00, 0x800080,
            0xffc0cb
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.color_change);

        ListView l = (ListView) findViewById(R.id.colors);
        ArrayAdapter a = new ArrayAdapter(this, R.layout.color_row, color_name);
        l.setAdapter(a);

        l.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Button b = (Button) findViewById(R.id.color_button);

                ImageView pointer = (ImageView) findViewById(R.id.pointer);

                if(i != selection){
                    pointer.setVisibility(View.INVISIBLE);
                }else{
                    pointer.setVisibility(View.VISIBLE);
                }

                selection = i;
            }
        });
    }

}
