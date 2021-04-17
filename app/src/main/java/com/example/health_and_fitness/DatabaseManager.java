package com.example.health_and_fitness;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;


import static com.example.health_and_fitness.DatabaseHelper.DATABASE_TABLE1;
import static com.example.health_and_fitness.DatabaseHelper.DATABASE_TABLE2;
import static com.example.health_and_fitness.DatabaseHelper.DATABASE_TABLE3;
import static com.example.health_and_fitness.DatabaseHelper.DATABASE_TABLE4;
import static com.example.health_and_fitness.DatabaseHelper.DATABASE_TABLE5;
import static com.example.health_and_fitness.DatabaseHelper.DATABASE_TABLE6;

import static com.example.health_and_fitness.DatabaseHelper.KEY_FRIENDS_ID;
import static com.example.health_and_fitness.DatabaseHelper.KEY_FIENDS_NAME;
import static com.example.health_and_fitness.DatabaseHelper.KEY_USERNAME;

import static com.example.health_and_fitness.DatabaseHelper.KEY_STEPS_ID;
import static com.example.health_and_fitness.DatabaseHelper.KEY_WALK_STEPS;

import static com.example.health_and_fitness.DatabaseHelper.KEY_TIMETABLE_ID;
import static com.example.health_and_fitness.DatabaseHelper.KEY_ACTIVITY_NAME;
import static com.example.health_and_fitness.DatabaseHelper.KEY_ACTIVITY_TIME;

import static com.example.health_and_fitness.DatabaseHelper.KEY_FOOD_ID;
import static com.example.health_and_fitness.DatabaseHelper.KEY_FOOD_NAME;
import static com.example.health_and_fitness.DatabaseHelper.KEY_FOOD_VIDEO_URL;

import static com.example.health_and_fitness.DatabaseHelper.KEY_EXERCISE_ID;
import static com.example.health_and_fitness.DatabaseHelper.KEY_EXERCISE_NAME;
import static com.example.health_and_fitness.DatabaseHelper.KEY_EXERCISE_VIDEO_URL;

import static com.example.health_and_fitness.DatabaseHelper.KEY_FOOD_INFORMATION_ID;
import static com.example.health_and_fitness.DatabaseHelper.KEY_CALORIES_PER_100_GRAMS;
import static com.example.health_and_fitness.DatabaseHelper.KEY_PROTEIN_PER_100_GRAM;
import static com.example.health_and_fitness.DatabaseHelper.KEY_FATS_PER_100_GRAM;
import static com.example.health_and_fitness.DatabaseHelper.KEY_SUGAR_PER_100_GRAM;



public class DatabaseManager extends MainActivity
{
    Context context;
    private DatabaseHelper myDatabaseHelper;
    private SQLiteDatabase myDatabase;

    public DatabaseManager(Context context)
    {
        this.context = context;
    }

    public DatabaseManager open() throws SQLException {
        myDatabaseHelper = new DatabaseHelper(context);
        myDatabase = myDatabaseHelper.getWritableDatabase();
        return this;
    }

    //---closes the database--- any activity that uses the dB will need to do this
    public void close()
    {
        myDatabaseHelper.close();
    }

}