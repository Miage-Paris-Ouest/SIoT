package siot.awssiot;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.app.Service;

/**
 * Created by Pascal on 28/12/2016.
 */

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.media.RingtoneManager;
import android.net.Uri;
import android.support.v4.app.NotificationCompat;
import android.util.Log;

import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.StringTokenizer;

public class MyFirebaseMessagingService extends FirebaseMessagingService {

    private static final String TAG = "MyFirebaseMsgService";

    /**
     * Called when message is received.
     *
     * @param remoteMessage Object representing the message received from Firebase Cloud Messaging.
     */
    // [START receive_message]
    String seuilLux = "";
    String seuilTmp = "";
    String seuilAir = "";
    String seuilHum = "";
    String seuilMvt = "";
    String seuilSon = "";
    @Override
    public void onMessageReceived(RemoteMessage remoteMessage) {
        // [START_EXCLUDE]
        // There are two types of messages data messages and notification messages. Data messages are handled
        // here in onMessageReceived whether the app is in the foreground or background. Data messages are the type
        // traditionally used with GCM. Notification messages are only received here in onMessageReceived when the app
        // is in the foreground. When the app is in the background an automatically generated notification is displayed.
        // When the user taps on the notification they are returned to the app. Messages containing both notification
        // and data payloads are treated as notification messages. The Firebase console always sends notification
        // messages. For more see: https://firebase.google.com/docs/cloud-messaging/concept-options
        // [END_EXCLUDE]

        // TODO(developer): Handle FCM messages here.
        // Not getting messages here? See why this may be: https://goo.gl/39bRNJ
        Log.d(TAG, "From: " + remoteMessage.getFrom());

        // Check if message contains a data payload.
        if (remoteMessage.getData().size() > 0) {
            Log.d(TAG, "Message data payload: " +  remoteMessage.getData());

            String titreNotification = remoteMessage.getData().toString().replace("\"pluie\"", "Pluie ").replace("BoitierDeconnecte", "Boîtier Déconnecté").replace("null", " ").replace("\"AlarmDescription\"", " ").replace("\"AlarmName\"", "État").replace("\"EtatConnexion:Success\"", "Boîtier connecté").replace("\"son\"", "Sonorité").replace("\"mvt\":1", "On Mouvement").replace("\"mvt\":0", "Pas de mouvement").replace("\"hum\"", "Humidité").replace("\"lux\"", "Luminosité % ").replace("{default=", "").replace("\"temp\"", "Température").replace("{", "").replace("\"air\"", "Air").replace("}", "").trim();

            try {
                JSONObject obj = new JSONObject(titreNotification);
                String temp = obj.getString("temp");
                System.out.println("AAAA1 : " + temp);

                sendNotification(titreNotification);

            } catch (JSONException e) {
                e.printStackTrace();
            }



            String titre = remoteMessage.getData().toString().replace("{default=", "").trim();
            try {
                final SharedPreferences mSharedPreference= PreferenceManager.getDefaultSharedPreferences(getBaseContext());

                seuilLux = mSharedPreference.getString("seuilLux", "");
                seuilTmp = mSharedPreference.getString("seuilTmp", "");
                seuilAir = mSharedPreference.getString("seuilAir", "");
                seuilSon = mSharedPreference.getString("seuilSon", "");
                seuilMvt = mSharedPreference.getString("seuilMvt", "");
                seuilHum = mSharedPreference.getString("seuilHum", "");

                JSONObject obj = new JSONObject(titre);


                String temp = obj.getString("temp");

                int mesureTemperature = Integer.parseInt(temp);
                int seuilTemperature = Integer.parseInt(seuilTmp);


                if (mesureTemperature > seuilTemperature ) {

                    sendNotification(titreNotification);
                    Intent intent = new Intent(this,Dashboard.class);
                    intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    intent.putExtra("titre", titre);
                    startActivity(intent);

                }



                String lux = obj.getString("lux");

                int mesureLux = Integer.parseInt(lux);
                int seuilLuxe = Integer.parseInt(seuilLux);


                if (mesureLux > seuilLuxe ) {

                    sendNotification(titreNotification);
                    Intent intent = new Intent(this,Dashboard.class);
                    intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    intent.putExtra("titre", titre);
                    startActivity(intent);

                }



                String mvt = obj.getString("mvt");


                int mesureMvt = Integer.parseInt(mvt);
                int seuilMvts = Integer.parseInt(seuilMvt);


                if (mesureMvt > seuilMvts ) {

                    sendNotification(titreNotification);
                    Intent intent = new Intent(this,Dashboard.class);
                    intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    intent.putExtra("titre", titre);
                    startActivity(intent);

                }



                String son = obj.getString("son");


                int mesureSon = Integer.parseInt(son);
                int seuilSons = Integer.parseInt(seuilSon);


                if (mesureSon > seuilSons ) {

                    sendNotification(titreNotification);
                    Intent intent = new Intent(this,Dashboard.class);
                    intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    intent.putExtra("titre", titre);
                    startActivity(intent);

                }



                String air = obj.getString("air");


                int mesureQair = Integer.parseInt(air);
                int seuilQair= Integer.parseInt(seuilAir);


                if (mesureQair > seuilQair ) {

                    sendNotification(titreNotification);
                    Intent intent = new Intent(this,Dashboard.class);
                    intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    intent.putExtra("titre", titre);
                    startActivity(intent);

                }



                String hum = obj.getString("hum");

                int mesureNhum = Integer.parseInt(hum);
                int seuilNhum = Integer.parseInt(seuilHum);


                if (mesureNhum > seuilNhum ) {

                    sendNotification(titreNotification);
                    Intent intent = new Intent(this,Dashboard.class);
                    intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    intent.putExtra("titre", titre);
                    startActivity(intent);

                }





            } catch (JSONException e) {
                e.printStackTrace();
            }


        }

        // Check if message contains a notification payload.
        if (remoteMessage.getNotification() != null) {
            Log.d(TAG, "Message Notification Body: " + remoteMessage.getNotification().getBody());

        }

        // Also if you intend on generating your own notifications as a result of a received FCM
        // message, here is where that should be initiated. See sendNotification method below.
    }
    // [END receive_message]

    /**
     * Create and show a simple notification containing the received FCM message.
     *
     * @param messageBody FCM message body received.
     */
    private void sendNotification(String messageBody) {
        Intent intent = new Intent();
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0 /* Request code */, intent,
                PendingIntent.FLAG_ONE_SHOT);

        Uri defaultSoundUri= RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
        NotificationCompat.Builder notificationBuilder = new NotificationCompat.Builder(this)
                .setSmallIcon(R.drawable.ic_menu_camera)
                .setContentTitle("Safety Internet of Things")
                .setContentText(messageBody)
                .setAutoCancel(true)
                .setSound(defaultSoundUri)
                .setContentIntent(pendingIntent);

        NotificationManager notificationManager =
                (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);

        notificationManager.notify(0 /* ID of notification */, notificationBuilder.build());
    }
}