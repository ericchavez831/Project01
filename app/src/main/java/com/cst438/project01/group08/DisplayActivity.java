package com.cst438.project01.group08;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import java.lang.Math;
import java.util.ArrayList;
import java.util.List;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 *
 * <h2><b>Display Activity</b></h2>
 * The display activity contains the functionality to get api data, search, and display exercises.
 * Exercises will be displayed using recycler view and will show ExerciseName, TargetMuscle, BodyPart,
 * and Equipment. Conner worked on API call that is used within the onCreate.
 *
 * @author Eric Chavez Velez
 */

public class DisplayActivity extends AppCompatActivity {
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    public Button search;
    public EditText userInput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://exercisedb.p.rapidapi.com")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        ApiInterface apiInterface = retrofit.create(ApiInterface.class);
        Call<List<Exercise>> call = apiInterface.getExercises();
        List<Exercise> apiResponse = new ArrayList<>();
        List<Exercise> allExercises = new ArrayList<>();
        mLayoutManager = new LinearLayoutManager(this);
        search = findViewById(R.id.btnSearch);

        call.enqueue(new Callback<List<Exercise>>() {
            @Override
            public void onResponse(Call<List<Exercise>> call, Response<List<Exercise>> response) {
                if(!response.isSuccessful()){
                    System.out.println("Response unsuccessful");
                }
                else {
                    System.out.println("Successful API call");
                    apiResponse.addAll(response.body());

                    for(int i = 0; i < 10; i++){
                        // Getting random exercises
                        int rand = (int) (Math.random() * apiResponse.size() - 1 + 1) + 1;
                        allExercises.add(new Exercise(apiResponse.get(rand).getGifUrl(), apiResponse.get(rand).getName(), apiResponse.get(rand).getEquipment(), apiResponse.get(rand).getTarget(), apiResponse.get(rand).getBodyPart()));
                    }

                    // Adding the exercises to recycler view
                    mRecyclerView = findViewById(R.id.rvExercises);
                    mRecyclerView.setHasFixedSize(true);
                    mAdapter = new ExerciseAdapter(allExercises);
                    mRecyclerView.setLayoutManager(mLayoutManager);
                    mRecyclerView.setAdapter(mAdapter);
                }
            }

            @Override
            public void onFailure(Call<List<Exercise>> call, Throwable t) {
                System.out.println("Failed API call");
            }
        });

        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String mUserInput;
                Search search = new Search();
                Boolean empty;
                int iterator;
                List<Exercise> searchedExercises;

                userInput = findViewById(R.id.etSearch);
                mUserInput = userInput.getText().toString();

                empty = emptyText(mUserInput);

                if(!empty){
                    // get exercises
                    List<Exercise> randomExercises = new ArrayList<>();
                    searchedExercises = search.getSearchData(apiResponse, mUserInput);

                    if(noExercises(searchedExercises)){
                        return;
                    }
                    // clear recycler view
                    allExercises.clear();
                    mAdapter.notifyDataSetChanged();

                    if(searchedExercises.size() < 10){
                        iterator = searchedExercises.size();
                    }
                    else{
                        iterator = 10;
                    }

                    for(int i = 0; i < iterator; i++){
                        randomExercises.add(new Exercise(searchedExercises.get(i).getGifUrl(), searchedExercises.get(i).getName(), searchedExercises.get(i).getEquipment(), searchedExercises.get(i).getTarget(), searchedExercises.get(i).getBodyPart()));
                    }

                    // Adding the exercises to recycler view
                    mRecyclerView = findViewById(R.id.rvExercises);
                    mRecyclerView.setHasFixedSize(true);
                    mAdapter = new ExerciseAdapter(randomExercises);
                    mRecyclerView.setLayoutManager(mLayoutManager);
                    mRecyclerView.setAdapter(mAdapter);

                }else{
                    Log.v("SEARCH", "Empty field");
                }
            }
        });

    }

    // Function to test if edit text contains an empty field
    public static boolean emptyText(String userInput){
        if(userInput.length() != 0){
            return false;
        }
        return true;
    }

    // Function to test if edit text contains an empty field
    public static boolean noExercises(List<Exercise> exercises){
        if(exercises.size() == 0){
            return true;
        }
        return false;
    }

}