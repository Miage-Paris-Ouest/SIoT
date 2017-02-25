package siot.awssiot;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //final Button suivant = (Button) findViewById(R.id.boutonCapteur);


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


/*
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

        */


       /* Button home = (Button) findViewById(R.id.boutonHome);
        home.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ScrollingActivity.class);
                startActivity(intent);

            }
        });
        */
        ImageView next_bienvenu = (ImageView) findViewById(R.id.next_bienvenu);
        next_bienvenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Bienvenue.class);
                startActivity(intent);

            }
        });

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