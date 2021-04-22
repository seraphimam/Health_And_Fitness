package com.example.health_and_fitness;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;


import static com.example.health_and_fitness.DatabaseHelper.DATABASE_TABLE1;
import static com.example.health_and_fitness.DatabaseHelper.DATABASE_TABLE2;
import static com.example.health_and_fitness.DatabaseHelper.DATABASE_TABLE4;
import static com.example.health_and_fitness.DatabaseHelper.DATABASE_TABLE5;
import static com.example.health_and_fitness.DatabaseHelper.DATABASE_TABLE6;
import static com.example.health_and_fitness.DatabaseHelper.DATABASE_TABLE7;

import static com.example.health_and_fitness.DatabaseHelper.KEY_FRIENDS_ID;
import static com.example.health_and_fitness.DatabaseHelper.KEY_FIENDS_NAME;
import static com.example.health_and_fitness.DatabaseHelper.KEY_USERNAME;

import static com.example.health_and_fitness.DatabaseHelper.KEY_STEPS_ID;
import static com.example.health_and_fitness.DatabaseHelper.KEY_WALK_STEPS;

import static com.example.health_and_fitness.DatabaseHelper.KEY_FOOD_ID;
import static com.example.health_and_fitness.DatabaseHelper.KEY_FOOD_NAME;

import static com.example.health_and_fitness.DatabaseHelper.KEY_EXERCISE_ID;
import static com.example.health_and_fitness.DatabaseHelper.KEY_EXERCISE_NAME;
import static com.example.health_and_fitness.DatabaseHelper.KEY_EXERCISE_VIDEO_URL;

import static com.example.health_and_fitness.DatabaseHelper.KEY_RECIPE_ID;
import static com.example.health_and_fitness.DatabaseHelper.KEY_RECIPE_VIDEO_VID;

