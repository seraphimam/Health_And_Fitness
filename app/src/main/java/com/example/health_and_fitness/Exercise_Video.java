package com.example.health_and_fitness;

import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;

import androidx.appcompat.app.AppCompatActivity;

public class Exercise_Video extends AppCompatActivity {
    private int vid = 0;
    private String url = "https://vimeo.com/showcase/8125021";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        getResources().getAssets();
        setContentView(R.layout.exercise);

        WebView w = (WebView) findViewById(R.id.exercise_video);

        WebSettings web_settings = w.getSettings();

        web_settings.setJavaScriptEnabled(true);
        w.loadUrl(url);
    }
}
