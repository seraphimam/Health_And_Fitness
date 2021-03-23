package com.example.health_and_fitness;

import android.app.ListActivity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

public class friend extends ListActivity {

    String[] friends = {"friend1", "friend2", "friend3", "friend4", "friend5"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.friend);

        MyCustomAdapter myAdapter = new MyCustomAdapter(this, R.layout.row, friends);
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

            TextView label = (TextView) row.findViewById(R.id.text);
            label.setText(friends[position]);


            return row;
        }
    }
}