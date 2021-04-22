package com.example.health_and_fitness;

import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

public class Recipe extends AppCompatActivity {
    private int vid = 0;
    static String url_loc = "https://vimeo.com/showcase/8125021/video/";
    DatabaseManager dbm = new DatabaseManager(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recipe);

        WebView w = (WebView) findViewById(R.id.exercise_video);
        w.getSettings().setJavaScriptEnabled(true);

        Cursor mCursor;
        final DatabaseManager dbm = new DatabaseManager(this);
        dbm.open();
        mCursor = dbm.SearchRecipeVideo(vid);
        String url = url_loc + mCursor.getString(1)+ "/embed";

        w.loadUrl(url);

        Button up = (Button) findViewById(R.id.up);
        Button down = (Button) findViewById(R.id.down);
        ImageButton back = (ImageButton) findViewById(R.id.back);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });


        set_button();

        up.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                vid--;

                Cursor mCursor;

                dbm.open();
                mCursor = dbm.SearchRecipeVideo(vid);
                String prev_url = url_loc + mCursor.getString(1)+ "/embed";

                WebView w = (WebView) findViewById(R.id.exercise_video);
                w.getSettings().setJavaScriptEnabled(true);
                w.loadUrl(prev_url);
                set_button();
            }
        });

        down.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                vid++;

                Cursor mCursor;

                dbm.open();
                mCursor = dbm.SearchRecipeVideo(vid);
                String next_url = url_loc + mCursor.getString(1)+ "/embed";

                WebView w = (WebView) findViewById(R.id.exercise_video);
                w.getSettings().setJavaScriptEnabled(true);
                w.loadUrl(next_url);
                set_button();
            }
        });
    }


    private void set_button(){
        Button up = (Button) findViewById(R.id.up);
        Button down = (Button) findViewById(R.id.down);

        dbm.open();
        long amount = dbm.getRecipeVideoAmount();

        if(vid == 0){
            up.setVisibility(View.INVISIBLE);
            up.setClickable(false);
        }else{
            up.setVisibility(View.VISIBLE);
            up.setClickable(true);
        }

        if(vid == (amount - 1)){
            down.setVisibility(View.INVISIBLE);
            down.setClickable(false);
        }else{
            down.setVisibility(View.VISIBLE);
            down.setClickable(true);
        }

    }

}
