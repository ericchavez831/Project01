package com.cst438.project01.group08;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Path;

public interface ApiInterface {
    @Headers({"x-rapidapi-key: c91b63fe30mshb3a3bbc701b73f4p164cf9jsn79fbf7d522a7","x-rapidapi-host: exercisedb.p.rapidapi.com"})
    @GET("exercises")
    Call<List<Exercise>> getExercises();

    @Headers({"x-rapidapi-key: c91b63fe30mshb3a3bbc701b73f4p164cf9jsn79fbf7d522a7","x-rapidapi-host: exercisedb.p.rapidapi.com"})
    @GET("exercises/bodypart/{body}")
    Call<List<Exercise>> getByBodypart(@Path("body") String bodypart);

}
