package com.example.health_and_fitness;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class Color_Change extends AppCompatActivity {
    int selection = Color_Pref.pref;
    String[] color_name = {
      "red", "cyan", "green",
      "blue", "purple", "pink"
    };
    int[] color_list = {
      0xffff0000, 0xff00FFFF, 0xff008000,
      0xff0000ff, 0xff800080, 0xffffc0cb
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.color_change);
        selection = Color_Pref.pref;
        Log.e("selection", "cur select: "+selection);

        Button[] b = new Button[color_name.length];
        ImageView[] pic = new ImageView[color_name.length];
        ImageButton back = (ImageButton) findViewById(R.id.back);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        for(int i = 0; i < color_name.length; i++){
            int b_res = getResources().getIdentifier("color_button_" + (i+1), "id", getPackageName());
            int p_res = getResources().getIdentifier("pointer_" + (i+1), "id", getPackageName());
            b[i] = (Button) findViewById(b_res);
            pic[i] = (ImageView) findViewById(p_res);

            if(selection != i){
                pic[i].setVisibility(View.INVISIBLE);
            }else{
                pic[i].setVisibility(View.VISIBLE);
            }

            b[i].setBackgroundColor(color_list[i]);

            b[i].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    switch(view.getId()){
                        case R.id.color_button_1:
                            selection = 0;
                            Color_Pref.pref = selection;
                            break;
                        case R.id.color_button_2:
                            selection = 1;
                            Color_Pref.pref = selection;
                            break;
                        case R.id.color_button_3:
                            selection = 2;
                            Color_Pref.pref = selection;
                            break;
                        case R.id.color_button_4:
                            selection = 3;
                            Color_Pref.pref = selection;
                            break;
                        case R.id.color_button_5:
                            selection = 4;
                            Color_Pref.pref = selection;
                            break;
                        case R.id.color_button_6:
                            selection = 5;
                            Color_Pref.pref = selection;
                            break;
                    }

                    Log.e("selection", "changed select: "+selection);
                    Log.e("pref", "changed pref: "+Color_Pref.pref);
                    finish();

                }
            });
        }



    }

}
