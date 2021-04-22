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

    String[] video = {"511582457", "509716824", "508037594", "507084029",
            "506147217", "506097066", "505739508", "505739133", "502649719",
             "501905233", "499200488", "499125231", "497625898", "492401376"
            , "492399739", "492399293", "488011559", "488010676", "485470550"
            , "484449058", "483962914", "483468322", "481160577", "480462567"
            , "480272376", "478385295", "477151725", "477151520", "475913883"
            , "474654482", "470585451", "468475783", "463408140", "460959448"
            , "460191457", "460191299", "458576336", "458576018", "457061568"
            , "456265984", "455223106", "455217677", "455217266", "451244111"
            , "449336677", "441069890", "439968079", "438536665", "437842896"
            , "436767300", "431459085", "430704167", "430343325", "429933575"
            , "429933554"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recipe);

        String url = url_loc + video[vid] + "/embed";

        WebView w = (WebView) findViewById(R.id.exercise_video);
        w.getSettings().setJavaScriptEnabled(true);
        /*
        Cursor mCursor;
        DatabaseManager dbm = new DatabaseManager(this);
        dbm.open();
        mCursor = dbm.SearchRecipeVideo(vid);
        String url = url_loc + mCursor.getString(1)+ "/embed";
        */
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
