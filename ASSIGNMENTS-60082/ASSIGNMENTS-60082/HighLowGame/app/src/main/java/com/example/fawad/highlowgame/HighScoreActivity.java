package com.example.fawad.highlowgame;

import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class HighScoreActivity extends AppCompatActivity {

    HighScore scoreObj;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_high_score);
        TextView scoreText=(TextView)findViewById(R.id.score);
        scoreObj=new HighScore(this);
        Cursor cursor=scoreObj.ReadData();
        while(cursor.moveToNext()){
            String email=cursor.getString(
                    cursor.getColumnIndex(scoreObj.COL_1)
            );
            String name=cursor.getString(
                    cursor.getColumnIndex(scoreObj.COL_2)
            );
            String score=cursor.getString(
                    cursor.getColumnIndex(scoreObj.COL_3)
            );
            scoreText.append(email+" - "+name+" - "+score+"\n");
        }
    }
}
