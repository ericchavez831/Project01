package com.cst438.project01.group08;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import java.io.IOException;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        System.out.println("Printing exercises");
        List<Exercise> exercises = null;
        exercises = ApiCall.getExercises();

        System.out.println("Exercises: " + exercises);
    }
}