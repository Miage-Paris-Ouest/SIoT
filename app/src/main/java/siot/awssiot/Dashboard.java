package siot.awssiot;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import android.support.v7.app.AppCompatActivity;
import android.widget.ProgressBar;

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

        final TextView progressingTextView;
        final TextView progress_circle_temp;
        final TextView progress_circle_lux;
        final TextView progress_circle_mvt;
        final TextView progress_circle_son;
        //final Handler progressHandler = new Handler();


      //  myprogressBar_lux = (ProgressBar) findViewById(R.id.progressBar_lux);
       // final Button button_lux = (Button) findViewById(R.id.button_lux);

        myprogressBar_mvt = (ProgressBar) findViewById(R.id.progressBar_mvt);
        myprogressBar_son = (ProgressBar) findViewById(R.id.progressBar_son);
        myprogressBar_temp = (ProgressBar) findViewById(R.id.progressBar_temp);

        //redirection vers reglages de capteurs
        /*
        button_lux.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(Dashboard.this, ConfigLux.class);
                startActivity(intent);
            }
        });

        */

      /*  myprogressBar_mvt.setOnClickListener(new View.OnClickListener() {
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
*/

        progress_circle_temp = (TextView) findViewById(R.id.progress_circle_temp);
        progress_circle_lux = (TextView) findViewById(R.id.progress_circle_lux);
        progress_circle_mvt = (TextView) findViewById(R.id.progress_circle_mvt);
        progress_circle_son = (TextView) findViewById(R.id.progress_circle_son);

        MyNotificationsReceiver mnr = new MyNotificationsReceiver();
        mnr.onReceive(getApplicationContext(), getIntent());

        Intent intent = getIntent();
        String titre = intent.getStringExtra("titre");
        titre = titre + "}";

        try {
            JSONObject obj = new JSONObject(titre);
            Log.d("My App", obj.toString());

            String temp = obj.getString("temp");// Double temp1=  Double.parseDouble(temp);
            String lux = obj.getString("lux");
            String mvt = obj.getString("mvt");
            String son = obj.getString("son");

            progress_circle_temp.setText(temp);
            progress_circle_lux.setText(lux);
            progress_circle_mvt.setText(mvt);
            progress_circle_son.setText(son);

        } catch (Throwable t) {
            Log.e("My App", "Could not parse malformed JSON: \"" + titre + "\"");
        }
    }
    }