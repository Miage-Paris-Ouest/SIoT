package siot.awssiot;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.firebase.iid.FirebaseInstanceId;

public class Bienvenue extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    public boolean etatButtonToken = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bienvenue);

        final Button send = (Button) this.findViewById(R.id.logTokenButton);

        if (getIntent().getExtras() != null) {
            for (String key : getIntent().getExtras().keySet()) {
                Object value = getIntent().getExtras().get(key);
                Log.d(TAG, "Key: " + key + " Value: " + value);
                String token = FirebaseInstanceId.getInstance().getToken();

            }
        }

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

                send.setClickable(false);
                etatButtonToken = false;
                send.setBackgroundColor(0);
                Toast.makeText(getApplicationContext(), "Token envoyé!", Toast.LENGTH_LONG).show();


            }

        });

        // sauvegarde l'etat du bouton
       Context context = getApplicationContext();
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(context);
        prefs.edit().putBoolean("etatButtonToken", false);
        prefs.edit().apply();
        prefs.getBoolean("etatButtonToken", true);


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


        ImageView next_dash = (ImageView) findViewById(R.id.next_dashboard);
        next_dash.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Bienvenue.this, Dashboard.class);
                startActivity(intent);

            }
        });



    }


}
