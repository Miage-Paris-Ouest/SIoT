package siot.awssiot;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.provider.Settings;
import android.view.View;
import android.widget.TextView;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.widget.ProgressBar;

import java.util.Scanner;


public class Dashboard extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        final ProgressBar myprogressBar;
        // final TextView progressingTextView;
        final TextView progress_circle_temp;
        //final TextView progress_circle_lux;
        //final Handler progressHandler = new Handler();


        myprogressBar = (ProgressBar) findViewById(R.id.progressBar);
        progress_circle_temp = (TextView) findViewById(R.id.progress_circle_text3);
        // progress_circle_lux = (TextView) findViewById(R.id.progress_circle_text1);

        MyNotificationsReceiver mnr = new MyNotificationsReceiver();
        mnr.onReceive(getApplicationContext(), getIntent());

        Intent intent = getIntent();
        String titre = intent.getStringExtra("titre");


        progress_circle_temp.setText(titre);

    }
    }