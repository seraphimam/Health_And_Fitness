package com.example.health_and_fitness;

import android.content.Intent;
import android.graphics.PorterDuff;
import android.graphics.drawable.LayerDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import org.w3c.dom.Text;

public class Steps extends AppCompatActivity {
    int steps_done = 0;
    int progress_fill = User_Pref.color_list[User_Pref.color_pref];
    int percent = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.step_count);

        steps_done = User_Pref.steps;

        ImageButton back = (ImageButton) findViewById(R.id.back);
        ImageButton track = (ImageButton) findViewById(R.id.track);
        final ProgressBar progress = (ProgressBar) findViewById(R.id.progress_bar);
        TextView step_count = (TextView) findViewById(R.id.steps);

        progress_change(progress);

        step_count.setText(Integer.toString(steps_done));

        step_count.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                steps_done += 10;
                User_Pref.steps = steps_done;

                progress_change(progress);
                recreate();
            }
        });
//        set color of progress bar
        LayerDrawable progress_colors = (LayerDrawable) progress.getProgressDrawable();
        progress_colors.getDrawable(1).setColorFilter(progress_fill, PorterDuff.Mode.SRC_IN);


        progress.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Steps.this, Color_Change.class);
                startActivity(i);
            }
        });

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

    }

    // set percentage progress of progress bar
    private void progress_change(ProgressBar progress){
        if(steps_done < User_Pref.progress){
            percent = (int) ((steps_done * 100 / User_Pref.progress));
        }else{
            percent = 100;
        }

        progress.setProgress(percent);
    }
}
