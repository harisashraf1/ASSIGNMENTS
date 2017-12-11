package com.example.fawad.highlowgame;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class WelcomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
    }

    public void Play(View view){
        EditText email=(EditText)findViewById(R.id.emailText);
        EditText name=(EditText)findViewById(R.id.nameText);
        if(email.getText().toString()=="" || name.getText().toString()==""){
            Toast.makeText(getApplicationContext(),"Please Provide Proper details",Toast.LENGTH_SHORT);
            return;
        }
        Intent  intent = new Intent(this,MainActivity.class);
        intent.putExtra("EMAIL",email.getText().toString());
        intent.putExtra("NAME",name.getText().toString());
        startActivity(intent);

    }
}
