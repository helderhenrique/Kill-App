package com.helderhenrique.android.cordova.plugin.killedapp;

import android.app.Service;
import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import android.util.Log;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class CheckAppKilledService extends Service {
    public String uuid = null;

    @Override
    public IBinder onBind(Intent in) {
        return null;
    }

    @Override
    public void onStart(Intent intent, int startId) {
        super.onStart(intent, startId);
        if (intent != null) {
            Bundle extras = intent.getExtras();
            if (extras == null) {
                Log.d("Service", "null");
            } else {
                Log.d("Service", "not null");
                String uuid_ = (String) extras.get("UUID");
                Log.d("Service", "UUID is " + uuid_);
                uuid = uuid_;
            }
        }
    }

    @Override
    public void onCreate() {
        Log.d("on create called", "on create");
    }


    @Override
    public boolean stopService(Intent intent) {
        Log.d("KillApp", "- Received stop: " + intent);
        return super.stopService(intent);
    }

    @Override
    public void onDestroy() {
        Log.d("KillApp", "------------------------------------------ Destroyed KillApp Service");
        stopForeground(true);
        super.onDestroy();
    }

    @Override
    public void onTaskRemoved(Intent rootIntent) {
        Log.d("ClearFromRecentService", "onTaskRemoved called");
        updateStatus();
        try {
            Thread.sleep(3000);
        }catch (Exception e){
            Log.e("KillApp", e.getMessage());
        }finally {
            this.stopSelf();
            super.onTaskRemoved(rootIntent);
        }
    }

    public void updateStatus(){
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("geolocations/" + uuid).child("status");
        myRef.setValue("app_killed");
    }
}
