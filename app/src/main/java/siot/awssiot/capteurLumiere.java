package siot.awssiot;

import android.content.Intent;
import android.content.IntentFilter;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class capteurLumiere extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_capteur_lumiere);

        MyNotificationsReceiver mnr = new MyNotificationsReceiver();
        mnr.onReceive(getApplicationContext(),getIntent());

        Intent intent = getIntent();
        String titre = intent.getStringExtra("titre");

        System.out.println("titre recup " + titre);
        TextView textView = (TextView)findViewById(R.id.lumiere);
        textView.setText(titre);


    }


}
