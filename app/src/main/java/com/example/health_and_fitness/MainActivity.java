package com.example.health_and_fitness;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity {

    DatabaseManager dbm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dbm = new DatabaseManager(this);
        dbm.open();

        dbm.insertFood(0,"apple");
        dbm.insertFood(1,"nuts");
        dbm.insertFood(2,"banana");
        dbm.insertFood(3,"spinach");
        dbm.insertFood(4,"egg");
        dbm.insertFood(5,"salmon");
        dbm.insertFood(6,"lean beef");
        dbm.insertFood(7,"chicken");

        dbm.insertFoodInformation(0,"apple",52,0.3,0.2,10.4);
        dbm.insertFoodInformation(1,"nuts",654,15,65,2.6);
        dbm.insertFoodInformation(2,"banana",89,1.1,0.3,12);
        dbm.insertFoodInformation(3,"spinach",7,0.86,0,0);
        dbm.insertFoodInformation(4,"egg",155,13,11,1.1);
        dbm.insertFoodInformation(5,"salmon",208,20,13,0);
        dbm.insertFoodInformation(6,"lean beef",250,26,15,0);
        dbm.insertFoodInformation(7,"chicken",239,27,14,0);

        /*
        dbm.insertRercipeVideo(0,"511582457");
        dbm.insertRercipeVideo(1,"509716824");
        dbm.insertRercipeVideo(2,"508037594");
        dbm.insertRercipeVideo(3,"507084029");
        dbm.insertRercipeVideo(4,"506147217");
        dbm.insertRercipeVideo(5,"506097066");
        dbm.insertRercipeVideo(6,"505739508");
        dbm.insertRercipeVideo(7,"505739133");
        dbm.insertRercipeVideo(8,"502649719");
        dbm.insertRercipeVideo(9,"501905233");
        dbm.insertRercipeVideo(10,"499200488");
        dbm.insertRercipeVideo(11,"499125231");
        dbm.insertRercipeVideo(12,"497625898");
        dbm.insertRercipeVideo(13,"492401376");
        dbm.insertRercipeVideo(14,"492399739");
        dbm.insertRercipeVideo(15,"492399293");
        dbm.insertRercipeVideo(16,"488011559");
        dbm.insertRercipeVideo(17,"488010676");
        dbm.insertRercipeVideo(18,"485470550");
        dbm.insertRercipeVideo(19,"484449058");
        dbm.insertRercipeVideo(20,"483962914");
        dbm.insertRercipeVideo(21,"483468322");
        dbm.insertRercipeVideo(22,"481160577");
        dbm.insertRercipeVideo(23,"480462567");
        dbm.insertRercipeVideo(24,"480272376");
        dbm.insertRercipeVideo(25,"478385295");
        dbm.insertRercipeVideo(26,"477151725");
        dbm.insertRercipeVideo(27,"477151520");
        dbm.insertRercipeVideo(28,"475913883");
        dbm.insertRercipeVideo(29,"474654482");
        dbm.insertRercipeVideo(30,"470585451");
        dbm.insertRercipeVideo(31,"468475783");
        dbm.insertRercipeVideo(32,"463408140");
        dbm.insertRercipeVideo(33,"460959448");
        dbm.insertRercipeVideo(34,"460191457");
        dbm.insertRercipeVideo(35,"460191299");
        dbm.insertRercipeVideo(36,"458576336");
        dbm.insertRercipeVideo(37,"458576018");
        dbm.insertRercipeVideo(38,"457061568");
        dbm.insertRercipeVideo(39,"456265984");
        dbm.insertRercipeVideo(40,"455223106");
        dbm.insertRercipeVideo(41,"455217677");
        dbm.insertRercipeVideo(42,"455217266");
        dbm.insertRercipeVideo(43,"451244111");
        dbm.insertRercipeVideo(44,"449336677");
        dbm.insertRercipeVideo(45,"441069890");
        dbm.insertRercipeVideo(46,"439968079");
        dbm.insertRercipeVideo(47,"438536665");
        dbm.insertRercipeVideo(48,"437842896");
        dbm.insertRercipeVideo(49,"436767300");
        dbm.insertRercipeVideo(50,"431459085");
        dbm.insertRercipeVideo(51,"430704167");
        dbm.insertRercipeVideo(52,"430343325");
        dbm.insertRercipeVideo(53,"429933575");
        dbm.insertRercipeVideo(54,"429933554");
        */
        /*
        dbm.insertExerciseVideo(0,"512551820");
        dbm.insertExerciseVideo(1,"511158996");
        dbm.insertExerciseVideo(2,"511158825");
        dbm.insertExerciseVideo(3,"507005667");
        dbm.insertExerciseVideo(4,"501907540");
        dbm.insertExerciseVideo(5,"497980379");
        dbm.insertExerciseVideo(6,"497657534");
        dbm.insertExerciseVideo(7,"480272500");
        dbm.insertExerciseVideo(8,"477151391");
        dbm.insertExerciseVideo(9,"475914217");
        dbm.insertExerciseVideo(10,"470585398");
        dbm.insertExerciseVideo(11,"470165436");
        dbm.insertExerciseVideo(12,"464498409");
        dbm.insertExerciseVideo(13,"462649958");
        dbm.insertExerciseVideo(14,"461399070");
        dbm.insertExerciseVideo(15,"455222599");
        dbm.insertExerciseVideo(16,"449336188");
        dbm.insertExerciseVideo(17,"449335850");
        dbm.insertExerciseVideo(18,"442751123");
        dbm.insertExerciseVideo(19,"437143366");
        dbm.insertExerciseVideo(20,"427395039");
        */

        ImageButton start = (ImageButton) findViewById(R.id.start);

        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, Home.class);

                startActivity(i);
            }
        });

        dbm.close();
    }
}