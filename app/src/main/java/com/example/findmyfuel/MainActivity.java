package com.example.findmyfuel;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.Window;
import android.view.WindowManager;
import android.window.SplashScreen;

import com.example.findmyfuel.ui.login.LoginActivity;

public class MainActivity extends AppCompatActivity {

    private static int SPLASH_SCREEN = 2000;
    private static final String TAG = "Information";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.i(TAG,"Loading Application");

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent dashScreen = new Intent(MainActivity.this, FuelRecords.class);
                startActivity(dashScreen);
                finish();
            }
        },SPLASH_SCREEN);
    }
}