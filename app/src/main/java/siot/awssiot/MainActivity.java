package siot.awssiot;

import android.content.Intent;
import android.os.Bundle;
import android.provider.Settings;
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


import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.messaging.FirebaseMessaging;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.messaging.FirebaseMessaging;
import com.google.firebase.messaging.RemoteMessage;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final Button suivant = (Button) findViewById(R.id.boutonCapteur);
        final Button send = (Button) this.findViewById(R.id.logTokenButton);

        // If a notification message is tapped, any data accompanying the notification
        // message is available in the intent extras. In this sample the launcher
        // intent is fired when the notification is tapped, so any accompanying data would
        // be handled here. If you want a different intent fired, set the click_action
        // field of the notification message to the desired intent. The launcher intent
        // is used when no click_action is specified.
        //
        // Handle possible data accompanying notification message.
        // [START handle_data_extras]
        if (getIntent().getExtras() != null) {
            for (String key : getIntent().getExtras().keySet()) {
                Object value = getIntent().getExtras().get(key);
                Log.d(TAG, "Key: " + key + " Value: " + value);
                String token = FirebaseInstanceId.getInstance().getToken();

        }
        }
        // [END handle_data_extras]


        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                new Thread(new Runnable() {

                    public void run() {


                String user = "safetyinternetofthings@gmail.com";
                String password = "siot2016";
                String token = FirebaseInstanceId.getInstance().getToken();
                GMailSender sender = new GMailSender(user, password);
                try {
                    sender.sendMail("Token", token, "safetyinternetofthings@gmail.com", "safetyinternetofthings@gmail.com");
                } catch (Exception e) {
                    e.printStackTrace();
                }


            }

                }).start();

            }

        });

      /*  Button logTokenButton = (Button) findViewById(R.id.logTokenButton);
        logTokenButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // Get token
                String token = FirebaseInstanceId.getInstance().getToken();
                Intent intent = new Intent(Intent.ACTION_SENDTO);
                intent.setType("text/plain");
                intent.putExtra(Intent.EXTRA_EMAIL, "khedidjaelmrabet@gmail.com");
                intent.putExtra(Intent.EXTRA_SUBJECT, "Token");
                intent.putExtra(Intent.EXTRA_TEXT, token );
                startActivity(Intent.createChooser(intent, "Send Email"));

                // Log and toast
                /*String msg = getString(R.string.msg_token_fmt, token);
                Log.d(TAG, msg);
                Toast.makeText(MainActivity.this, msg, Toast.LENGTH_SHORT).show();
                envoiTokenMail(token);*/

            //}
       // });*/



        suivant.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, listeCapteurs.class);
                startActivity(intent);

            }
        });

        Button dashboardButton = (Button) findViewById(R.id.boutonDashboard);
        dashboardButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Dashboard.class);
                startActivity(intent);
            }
        });


       /* Button home = (Button) findViewById(R.id.boutonHome);
        home.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ScrollingActivity.class);
                startActivity(intent);

            }
        });
        */


    }


    public void envoiTokenMail(String token)
    {


        Intent email = new Intent(Intent.ACTION_SEND);
        email.putExtra(Intent.EXTRA_EMAIL, new String[]{"pascal.orsini@outlook.com"});
        email.putExtra(Intent.EXTRA_SUBJECT, "Votre token");
        email.putExtra(Intent.EXTRA_TEXT, "Votre token est : \n " + token);
        email.setType("message/rfc822");

        startActivity(Intent.createChooser(email, "Choisissez un client  de messagerie:"));

    }

}