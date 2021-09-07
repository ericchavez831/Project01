package com.cst438.project01.group08;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class DisplayActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display);
    }

    // Function to check if exercises contain all information from API
    public static boolean missingExerciseInfo(){
        return false;
    }
}