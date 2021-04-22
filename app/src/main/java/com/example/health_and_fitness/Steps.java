package com.example.health_and_fitness;

import android.Manifest;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.PorterDuff;
import android.graphics.drawable.LayerDrawable;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageButton;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

public class Steps extends AppCompatActivity implements SensorEventListener {
    Context context;
    TextView step_count;
    SensorManager sensorManager;
    Sensor step_sensor;
    ProgressBar progress;
    ImageButton back, track;
    int steps_done = 0;
    int progress_fill;
    int percent = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.step_count);
        context = this;

        if(ContextCompat.checkSelfPermission(this,
                Manifest.permission.ACTIVITY_RECOGNITION) == PackageManager.PERMISSION_DENIED){
            //ask for permission
            requestPermissions(new String[]{Manifest.permission.ACTIVITY_RECOGNITION}, 1);
        }

        init();

        //test code for demo purpose

//        step_count.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                steps_done += 10;
//                User_Pref.steps = steps_done;
//
//                progress_change(progress);
//                recreate();
//            }
//        });

        track.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new AlertDialog.Builder(context)
                        .setTitle("Confirm Reset")
                        .setMessage("Are you sure on resetting the steps you've done?")
                        .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        steps_done = 0;
                        User_Pref.steps = 0;
                        progress_change(progress);
                        recreate();
                    }
                })
                .setNegativeButton("No", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        // do nothing
                    }
                })
                .setIcon(android.R.drawable.ic_dialog_alert).show();

            }
        });


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

    private void init(){
        steps_done = User_Pref.steps;

        getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);

        back = (ImageButton) findViewById(R.id.back);
        track = (ImageButton) findViewById(R.id.track);
        progress = (ProgressBar) findViewById(R.id.progress_bar);
        step_count = (TextView) findViewById(R.id.steps);

        progress_change(progress);
        color_set();

        step_count.setText(Integer.toString(steps_done));
        sensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);

        if(sensorManager.getDefaultSensor(Sensor.TYPE_STEP_DETECTOR) != null){
            step_sensor = sensorManager.getDefaultSensor(Sensor.TYPE_STEP_DETECTOR);
        }else{
            step_count.setText("No Counter Sensor");
        }
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

    //set color of progress bar
    private void color_set(){
        progress_fill = User_Pref.color_list[User_Pref.color_pref];
        LayerDrawable progress_colors = (LayerDrawable) progress.getProgressDrawable();
        progress_colors.getDrawable(1).setColorFilter(progress_fill, PorterDuff.Mode.SRC_IN);
    }

    @Override
    public void onSensorChanged(SensorEvent e) {
        if(e.sensor.getType() == Sensor.TYPE_STEP_DETECTOR){
            steps_done++;
            step_count.setText(Integer.toString(steps_done));
            User_Pref.steps = steps_done;
            progress_change(progress);
        }

    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int i) {

    }

    @Override
    protected void onResume(){
        super.onResume();
        if(sensorManager.getDefaultSensor(Sensor.TYPE_STEP_DETECTOR) != null){
            sensorManager.registerListener(this, step_sensor, SensorManager.SENSOR_DELAY_NORMAL);
        }
        color_set();
    }

    @Override
    protected void onPause(){
        super.onPause();
        if(sensorManager.getDefaultSensor(Sensor.TYPE_STEP_DETECTOR) != null){
            sensorManager.unregisterListener(this, step_sensor);
        }
    }
}
