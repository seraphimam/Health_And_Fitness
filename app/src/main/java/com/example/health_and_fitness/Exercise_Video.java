package com.example.health_and_fitness;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

public class Exercise_Video extends AppCompatActivity {
    private int vid = 0;
    static String url_loc = "https://vimeo.com/showcase/8125021/video/";
    String[] video = {"512551820", "511582457", "511158996", "511158825",
                        "509716824", "508037594", "507084029", "507005667", "506147217"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.exercise);

        String url = url_loc + video[vid] + "/embed";

        WebView w = (WebView) findViewById(R.id.exercise_video);
        w.getSettings().setJavaScriptEnabled(true);
        w.loadUrl(url);

        Button up = (Button) findViewById(R.id.up);
        Button down = (Button) findViewById(R.id.down);
        ImageButton back = (ImageButton) findViewById(R.id.back);

        set_button();

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        up.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                vid--;
                String prev_url = url_loc + video[vid] + "/embed";
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
                String next_url = url_loc + video[vid] + "/embed";
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

        if(vid == 0){
            up.setVisibility(View.INVISIBLE);
            up.setClickable(false);
        }else{
            up.setVisibility(View.VISIBLE);
            up.setClickable(true);
        }

        if(vid == (video.length - 1)){
            down.setVisibility(View.INVISIBLE);
            down.setClickable(false);
        }else{
            down.setVisibility(View.VISIBLE);
            down.setClickable(true);
        }
    }

}
