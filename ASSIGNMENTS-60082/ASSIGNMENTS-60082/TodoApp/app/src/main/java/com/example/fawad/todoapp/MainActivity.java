package com.example.fawad.todoapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    public static ArrayList<String> Data;
    public static int counter=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Data=new ArrayList<String>();
        //Data=new String[]{"1,mera Title,mere description,0","2,dosra Title,dosre description,1"};


    }

    public void showList(View view){

//        Bundle b=new Bundle();
//        b.putStringArray("DATA", Data);
        Intent intent=new Intent(this, ListActivity.class);
       // intent.putExtras(b);
        startActivity(intent);
    }
    public void AddTodo(View view ){
        EditText title=findViewById(R.id.title);
        EditText descp=findViewById(R.id.descp);
        String text=counter+","+title.getText().toString()+","+descp.getText().toString()+","+0;
        Data.add(text);
        title.setText("");
        descp.setText("");
    }
}
