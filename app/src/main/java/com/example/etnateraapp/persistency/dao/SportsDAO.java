package com.example.etnateraapp.persistency.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;


import com.example.etnateraapp.model.SportResult;


import java.util.List;

@Dao
public interface SportsDAO {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void addSports(SportResult sportResult);

    @Query("SELECT * FROM sports")
    List<SportResult> getAllLocalSports();

}
