package com.example.fawad.todoapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class ListActivity extends AppCompatActivity {

    ArrayList<String> Data;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
//        Intent i=getIntent();
//        Data=i.getExtras().getStringArray("DATA");
        Data=MainActivity.Data;
        RecyclerView recycler = (RecyclerView) findViewById(R.id.my_recycler_view);

        recycler.setHasFixedSize(true);

        // use a linear layout manager
        LinearLayoutManager linear = new LinearLayoutManager(this);
        recycler.setLayoutManager(linear);

        // specify an adapter (see also next example)
        recycler.setAdapter(new myAdapter(Data));
    }
}
