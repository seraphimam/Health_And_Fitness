package com.example.health_and_fitness;


import android.app.ListActivity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class healthyfood extends ListActivity {

    String[] foods = {"apple","nuts","banana","spinach","pear"};
    int[] img = {R.drawable.apple,R.drawable.nuts,R.drawable.banana,R.drawable.spinach,R.drawable.pear};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.healthy_food);

        MyCustomAdapter myAdapter = new MyCustomAdapter(this, R.layout.healthyfoodrow, foods);
        setListAdapter(myAdapter);

        ImageButton back = (ImageButton) findViewById(R.id.back);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

    }


    public class MyCustomAdapter extends ArrayAdapter<String>
    {
        public MyCustomAdapter(Context context, int rowLayoutId, String[] myArrayData) {
            super(context, rowLayoutId, myArrayData);
        }

        public View getView(int position, View convertView, ViewGroup parent) {
            View row;
            LayoutInflater inflater = getLayoutInflater();
            row = inflater.inflate(R.layout.healthyfoodrow, parent, false);

            TextView label1 = (TextView) row.findViewById(R.id.healthyfood1);
            label1.setText(foods[position]);
            TextView label2 = (TextView) row.findViewById(R.id.healthyfood2);
            label2.setText(foods[++position+1]);
            ImageView icon1 = (ImageView) row.findViewById(R.id.food1);
            icon1.setImageResource(img[position]);
            ImageView icon2 = (ImageView) row.findViewById(R.id.food2);
            icon2.setImageResource(img[++position+1]);

            return row;
        }
    }
}