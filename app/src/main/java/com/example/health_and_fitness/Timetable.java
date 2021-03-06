package com.example.health_and_fitness;

import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

public class Timetable extends AppCompatActivity {
    static String url = "https://sjogliffeyservices.ie/onlineengagesessions/";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.timetable);

        WebView w = (WebView) findViewById(R.id.exercise_video);
        w.getSettings().setJavaScriptEnabled(true);
        w.loadUrl(url);

        ImageButton back = (ImageButton) findViewById(R.id.back);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

    }

}
