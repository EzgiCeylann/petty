package com.petty.app.database;

import android.content.Context;
import com.petty.app.model.BehaviorLog;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class PetRepository {

    private BehaviorLogDao behaviorLogDao;
    private ExecutorService executorService;

    public PetRepository(Context context) {
        AppDatabase db = AppDatabase.getInstance(context);
        behaviorLogDao = db.behaviorLogDao();
        executorService = Executors.newSingleThreadExecutor();
    }

    public void insertLog(BehaviorLog log) {
        executorService.execute(() -> behaviorLogDao.insert(log));
    }

    public void getAllLogs(Callback<List<BehaviorLog>> callback) {
        executorService.execute(() -> {
            List<BehaviorLog> logs = behaviorLogDao.getAllLogs();
            callback.onResult(logs);
        });
    }

    public void getLogsSince(long startTime, Callback<List<BehaviorLog>> callback) {
        executorService.execute(() -> {
            List<BehaviorLog> logs = behaviorLogDao.getLogsSince(startTime);
            callback.onResult(logs);
        });
    }

    public interface Callback<T> {
        void onResult(T result);
    }
}