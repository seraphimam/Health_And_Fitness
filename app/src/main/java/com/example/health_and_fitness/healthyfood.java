package com.example.health_and_fitness;


import android.app.ListActivity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class healthyfood extends ListActivity {

    String[] foods = {"apple","nuts","banana","spinach"," "};
    int[] img = {R.drawable.apple,R.drawable.nuts,R.drawable.banana,R.drawable.spinach, };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.healthy_food);

        MyCustomAdapter myAdapter = new MyCustomAdapter(this, R.layout.row, foods);
        setListAdapter(myAdapter);

    }

    public class MyCustomAdapter extends ArrayAdapter<String>
    {
        public MyCustomAdapter(Context context, int rowLayoutId, String[] myArrayData) {
            super(context, rowLayoutId, myArrayData);
        }

        public View getView(int position, View convertView, ViewGroup parent) {
            View row;
            LayoutInflater inflater = getLayoutInflater();
            row = inflater.inflate(R.layout.row, parent, false);

            TextView label1 = (TextView) row.findViewById(R.id.healthyfood1);
            label1.setText(foods[position]);

            TextView label2 = (TextView) row.findViewById(R.id.healthyfood2);
            label2.setText(foods[position+2]);

            ImageView icon1 = (ImageView) row.findViewById(R.id.food1);
            ImageView icon2 = (ImageView) row.findViewById(R.id.food2);

            icon1.setImageResource(img[position]);
            icon2.setImageResource(img[position+2]);


            return row;
        }
    }
}