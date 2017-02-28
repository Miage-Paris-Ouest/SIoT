package siot.awssiot;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import org.json.JSONObject;


public class Dashboard extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        final ProgressBar myprogressBar_lux;
        final ProgressBar myprogressBar_mvt;
        final ProgressBar myprogressBar_son;
        final ProgressBar myprogressBar_temp;
        final ProgressBar myprogressBar_air;
        final ProgressBar myprogressBar_hum;
        final ProgressBar myprogressBar_pluie;

        final TextView progressingTextView;
        final TextView progress_circle_temp;
        final TextView progress_circle_lux;
        final TextView progress_circle_mvt;
        final TextView progress_circle_son;
        final TextView progress_circle_hum;
        final TextView progress_circle_air;
        final TextView progress_circle_pluie;

        //final Handler progressHandler = new Handler();
        myprogressBar_lux = (ProgressBar) findViewById(R.id.progressBar_lux);
        myprogressBar_mvt = (ProgressBar) findViewById(R.id.progressBar_mvt);
        myprogressBar_son = (ProgressBar) findViewById(R.id.progressBar_son);
        myprogressBar_temp = (ProgressBar) findViewById(R.id.progressBar_temp);
        myprogressBar_air = (ProgressBar) findViewById(R.id.progressBar_air);
        myprogressBar_hum = (ProgressBar) findViewById(R.id.progressBar_hum);
        //myprogressBar_pluie = (ProgressBar) findViewById(R.id.progressBar_pluie);







        //redirection vers reglages de capteurs

        myprogressBar_lux.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(Dashboard.this, ConfigLux.class);
                startActivity(intent);
            }
        });

       myprogressBar_mvt.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(Dashboard.this, ConfigMvt.class);
                startActivity(intent);
            }
        });

        myprogressBar_son.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(Dashboard.this, ConfigSon.class);
                startActivity(intent);
            }
        });

        myprogressBar_temp.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(Dashboard.this, ConfigTemp.class);
                startActivity(intent);
            }
        });

        myprogressBar_air.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(Dashboard.this, ConfigAir.class);
                startActivity(intent);
            }
        });

        myprogressBar_hum.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(Dashboard.this, ConfigHum.class);
                startActivity(intent);
            }
        });


        progress_circle_temp = (TextView) findViewById(R.id.progress_circle_temp);
        progress_circle_lux = (TextView) findViewById(R.id.progress_circle_lux);
        progress_circle_mvt = (TextView) findViewById(R.id.progress_circle_mvt);
        progress_circle_son = (TextView) findViewById(R.id.progress_circle_son);
        progress_circle_air = (TextView) findViewById(R.id.progress_circle_air);
        progress_circle_hum = (TextView) findViewById(R.id.progress_circle_hum);
        progress_circle_pluie = (TextView) findViewById(R.id.progress_circle_pluie);

        MyNotificationsReceiver mnr = new MyNotificationsReceiver();
        mnr.onReceive(getApplicationContext(), getIntent());

        Intent intent = getIntent();
        String titre = intent.getStringExtra("titre");


        SharedPreferences sharedPref = this.getPreferences(Context.MODE_PRIVATE);



        String luxSaved = null;
        String luxRecup = sharedPref.getString("lux", "");


        progress_circle_lux.setText(luxRecup);


        try {
            JSONObject obj = new JSONObject(titre);
            Log.d("My App", obj.toString());


            String lux = obj.getString("lux");
            progress_circle_lux.setText(lux);


            luxSaved = lux;

            SharedPreferences.Editor editor = sharedPref.edit();
            editor.putString("lux", luxSaved);
            editor.apply();

            String temp = obj.getString("temp");// Double temp1=  Double.parseDouble(temp);
            progress_circle_temp.setText(temp);



            String mvt = obj.getString("mvt");
            progress_circle_mvt.setText(mvt);

            String son = obj.getString("son");
            progress_circle_son.setText(son);

            String air = obj.getString("air");
            progress_circle_air.setText(air);

            String hum = obj.getString("hum");
            progress_circle_hum.setText(hum);

            String pluie = obj.getString("pluie");
            progress_circle_pluie.setText(pluie);




        } catch (Throwable t) {
            Log.e("My App", "Could not parse malformed JSON: \"" + titre + "\"");
        }


       /* ImageView next_listecap = (ImageView) findViewById(R.id.next_listecapteurs);
        next_listecap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Dashboard.this, listeCapteurs.class);
                startActivity(intent);

            }
        });

        ImageView back_versbienvienue = (ImageView) findViewById(R.id.back_vBienvenue);
        back_versbienvienue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Dashboard.this, Bienvenue.class);
                startActivity(intent);

            }
        });
        */
    }

    public void onBackPressed() {
        Intent intent = new Intent(Dashboard.this, Bienvenue.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);

        startActivity(intent);

        return;
    }

}