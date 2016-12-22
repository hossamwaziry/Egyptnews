package com.hossam.egyptnews;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class SplashScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        splash();

    }


    private void splash(){

        Handler friend = new Handler();

        friend.postDelayed(new Runnable() {
            @Override
            public void run() {

                startActivity(new Intent(SplashScreen.this ,MainActivity.class ));

            }
        },3000);

    }
}
