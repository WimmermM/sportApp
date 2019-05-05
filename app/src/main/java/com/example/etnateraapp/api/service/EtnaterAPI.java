package com.example.etnateraapp.api.service;

import com.example.etnateraapp.api.model.APIResponse;
import com.example.etnateraapp.model.SportResult;
import com.example.etnateraapp.model.SportResults;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface EtnaterAPI {

    @Headers("Accept: application/json")
    @GET("sports.json")
    Call<SportResults> getSportResults();

    @POST("sports.json")
    Call<APIResponse> addSport(@Body SportResult sportResult);
}
