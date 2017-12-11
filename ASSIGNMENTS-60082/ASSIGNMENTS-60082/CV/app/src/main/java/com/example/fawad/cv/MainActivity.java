package com.example.fawad.cv;

import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void change(View view){
        FragmentManager mgr=getSupportFragmentManager();
        switch (view.getId()){
            case R.id.button:
                PersonalFragment f=new PersonalFragment();
                mgr.beginTransaction().replace(R.id.fragment,f)
                        .commit();
                break;
            case R.id.button2:
                SkillFragment s=new SkillFragment();
                mgr.beginTransaction().replace(R.id.fragment,s)
                        .commit();
                break;

            case R.id.button3:
                ExpFragment e=new ExpFragment();
                mgr.beginTransaction().replace(R.id.fragment,e)
                        .commit();
                break;
            default:
                break;
        }
    }
}
