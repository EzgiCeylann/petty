package com.petty.app.database;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import com.petty.app.model.BehaviorLog;
import java.util.List;

@Dao
public interface BehaviorLogDao {

    @Insert
    void insert(BehaviorLog log);

    @Query("SELECT * FROM behavior_logs ORDER BY timestamp DESC")
    List<BehaviorLog> getAllLogs();

    @Query("SELECT * FROM behavior_logs WHERE timestamp >= :startTime ORDER BY timestamp DESC")
    List<BehaviorLog> getLogsSince(long startTime);
}