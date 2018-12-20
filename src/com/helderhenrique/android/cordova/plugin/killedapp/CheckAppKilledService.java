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
    public void onCreate() {
        Log.d("on create called", "on create");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d("on destroy called", "gps state on destroy called first");
    }
}