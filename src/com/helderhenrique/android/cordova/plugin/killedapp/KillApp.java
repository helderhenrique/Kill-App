package com.helderhenrique.android.cordova.plugin.killedapp;

import android.app.Activity;
import android.content.Intent;
import android.util.Log;

import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.CallbackContext;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * This class echoes a string called from JavaScript.
 */
public class KillApp extends CordovaPlugin {

    @Override
    public boolean execute(String action, final JSONArray args, CallbackContext callbackContext) throws JSONException {
        cordova.getThreadPool().execute(new Runnable() {
            public void run() {
                checkAppKilled(args);
            }
        });
        return true;
    }

    private void checkAppKilled(JSONArray uuid) {
        Activity context = cordova.getActivity();
        Intent intent = new Intent(context, com.helderhenrique.android.cordova.plugin.killedapp.CheckAppKilledService.class);
        try {
            intent.putExtra("UUID", uuid.getString(0));
        }catch (JSONException ex){
//            Log.d(ex.getMessage());
        }

        context.startService(intent);
    }
}