package com.boxfarming.assignmentcriticalog.db;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {LocationDetails.class}, version = 1, exportSchema = false)
public abstract class AppDatabase extends RoomDatabase {
    public abstract LocationDao getLocationDao();
}
