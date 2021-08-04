package com.boxfarming.assignmentcriticalog;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.location.Location;
import android.util.Log;
import android.widget.Toast;

import androidx.room.Room;

import com.boxfarming.assignmentcriticalog.db.DatabaseClient;
import com.boxfarming.assignmentcriticalog.db.LocationDetails;
import com.google.android.gms.location.LocationResult;

public class MyLocationService extends BroadcastReceiver {

    private static final String TAG = "MyLocationService";
    public static final String ACTION_PROCESS_UPDATE = "com.boxfarming.assignmentcriticalog.UPDATE_LOCATION";

    @Override
    public void onReceive(Context context, Intent intent) {
        if(intent != null){
            final String action = intent.getAction();

            if(ACTION_PROCESS_UPDATE.equals(action)){
                LocationResult result = LocationResult.extractResult(intent);

                if(result!=null){
                    Location location = result.getLastLocation();
                    String locstring = "" + location.getLatitude() + " , " + location.getLongitude();
                    Log.d(TAG, "onReceive: "+locstring);
                    try{
                        new Thread(new Runnable() {
                            @Override
                            public void run() {
                                DatabaseClient.getInstance(context)
                                        .getAppDatabase()
                                        .getLocationDao()
                                        .insertLocationDetails(new LocationDetails(String.valueOf(location.getLongitude()),String.valueOf(location.getLatitude())));
                            }
                        }).start();
                        MainActivity.getInstance().updateTextView(locstring);
                    }
                    catch (Exception e){
                        Toast.makeText(context, locstring, Toast.LENGTH_SHORT).show();
                    }
                }
            }
        }
    }
}
