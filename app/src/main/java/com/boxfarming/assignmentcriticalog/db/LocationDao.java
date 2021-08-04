package com.boxfarming.assignmentcriticalog.db;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface LocationDao {

    @Insert
    void insertLocationDetails(LocationDetails locationDetails);

    @Query("SELECT * FROM " + Constant.TABLE_NAME )
    List<LocationDetails> getLocationDetailsList();

    @Query("DELETE FROM " + Constant.TABLE_NAME)
    void deleteAllLocationDetailsList();
}
