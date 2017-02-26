package siot.awssiot;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.List;

public class listeCapteurs extends Activity {
    Button saveAlarmeCapteur;
    EditText seuil_lux;
    EditText seuil_temp;
    EditText seuil_hum;
    EditText seuil_son;
    EditText seuil_mvt;
    EditText seuil_air;

    ListView list_seuil;
    ArrayAdapter<Capteurs> adapter;
    Capteurs capteurs = new Capteurs();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_liste_capteurs);

        saveAlarmeCapteur = (Button) findViewById(R.id.alarmButton);
        seuil_lux = (EditText) findViewById(R.id.seuil_lux);
        list_seuil = (ListView) findViewById(R.id.listview_seuil);
        final List<Capteurs> messeuilsdecapteurs = Capteurs.listAll(Capteurs.class);

        adapter = new ArrayAdapter<Capteurs>(listeCapteurs.this, android.R.layout.simple_list_item_1, messeuilsdecapteurs);
        list_seuil.setAdapter(adapter);

        Toast.makeText(getApplicationContext(),"ma liste de seuil: " +list_seuil, Toast.LENGTH_LONG).show();

        saveAlarmeCapteur.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "Envoi des paramètres personnalisés à AWS", Toast.LENGTH_LONG).show();
                capteurs = new Capteurs(seuil_lux.getText().toString());
                capteurs.save();
                Toast.makeText(getApplicationContext(), "Enregistrement des seuils" + messeuilsdecapteurs, Toast.LENGTH_LONG).show();

            }

        });



      /*  List<Capteurs> mescapteurs = Capteurs.listAll(Capteurs.class);
        System.out.println("Mes capteurs au départ: " + mescapteurs);

        if(mescapteurs.isEmpty()){
            // ENREGISTREMENT DES CAPTEURS DANS LA BDD
            Capteurs capteur_lumiere = new Capteurs("on", 10, "Luminosite",12);
            Capteurs capteur_temperature = new Capteurs("on", 22, "Temperature", 28);
            Capteurs capteur_mouvement = new Capteurs("on", 0, "Mouvement", 1);
            Capteurs capteur_qualiteair = new Capteurs("on", 80, "Qualité Air", 50 );
            Capteurs capteur_humidite = new Capteurs("on", 35, "Humidite", 30);
            Capteurs capteur_son = new Capteurs("on", 255, "Son", 150);

            capteur_lumiere.save();
            capteur_humidite.save();
            capteur_mouvement.save();
            capteur_qualiteair.save();
            capteur_son.save();
            capteur_temperature.save();
            System.out.println("Mes capteurs après enregistrement SUGAR ORM dans SQLite: " +mescapteurs);
        }

        */

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