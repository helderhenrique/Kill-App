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
    public IBinder onBind(Intent in){
        return null;
    }

    @Override
    public void onStart(Intent intent, int startId){
        super.onStart(intent, startId);
        Bundle extras = intent.getExtras();
         if(extras == null) {
            Log.d("Service","null");
        } else {
            Log.d("Service","not null");
            String uuid_ = (String) extras.get("UUID");
            Log.d("Service", "UUID is "+uuid_);
            uuid = uuid_;

        }
    }

    @Override
    public void onCreate() {
        Log.d("on create called", "on create");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d("on destroy called", "on destroy");
    }

    @Override
    public void onTaskRemoved(Intent rootIntent) {
        Log.e("ClearFromRecentService", "END");
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("geolocations/" + uuid).child("status");
        myRef.setValue("app_killed");
    }
}