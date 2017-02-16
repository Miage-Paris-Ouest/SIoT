package siot.awssiot;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.provider.Settings;
import android.util.Log;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by Pascal on 19/01/2017.
 */

public class MyNotificationsReceiver extends BroadcastReceiver {

    private static final String TAG = "MyNotificationsReceiver";

    @Override
    public void onReceive(Context context, Intent intent) {
        try {
            String titre = intent.getStringExtra("titre");
            System.out.println("pas notif : " + titre);

            if ( titre != null) {

                System.out.println("notif : " + titre);
            }
        } catch (Exception e) {
            Log.d(TAG, "JSONException: " + e.getMessage());
        }
    }
}