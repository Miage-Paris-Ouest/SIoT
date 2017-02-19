package siot.awssiot;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.provider.Settings;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.widget.ProgressBar;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.Scanner;


public class Dashboard extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        final ProgressBar myprogressBar;
        final TextView progressingTextView;
        final TextView progress_circle_temp;
        final TextView progress_circle_lux;
        final TextView progress_circle_mvt;
        final TextView progress_circle_son;
        //final Handler progressHandler = new Handler();


        myprogressBar = (ProgressBar) findViewById(R.id.progressBar);
        progress_circle_temp = (TextView) findViewById(R.id.progress_circle_text3);
        progress_circle_lux = (TextView) findViewById(R.id.progress_circle_text);
        progress_circle_mvt = (TextView) findViewById(R.id.progress_circle_text1);
        progress_circle_son = (TextView) findViewById(R.id.progress_circle_text4);

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