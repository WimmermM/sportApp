package com.example.etnateraapp.service;

import android.util.Log;

import com.example.etnateraapp.api.model.APIResponse;
import com.example.etnateraapp.api.model.CustomCallback;
import com.example.etnateraapp.api.service.EtnaterAPI;
import com.example.etnateraapp.model.SportResult;
import com.example.etnateraapp.persistency.Database;


import retrofit2.Call;
import retrofit2.Response;

import static android.content.ContentValues.TAG;

public class SportService {

    private Database database;
    private EtnaterAPI etnaterAPI;


    public SportService(Database database, EtnaterAPI etnaterAPI) {
        this.database = database;
        this.etnaterAPI = etnaterAPI;
    }

    public void addToFireBase(SportResult sportResult){
        etnaterAPI.addSport(sportResult).enqueue(new CustomCallback<APIResponse>() {
            @Override
            public void onResponse(Call<APIResponse> call, Response<APIResponse> response) {
                Log.d(TAG, "onResponse: done");
            }
        });

    }

    public void addToLocalDB(SportResult sportResult){
        database.sportsDAO().addSports(sportResult);
        Log.d(TAG, "addToLocalDB: done");
    }


}
