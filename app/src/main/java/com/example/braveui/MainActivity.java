package com.example.braveui;


import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TimerDialogFragment timerDialogFragment = new TimerDialogFragment();
        timerDialogFragment.show(getSupportFragmentManager(), TimerDialogFragment.TAG);
    }
}
