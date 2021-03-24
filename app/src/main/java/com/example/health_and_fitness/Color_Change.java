package com.example.health_and_fitness;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class Color_Change extends AppCompatActivity {
    int selection = User_Pref.color_pref;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.color_change);
        selection = User_Pref.color_pref;
        Log.e("selection", "cur select: "+selection);

        Button[] b = new Button[User_Pref.color_name.length];
        ImageView[] pic = new ImageView[User_Pref.color_name.length];
        ImageButton back = (ImageButton) findViewById(R.id.back);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        for(int i = 0; i < User_Pref.color_name.length; i++){
            int b_res = getResources().getIdentifier("color_button_" + (i+1), "id", getPackageName());
            int p_res = getResources().getIdentifier("pointer_" + (i+1), "id", getPackageName());
            b[i] = (Button) findViewById(b_res);
            pic[i] = (ImageView) findViewById(p_res);

            if(selection != i){
                pic[i].setVisibility(View.INVISIBLE);
            }else{
                pic[i].setVisibility(View.VISIBLE);
            }

            b[i].setBackgroundColor(User_Pref.color_list[i]);

            b[i].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    switch(view.getId()){
                        case R.id.color_button_1:
                            selection = 0;
                            break;
                        case R.id.color_button_2:
                            selection = 1;
                            break;
                        case R.id.color_button_3:
                            selection = 2;
                            break;
                        case R.id.color_button_4:
                            selection = 3;
                            break;
                        case R.id.color_button_5:
                            selection = 4;
                            break;
                        case R.id.color_button_6:
                            selection = 5;
                            break;
                    }

                    User_Pref.color_pref = selection;

                    finish();

                }
            });
        }



    }

}
