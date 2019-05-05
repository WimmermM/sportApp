package com.example.etnateraapp.service;

import android.util.Log;

import com.example.etnateraapp.adapter.MyRecyclerViewAdapter;
import com.example.etnateraapp.api.service.EtnaterAPI;
import com.example.etnateraapp.model.SportResult;
import com.example.etnateraapp.model.SportResults;
import com.example.etnateraapp.persistency.Database;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static android.content.ContentValues.TAG;

public class ListService {

    List<SportResult> sportResultList;
    Database database;
    EtnaterAPI etnaterAPI;


    public ListService(Database database, EtnaterAPI etnaterAPI) {
        this.database = database;
        this.etnaterAPI = etnaterAPI;
    }

    public List<SportResult> getFromDB(){
        sportResultList = new ArrayList<>();
        etnaterAPI.getSportResults().enqueue(new Callback<SportResults>() {
            @Override
            public void onResponse(Call<SportResults> call, Response<SportResults> response) {
                Log.d(TAG, "onResponse: fine");
                sportResultList = response.body().getSportResults();
            }

            @Override
            public void onFailure(Call<SportResults> call, Throwable t) {
                Log.d(TAG, "onFailure: Error");
            }
        });

        sportResultList.addAll(database.sportsDAO().getAllLocalSports());

        return sportResultList;
    }

}
