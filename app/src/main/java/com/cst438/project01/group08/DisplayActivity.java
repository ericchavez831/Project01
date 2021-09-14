package com.cst438.project01.group08;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.os.Bundle;
import java.util.ArrayList;

public class DisplayActivity extends AppCompatActivity {
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display);

        // ArrayList that contains the Exercises
        ArrayList<ExampleExercise> exampleList = new ArrayList<>();
        exampleList.add(new ExampleExercise("Jumping Jacks", "None", "Quads", "Legs"));
        exampleList.add(new ExampleExercise("Squats", "Machine", "Calf", "Legs"));
        exampleList.add(new ExampleExercise("Bench Press", "Bench", "Biceps", "Arms"));
        exampleList.add(new ExampleExercise("Cardio", "Treadmill", "Calf", "Legs"));
        exampleList.add(new ExampleExercise("Sit-Ups", "None", "Abs", "Abs"));
        exampleList.add(new ExampleExercise("Curls", "Dumbbell", "Biceps", "Arms"));
        exampleList.add(new ExampleExercise("Suicides", "None", "Quads", "Legs"));
        exampleList.add(new ExampleExercise("Planks", "None", "Biceps", "Arms"));
        exampleList.add(new ExampleExercise("Wall Sit", "None", "Quads", "Legs"));

        // adds the exercises to the recycler
        mRecyclerView = findViewById(R.id.rvExercises);
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(this);
        mAdapter = new ExampleAdapter(exampleList);
        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setAdapter(mAdapter);
    }

    // Function to check if exercises contain all information from API
    public static boolean missingExerciseInfo(){
        return false;
    }
}