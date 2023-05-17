package com.notebook.collegeapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class splash_screen_activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {


        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                // Start the main activity or any other desired activity
                Intent intent = new Intent(splash_screen_activity.this, MainActivity.class);
                startActivity(intent);
                finish(); // Close the splash screen activity
            }
        }, 600);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
    }
}