package com.example.experthp.ajayelectro;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import java.util.Timer;
import java.util.TimerTask;
import android.content.Intent;
import android.util.Log;

public class Start extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);
        Log.d("on","create");

        new Timer().schedule(new TimerTask() {
            public void run() {
                startActivity(new Intent(Start.this, Expandable_Slideview.class));

            }
        }, 10000);
    }

    @Override
    protected void onPostResume() {
        super.onPostResume();
        Log.d("on", "onPostResume");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("on", "onDestroy");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("on", "onStop");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("on", "onPause");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("on", "onResume");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("on", "onStart");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d("on", "onRestart");
    }
}
