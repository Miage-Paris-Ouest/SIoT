package siot.awssiot;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.firebase.iid.FirebaseInstanceId;

public class Bienvenue extends AppCompatActivity {
    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bienvenue);

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
                Toast.makeText(getApplicationContext(), "Token envoyé!", Toast.LENGTH_LONG).show();

                send.setClickable(false);
                send.setBackgroundColor(0);

            }

        });


        ImageView next_dash = (ImageView) findViewById(R.id.next_dashboard);
        next_dash.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Bienvenue.this, Dashboard.class);
                startActivity(intent);

            }
        });

        final Button suivant = (Button) findViewById(R.id.boutonCapteur);

        suivant.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(Bienvenue.this, listeCapteurs.class);
                startActivity(intent);

            }
        });

        Button dashboardButton = (Button) findViewById(R.id.boutonDashboard);
        dashboardButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Bienvenue.this, Dashboard.class);
                startActivity(intent);
            }
        });

    }


}
