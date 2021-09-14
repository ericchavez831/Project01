package com.cst438.project01.group08;

import android.os.AsyncTask;

import java.io.IOException;
import java.nio.channels.AsynchronousChannelGroup;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiCall{
    // URL: https://rapidapi.com/justin-WFnsXH_t6/api/exercisedb
    // API URL endpoint: https://exercisedb.p.rapidapi.com/exercises
    // x-rapidapi-key: c91b63fe30mshb3a3bbc701b73f4p164cf9jsn79fbf7d522a7
    // x-rapidapi-host: exercisedb.p.rapidapi.com
    /* Example response:
        {
    "bodyPart":"string"
    "equipment":"string"
    "gifUrl":"string"
    "id":"string"
    "name":"string"
    "target":"string"
    }
     */
    public List<Exercise> getByName(String name){

        return null;
    }
    public List<Exercise> getByBodypart(String bodypart){

        return null;
    }
    public static List<Exercise> getExercises(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://exercisedb.p.rapidapi.com")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        ApiInterface apiInterface = retrofit.create(ApiInterface.class);

        Call<List<Exercise>> call = apiInterface.getExercises();

        List<Exercise> apiResponse = new ArrayList<>();



        call.enqueue(new Callback<List<Exercise>>() {
            @Override
            public void onResponse(Call<List<Exercise>> call, Response<List<Exercise>> response) {
                if(!response.isSuccessful()){
                    System.out.println("Response unsuccessful");
                }
                else {
                    System.out.println("Successful API call");
                    apiResponse.addAll(response.body());
                }
            }

            @Override
            public void onFailure(Call<List<Exercise>> call, Throwable t) {
                System.out.println("Failed API call");
            }
        });

        return apiResponse;
    }
}


