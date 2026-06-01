package com.petty.app.database;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import android.content.Context;
import com.petty.app.model.BehaviorLog;

@Database(entities = {BehaviorLog.class}, version = 1, exportSchema = false)
public abstract class AppDatabase extends RoomDatabase {

    private static AppDatabase instance;

    public abstract BehaviorLogDao behaviorLogDao();

    public static synchronized AppDatabase getInstance(Context context) {
        if (instance == null) {
            instance = Room.databaseBuilder(
                    context.getApplicationContext(),
                    AppDatabase.class,
                    "petty_database"
            ).fallbackToDestructiveMigration().build();
        }
        return instance;
    }
}