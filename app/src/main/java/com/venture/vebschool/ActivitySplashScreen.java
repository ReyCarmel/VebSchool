package com.venture.vebschool;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.github.silvestrpredko.dotprogressbar.DotProgressBar;
import com.github.silvestrpredko.dotprogressbar.DotProgressBarBuilder;
import com.venture.vebschool.databases.DBTransactionFunctions;

public class ActivitySplashScreen extends AppCompatActivity {
DBTransactionFunctions dbTransactionFunctions;
    @SuppressLint("ResourceAsColor")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_splash_screen);
        DotProgressBar dotProgressBar= findViewById(R.id.dot_progress_bar);
       dotProgressBar.changeAnimationDirection(DotProgressBar.RIGHT_DIRECTION);
       dotProgressBar.changeStartColor(R.color.colorGreen);
       dotProgressBar.changeEndColor(R.color.colorGreenLite);
        dbTransactionFunctions=new DBTransactionFunctions(getApplicationContext());
       dbTransactionFunctions.insertData();
        Thread background = new Thread() {
            public void run() {
                try {
                    // Thread will sleep for 5 seconds
                    sleep(5*1000);

                    // After 5 seconds redirect to another intent
                    Intent i=new Intent(ActivitySplashScreen.this,Login.class);
                    startActivity(i);
                    finish();
                } catch (Exception e) {
                }
            }
        };
        // start thread
        background.start();

    }
}
