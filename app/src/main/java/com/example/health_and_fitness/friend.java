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
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;

public class friend extends ListActivity {

    String[] friend = {"friend1", "friend2", "friend3", "friend4", "friend5"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.friend);

        MyCustomAdapter myAdapter = new MyCustomAdapter(this, R.layout.friendrow, friend);
        setListAdapter(myAdapter);

        ImageButton back = (ImageButton) findViewById(R.id.back);
        Button addfriend = (Button) findViewById(R.id.addfriend);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        //hop
        addfriend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(friend.this, Add_Friend.class);
                startActivity(i);
            }
        });
    }

    public void onListItemClick(ListView lv, View v, int position, long id) {
        String selection = lv.getItemAtPosition(position).toString();
        Intent i = new Intent(friend.this, Friend_View.class);

        startActivity(i);
    }

    public class MyCustomAdapter extends ArrayAdapter<String>
    {
        public MyCustomAdapter(Context context, int rowLayoutId, String[] myArrayData) {
            super(context, rowLayoutId, myArrayData);
        }

        public View getView(int position, View convertView, ViewGroup parent) {
            View row;
            LayoutInflater inflater = getLayoutInflater();
            row = inflater.inflate(R.layout.friendrow, parent, false);

            TextView label = (TextView) row.findViewById(R.id.friends);
            label.setText(friend[position]);

            return row;
        }
    }
}