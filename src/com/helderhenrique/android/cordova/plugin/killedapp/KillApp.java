package com.helderhenrique.android.cordova.plugin.killedapp;

import android.app.Activity;
import android.content.Intent;

import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.CallbackContext;

import org.json.JSONArray;
import org.json.JSONException;

/**
 * This class echoes a string called from JavaScript.
 */
public class KillApp extends CordovaPlugin {

    @Override
    public boolean execute(String action, JSONArray args, CallbackContext callbackContext) throws JSONException {
        cordova.getThreadPool().execute(new Runnable() {
            public void run() {
                checkAppKilled();
            }
        });
        return true;
    }

    private void checkAppKilled() {
        Activity context = cordova.getActivity();
        context.startService(new Intent(context, com.helderhenrique.android.cordova.plugin.killedapp.CheckAppKilledService.class));
    }
}