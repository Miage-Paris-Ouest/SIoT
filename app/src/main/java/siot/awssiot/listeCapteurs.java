package siot.awssiot;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class listeCapteurs extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_liste_capteurs);
        final Button saveAlarmeCapteur = (Button) findViewById(R.id.alarmButton);


        ImageView mvt = (ImageView) findViewById(R.id.mouvement);
        mvt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(listeCapteurs.this, capteurMouvement.class);
                startActivity(intent);

            }
        });

      /*  TextView lumiere = (TextView)findViewById(R.id.lumiere);
        lumiere.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(listeCapteurs.this, capteurLumiere.class);
                startActivity(intent);

            }
        });
        */
        saveAlarmeCapteur.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "Envoi des paramètres personnalisés à AWS", Toast.LENGTH_LONG).show();

                saveAlarmeCapteur.setClickable(false);
                saveAlarmeCapteur.setBackgroundColor(0);
            }

        });

        ImageView back_versdashboard = (ImageView) findViewById(R.id.back_vDash);
        back_versdashboard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(listeCapteurs.this, Dashboard.class);
                startActivity(intent);

            }
        });


    }
}