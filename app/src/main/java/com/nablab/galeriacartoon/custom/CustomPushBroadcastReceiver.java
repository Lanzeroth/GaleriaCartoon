package com.nablab.galeriacartoon.custom;


import android.content.Context;
import android.content.Intent;
import android.util.Log;

import com.nablab.galeriacartoon.MainActivity;
import com.parse.ParseAnalytics;
import com.parse.ParsePushBroadcastReceiver;

/**
 * This custom receiver will fire when opening a notification
 */
public class CustomPushBroadcastReceiver extends ParsePushBroadcastReceiver {
    @Override
    protected void onPushOpen(Context context, Intent intent) {
        Log.i("Push", "Clicked");
        ParseAnalytics.trackAppOpenedInBackground(intent);

        Intent i = new Intent(context, MainActivity.class);
        i.putExtras(intent.getExtras());
        i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(i);
    }
}
