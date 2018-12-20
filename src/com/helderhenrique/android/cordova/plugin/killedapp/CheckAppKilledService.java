package com.helderhenrique.android.cordova.plugin.killedapp;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

public class CheckAppKilledService extends Service {

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
            String uuid = (String) extras.get("UUID");
            Log.d("UUID is "+uuid);
        }
    }

    @Override
    public void onCreate() {
        Log.d("on create called", "on create");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d("on destroy called", "gps state on destroy called first");
    }
}