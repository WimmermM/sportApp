package com.example.etnateraapp.dagger.module;

import android.app.Application;
import android.arch.persistence.room.Room;
import android.content.Context;

import com.example.etnateraapp.Constants;
import com.example.etnateraapp.adapter.MyRecyclerViewAdapter;
import com.example.etnateraapp.api.service.EtnaterAPI;
import com.example.etnateraapp.model.SportResult;
import com.example.etnateraapp.persistency.Database;
import com.example.etnateraapp.service.ListService;
import com.example.etnateraapp.service.SportService;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
public class AppModule {

    @Provides
    @Singleton
    @Inject
    Database database(Context context){
        return Room.databaseBuilder(context,Database.class,"mydb").allowMainThreadQueries().build();
    }

    @Provides
    @Singleton
    Context provideContext(Application application) {
        return application;
    }

    @Provides
    @Singleton
    EtnaterAPI api(){
        return new Retrofit.Builder().baseUrl(Constants.API_URL).addConverterFactory(GsonConverterFactory.create()).build().create(EtnaterAPI.class);
    }

    @Provides
    @Singleton
    SportResult sportResult(){
        return new SportResult();
    }

    @Provides
    @Singleton
    @Inject
    SportService sportService(Database database, EtnaterAPI etnaterAPI){
        return new SportService(database,etnaterAPI);
    }

    @Provides
    @Singleton
    @Inject
    MyRecyclerViewAdapter myRecyclerViewAdapter(){
        return new MyRecyclerViewAdapter();
    }

    @Provides
    @Singleton
    @Inject
    ListService listService(Database database, EtnaterAPI etnaterAPI){
        return new ListService(database,etnaterAPI);
    }

}
