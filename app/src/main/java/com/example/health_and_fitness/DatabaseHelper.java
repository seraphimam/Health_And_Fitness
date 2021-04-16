package com.example.health_and_fitness;

import android.content.Context;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class DatabaseHelper extends SQLiteOpenHelper {

    //declare database attributes
    public static final String KEY_FRIENDS_ID = "_id";
    public static final String KEY_FIENDS_NAME = "_friends_name";
    public static final String KEY_USERNAME = "username";

    public static final String KEY_STEPS_ID = "_id";
    public static final String KEY_WALK_STEPS = "walk_steps";
    public static final String KEY_S_FRIENDS_ID = "s_friends_id";

    public static final String KEY_TIMETABLE_ID = "_id";
    public static final String KEY_ACTIVITY_NAME = "activity_name";
    public static final String KEY_ACTIVITY_TIME = "activity_time";
    public static final String KEY_T_FRIENDS_ID = "t_friends_id";

    public static final String KEY_FOOD_ID = "_id";
    public static final String KEY_FOOD_NAME = "food_name";
    public static final String KEY_FOOD_VIDEO_URL = "food_video_url";
    public static final String KEY_F_TIMETABLE_ID = "f_timetable_id";

    public static final String KEY_EXERCISE_ID = "_id";
    public static final String KEY_EXERCISE_NAME = "exercise_name";
    public static final String KEY_EXERCISE_VIDEO_URL = "exercise_video_url";
    public static final String KEY_E_TIMETABLE_ID = "e_timetable_id";

    public static final String DATABASE_NAME = "health&fitness";
    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_TABLE1 = "friends";
    public static final String DATABASE_TABLE2 = "steps";
    public static final String DATABASE_TABLE3 = "timetable";
    public static final String DATABASE_TABLE4 = "food";
    public static final String DATABASE_TABLE5 = "exercise";

    //create tables
    private static final String DATABASE_CREATE1 =
            "CREATE TABLE " + DATABASE_TABLE1  +
                    "("
                    + KEY_FRIENDS_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                    + KEY_FIENDS_NAME +  " text not null, "
                    + KEY_USERNAME + " text not null"
                    + ")";
    private static final String DATABASE_CREATE2 =
            "CREATE TABLE " + DATABASE_TABLE2  + "("
                    + KEY_STEPS_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                    + KEY_WALK_STEPS +  " integer not null, "
                    + KEY_S_FRIENDS_ID + " integer not null, "
                    + "FOREIGN KEY(s_friends_id) REFERENCES friends(_id) "
                    + ")";
    private static final String DATABASE_CREATE3 =
            "CREATE TABLE " + DATABASE_TABLE3  +
                    "(" + KEY_TIMETABLE_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                    + KEY_ACTIVITY_NAME +  " text not null, "
                    + KEY_ACTIVITY_TIME + " date not null, "
                    + KEY_T_FRIENDS_ID + " integer not null, "
                    + "FOREIGN KEY(t_friends_id) REFERENCES friends(_id) "
                    + ")";
    private static final String DATABASE_CREATE4 =
            "CREATE TABLE " + DATABASE_TABLE4  +
                    "(" + KEY_FOOD_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                    + KEY_FOOD_NAME +  " text not null, "
                    + KEY_FOOD_VIDEO_URL + " text not null, "
                    + KEY_F_TIMETABLE_ID + " integer not null, "
                    + "FOREIGN KEY(f_timetable_id) REFERENCES timetable(_id) "
                    + ")";
    private static final String DATABASE_CREATE5 =
            "CREATE TABLE " + DATABASE_TABLE5  +
                    "(" + KEY_EXERCISE_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                    + KEY_EXERCISE_NAME +  " text not null, "
                    + KEY_EXERCISE_VIDEO_URL + " text not null, "
                    + KEY_E_TIMETABLE_ID + " integer not null, "
                    + "FOREIGN KEY(e_timetable_id) REFERENCES timetable(_id) "
                    + ")";
    public DatabaseHelper(Context context)
    {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(DATABASE_CREATE1);
        db.execSQL(DATABASE_CREATE2);
        db.execSQL(DATABASE_CREATE3);
        db.execSQL(DATABASE_CREATE4);
        db.execSQL(DATABASE_CREATE5);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Drop older table if existed
        db.execSQL("DROP TABLE IF EXISTS " + DATABASE_TABLE1);
        db.execSQL("DROP TABLE IF EXISTS " + DATABASE_TABLE2);
        db.execSQL("DROP TABLE IF EXISTS " + DATABASE_TABLE3);
        db.execSQL("DROP TABLE IF EXISTS " + DATABASE_TABLE4);
        db.execSQL("DROP TABLE IF EXISTS " + DATABASE_TABLE5);

        // Create tables again
        onCreate(db);

    }
}