import static com.example.health_and_fitness.DatabaseHelper.KEY_FOOD_INFORMATION_ID;
import static com.example.health_and_fitness.DatabaseHelper.KEY_FOOD_INFORMATION_NAME;
import static com.example.health_and_fitness.DatabaseHelper.KEY_CALORIES_PER_100_GRAMS;
import static com.example.health_and_fitness.DatabaseHelper.KEY_PROTEIN_PER_100_GRAMS;
import static com.example.health_and_fitness.DatabaseHelper.KEY_FATS_PER_100_GRAMS;
import static com.example.health_and_fitness.DatabaseHelper.KEY_SUGAR_PER_100_GRAMS;



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

    public long insertFood(int rowId, String foodName)
    {
        ContentValues initialValues = new ContentValues();
        initialValues.put(KEY_FOOD_ID,rowId);
        initialValues.put(KEY_FOOD_NAME,foodName);
        return myDatabase.insert(DATABASE_TABLE4, null, initialValues);
    }

    public long insertFoodInformation(int rowId, String foodName, int calories_per_100_grams, double protein_per_100_grams, double fats_per_100_grams, double sugar_per_100_grams)
    {
        ContentValues initialValues = new ContentValues();
        initialValues.put(KEY_FOOD_INFORMATION_ID,rowId);
        initialValues.put(KEY_FOOD_INFORMATION_NAME,foodName);
        initialValues.put(KEY_CALORIES_PER_100_GRAMS,calories_per_100_grams);
        initialValues.put(KEY_PROTEIN_PER_100_GRAMS,protein_per_100_grams);
        initialValues.put(KEY_FATS_PER_100_GRAMS,fats_per_100_grams);
        initialValues.put(KEY_SUGAR_PER_100_GRAMS,sugar_per_100_grams);
        return myDatabase.insert(DATABASE_TABLE6, null, initialValues);
    }

    public long insertRercipeVideo(int rowId, String videoVid)
    {
        ContentValues initialValues = new ContentValues();
        initialValues.put(KEY_RECIPE_ID,rowId);
        initialValues.put(KEY_RECIPE_VIDEO_VID,videoVid);
        return myDatabase.insert(DATABASE_TABLE7, null, initialValues);
    }

    public long insertExerciseVideo(int rowId, String videoVid)
    {
        ContentValues initialValues = new ContentValues();
        initialValues.put(KEY_EXERCISE_ID,rowId);
        initialValues.put(KEY_EXERCISE_NAME,videoVid);
        initialValues.put(KEY_EXERCISE_VIDEO_URL,videoVid);
        return myDatabase.insert(DATABASE_TABLE5, null, initialValues);
    }

    public Cursor SearchFoodInformation(int rowId, String foodName) throws SQLException
    {
        Cursor mCursor = null;
        if(rowId == 0)
        {
            mCursor = myDatabase.query(true, DATABASE_TABLE6, new String[] {
                            KEY_FOOD_INFORMATION_ID,
                            KEY_CALORIES_PER_100_GRAMS,
                            KEY_PROTEIN_PER_100_GRAMS,
                            KEY_FATS_PER_100_GRAMS,
                            KEY_SUGAR_PER_100_GRAMS
                    },
                    KEY_FOOD_NAME + " LIKE " + "\'" + foodName + "\'",
                    null,
                    null,
                    null,
                    null,
                    null);
        }
        else {
            mCursor = myDatabase.query(true, DATABASE_TABLE6, new String[] {
                            KEY_FOOD_INFORMATION_ID,
                            KEY_CALORIES_PER_100_GRAMS,
                            KEY_PROTEIN_PER_100_GRAMS,
                            KEY_FATS_PER_100_GRAMS,
                            KEY_SUGAR_PER_100_GRAMS
                    },
                    KEY_FOOD_ID + "=" + rowId,
                    null,
                    null,
                    null,
                    null,
                    null);
        }
        if (mCursor != null) {
            mCursor.moveToFirst();
        }
        return mCursor;
    }

    public Cursor SearchRecipeVideo(int rowId) throws SQLException
    {
        Cursor mCursor = null;

            mCursor = myDatabase.query(true, DATABASE_TABLE7, new String[] {
                            KEY_RECIPE_ID,
                            KEY_RECIPE_VIDEO_VID
                    },
                    KEY_RECIPE_ID + " = " + rowId,
                    null,
                    null,
                    null,
                    null,
                    null);

        if (mCursor != null) {
            mCursor.moveToFirst();
        }
        return mCursor;
    }

    public long getRecipeVideoAmount()
    {
        String sql = "select count(*) FROM " + DATABASE_TABLE7;
        Cursor cursor = myDatabase.rawQuery(sql, null);
        cursor.moveToFirst();
        long count = cursor.getLong(0);
        cursor.close();
        return count;
    }

    public Cursor SearchExerciseVideo(int rowId) throws SQLException
    {
        Cursor mCursor = null;

        mCursor = myDatabase.query(true, DATABASE_TABLE5, new String[] {
                        KEY_EXERCISE_ID,
                        KEY_EXERCISE_NAME,
                        KEY_EXERCISE_VIDEO_URL
                },
                KEY_EXERCISE_ID + " == " + "\'" + rowId + "\'",
                null,
                null,
                null,
                null,
                null);

        if (mCursor != null) {
            mCursor.moveToFirst();
        }
        return mCursor;
    }

    public long getExerciseVideoAmount()
    {
        String sql = "select count(*) FROM " + DATABASE_TABLE5;
        Cursor cursor = myDatabase.rawQuery(sql, null);
        cursor.moveToFirst();
        long count = cursor.getLong(0);
        cursor.close();
        return count;
    }

    public Cursor getAllFood() {
        // Select All Query
        String selectQuery = "SELECT  * FROM " + DATABASE_TABLE4;

        Cursor taskList = myDatabase.rawQuery(selectQuery, null);

        return taskList;
    }

}