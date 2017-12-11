package com.example.fawad.highlowgame;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    String userName="",userEmail="";
    int userCorrectGuess=0,userWrongGuess=0,wrongGuessLimit=5,level=1,number=0,range=50;
    HighScore highscoreObj;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        highscoreObj=new HighScore(this);
        Intent intent =getIntent();
        userName=intent.getStringExtra("NAME");
        userEmail=intent.getStringExtra("EMAIL");
        number=new Random().nextInt(range);
        Log.i("number",Integer.toString(number));
        TextView lvl=(TextView)findViewById(R.id.level);
        lvl.setText(Integer.toString(level));
    }

    public void Guess(View view){

        EditText text=(EditText)findViewById(R.id.userText);


        int userGuess=Integer.parseInt(text.getText().toString());
        if(number<userGuess){
            Toast.makeText(getApplicationContext(),"Number is Less than "+userGuess,Toast.LENGTH_SHORT).show();
            userWrongGuess++;
            if(checkGameOver()){
               Toast.makeText(getApplicationContext(),"Game Over !",Toast.LENGTH_SHORT).show();
                highscoreObj.InsertData(userEmail,userName,userCorrectGuess);
                moveToHighScore();
            }
            text.setText("");
        }
        else if(number > userGuess){
            Toast.makeText(getApplicationContext(),"Number is Greater than "+userGuess,Toast.LENGTH_SHORT).show();
            userWrongGuess++;
            if(checkGameOver()){
                Toast.makeText(getApplicationContext(),"Game Over !",Toast.LENGTH_SHORT).show();
                highscoreObj.InsertData(userEmail,userName,userCorrectGuess);
                moveToHighScore();
            }
            text.setText("");
        }
        else{
            Toast.makeText(getApplicationContext(),"Perfect Number is "+number,Toast.LENGTH_SHORT).show();
            userCorrectGuess++;
            if(range==1000){
                Toast.makeText(getApplicationContext(),"Congrats You Finish the game ",Toast.LENGTH_SHORT).show();
                highscoreObj.InsertData(userEmail,userName,userCorrectGuess);
                moveToHighScore();
            }
            range+=50;
            level++;
            number=new Random().nextInt(range);
            Log.i("number:",number+"");
            text.setText("");
            TextView lvl=(TextView) findViewById(R.id.level);
            TextView correctGuessScore=(TextView) findViewById(R.id.correct_guess);
            lvl.setText(level+"");
            correctGuessScore.setText(userCorrectGuess+"");

        }


    }

    private void moveToHighScore(){
        Intent intent =new Intent(this,HighScoreActivity.class);
        startActivity(intent);
    }

    private boolean checkGameOver(){
        if(userWrongGuess>=wrongGuessLimit) return true;
        return false;
    }
}
