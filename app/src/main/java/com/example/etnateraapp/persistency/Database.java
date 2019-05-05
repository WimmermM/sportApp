package com.example.etnateraapp.persistency;

import android.arch.persistence.room.RoomDatabase;

import com.example.etnateraapp.model.SportResult;
import com.example.etnateraapp.persistency.dao.SportsDAO;

@android.arch.persistence.room.Database(entities = {SportResult.class}, version = 1, exportSchema = false)
public abstract class Database extends RoomDatabase {

    public abstract SportsDAO sportsDAO();
}
