package com.example.health_and_fitness;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.util.Log;

import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;

import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;


public class healthyfood extends AppCompatActivity {

    GridView gridview;
    DatabaseManager dbm = new DatabaseManager(this);

    int[] img = {R.drawable.apple,R.drawable.nuts,R.drawable.banana,R.drawable.spinach,
            R.drawable.egg,R.drawable.salmon,R.drawable.lean_beef,R.drawable.chicken,
            R.drawable.yogurt,R.drawable.beans,R.drawable.cottage_cheese,R.drawable.avocado,
            R.drawable.olive_oil,R.drawable.potatoes,R.drawable.coconut_oil,};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.healthyfood);

        gridview = findViewById(R.id.gridView);

        ImageButton back = (ImageButton) findViewById(R.id.back);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        Cursor mCursor;
        DatabaseManager dbm = new DatabaseManager(this);
        dbm.open();
        mCursor = dbm.getAllFood();
        ArrayList<String> foodlist = new ArrayList<String>();
        while(mCursor.moveToNext())
        {
            try{
                foodlist.add(mCursor.getString(1));
            }
            catch(Exception e){
                Log.d("error ",e.toString());
            }
        }
        final String[] foods = (String[]) foodlist.toArray(new String[foodlist.size()]);

        CustomAdapter customerAdapter = new CustomAdapter(foods, img,this);

        gridview.setAdapter(customerAdapter);

        gridview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String selectedNames = foods[position];
                int selectedImages = img[position];
                Intent i = new Intent(healthyfood.this, food_information.class);
                startActivity(i.putExtra("name",selectedNames).putExtra("image",selectedImages));
            }
        });
    }

    public class CustomAdapter extends BaseAdapter
    {
        private String[] label;
        private int[] icon;
        private Context context;
        private LayoutInflater layoutinflater;

        public CustomAdapter(String[] label, int[] icon, Context context) {
            this.label = label;
            this.icon = icon;
            this.context = context;
            this.layoutinflater = (LayoutInflater) context.getSystemService(LAYOUT_INFLATER_SERVICE);
        }


        @Override
        public int getCount() {
            return icon.length;
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View view, ViewGroup viewGroup) {
            if(view == null)
            {
                view = layoutinflater.inflate(R.layout.healthyfood_row_items, viewGroup, false);
            }

            Cursor mCursor;
            dbm.open();
            mCursor = dbm.getAllFood();
            ArrayList<String> foodlist = new ArrayList<String>();
            while(mCursor.moveToNext())
            {
                try{
                    foodlist.add(mCursor.getString(1));
                }
                catch(Exception e){
                    Log.d("error ",e.toString());
                }
            }
            final String[] foods = (String[]) foodlist.toArray(new String[foodlist.size()]);

            TextView textname = view.findViewById(R.id.textname);
            ImageView imagename = view.findViewById(R.id.imageview);

            textname.setText(foods[position]);
            imagename.setImageResource(img[position]);

            return view;
        }
    }

}
