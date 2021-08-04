package com.boxfarming.assignmentcriticalog;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.work.Worker;
import androidx.work.WorkerParameters;

import com.boxfarming.assignmentcriticalog.db.DatabaseClient;
import com.boxfarming.assignmentcriticalog.db.LocationDetails;

public class LocationPeriodicWork extends Worker {

    private Context context;

    public LocationPeriodicWork(@NonNull Context context, @NonNull WorkerParameters workerParams) {
        super(context, workerParams);
        this.context = context;
    }

    @NonNull
    @Override
    public Result doWork() {
        sendLocationDetailsOnServer();
        return Result.success();
    }

    private void sendLocationDetailsOnServer() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                DatabaseClient.getInstance(context)
                        .getAppDatabase()
                        .getLocationDao()
                        .getLocationDetailsList();
            }
        }).start();
    }
}
