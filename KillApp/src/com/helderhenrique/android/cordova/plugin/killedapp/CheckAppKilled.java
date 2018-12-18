package com.helderhenrique.android.cordova.killedapp;


public class CheckAppKilled extends Service {

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