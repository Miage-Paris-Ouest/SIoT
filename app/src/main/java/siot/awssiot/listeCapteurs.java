package siot.awssiot;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.view.animation.BounceInterpolator;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RadioGroup;
import android.widget.Switch;
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

    private Switch switchLumiere;
    private Switch switchTemp;
    private Switch switchAir;
    private Switch switchHumidity;
    private Switch switchMVT;
    private Switch switchSon;

    Boolean lum = null;
    Boolean tmp = null;
    Boolean air = null;
    Boolean hum = null;
    Boolean mvt = null;
    Boolean son = null;


    String seuilLux;
    String seuilTmp;
    String seuilAir;
    String seuilHum;
    String seuilMvt;
    String seuilSon;

    SharedPreferences sharedPref2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_liste_capteurs);

        sharedPref2 = this.getPreferences(Context.MODE_PRIVATE);

        switchLumiere = (Switch) findViewById(R.id.switchLumiere);
        switchTemp = (Switch) findViewById(R.id.switchLumiere);
        switchAir = (Switch) findViewById(R.id.switchLumiere);
        switchHumidity = (Switch) findViewById(R.id.switchLumiere);
        switchMVT = (Switch) findViewById(R.id.switchMVT);
        switchSon = (Switch) findViewById(R.id.switchSon);

        Boolean sLum = sharedPref2.getBoolean("putBoolean", true);



        if (sLum) {switchLumiere.setChecked(sLum);}

        saveAlarmeCapteur = (Button) findViewById(R.id.alarmButton);
        seuil_lux = (EditText) findViewById(R.id.seuil_lux);
        list_seuil = (ListView) findViewById(R.id.listview_seuil);
        final List<Capteurs> messeuilsdecapteurs = Capteurs.listAll(Capteurs.class);

        adapter = new ArrayAdapter<Capteurs>(listeCapteurs.this, android.R.layout.simple_list_item_1, messeuilsdecapteurs);
        list_seuil.setAdapter(adapter);

        Toast.makeText(getApplicationContext(),"ma liste de seuil: " +list_seuil, Toast.LENGTH_LONG).show();

        seuilLux = sharedPref2.getString("seuilLux", "");
        System.out.println("AAAAA1 : " + seuilLux);
        seuil_lux.setText(seuilLux);
        System.out.println("AAAAA2 : " + seuilLux);

        saveAlarmeCapteur.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "Envoi des paramètres personnalisés à AWS", Toast.LENGTH_LONG).show();
                capteurs = new Capteurs(seuil_lux.getText().toString());
                capteurs.save();
                Toast.makeText(getApplicationContext(), "Enregistrement des seuils" + messeuilsdecapteurs, Toast.LENGTH_LONG).show();
                SharedPreferences.Editor editor = sharedPref2.edit();
                seuilLux = seuil_lux.getText().toString();
                System.out.println("AAAAA3 : " + seuilLux);

                editor.putString("seuilLux", seuilLux);
                editor.apply();
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






        switchLumiere.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                if(switchLumiere.isChecked()){
                    switchLumOn();
                }

                else {
                    switchLumOff();
                }

            }
        });


        switchAir.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                if(switchAir.isChecked()){
                    switchAirOn();
                }

                else {
                    switchAirOff();
                }

            }
        });


        switchTemp.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                if(switchTemp.isChecked()){
                    switchTmpOn();
                }

                else {
                    switchTmpOff();
                }

            }
        });


        switchHumidity.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                if(switchHumidity.isChecked()){
                    switchHumOn();
                }

                else {
                    switchHumOff();
                }

            }
        });


        switchMVT.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                if(switchMVT.isChecked()){
                    switchMvtOn();
                }

                else {
                    switchMvtOff();
                }

            }
        });


        switchSon.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                if(switchSon.isChecked()){
                    switchSonOn();
                }

                else {
                    switchSonOff();
                }

            }
        });







    }

    public void switchLumOn(){
        lum = true;
        SharedPreferences.Editor editor2 = sharedPref2.edit();
        editor2.putBoolean("putBoolean", true);
        editor2.apply();
    }


    public void switchLumOff(){
        lum = false;
        SharedPreferences.Editor editor2 = sharedPref2.edit();
        editor2.putBoolean("putBoolean", false);
        editor2.apply();
    }




    public void switchTmpOn(){
        tmp = true;
        SharedPreferences.Editor editor2 = sharedPref2.edit();
        editor2.putBoolean("putBoolean", true);
        editor2.apply();
    }


    public void switchTmpOff(){
        tmp = false;
        SharedPreferences.Editor editor2 = sharedPref2.edit();
        editor2.putBoolean("putBoolean", false);
        editor2.apply();
    }


    public void switchAirOn(){
        air = true;
        SharedPreferences.Editor editor2 = sharedPref2.edit();
        editor2.putBoolean("putBoolean", true);
        editor2.apply();
    }


    public void switchAirOff(){
        air = false;
        SharedPreferences.Editor editor2 = sharedPref2.edit();
        editor2.putBoolean("putBoolean", false);
        editor2.apply();
    }


    public void switchHumOn(){
        hum = true;
        SharedPreferences.Editor editor2 = sharedPref2.edit();
        editor2.putBoolean("putBoolean", true);
        editor2.apply();
    }


    public void switchHumOff(){
        hum = false;
        SharedPreferences.Editor editor2 = sharedPref2.edit();
        editor2.putBoolean("putBoolean", false);
        editor2.apply();
    }


    public void switchMvtOn(){
        mvt = true;
        SharedPreferences.Editor editor2 = sharedPref2.edit();
        editor2.putBoolean("putBoolean", true);
        editor2.apply();
    }


    public void switchMvtOff(){
        mvt = false;
        SharedPreferences.Editor editor2 = sharedPref2.edit();
        editor2.putBoolean("putBoolean", false);
        editor2.apply();
    }


    public void switchSonOn(){
        son = true;
        SharedPreferences.Editor editor2 = sharedPref2.edit();
        editor2.putBoolean("putBoolean", true);
        editor2.apply();
    }


    public void switchSonOff(){
        son = false;
        SharedPreferences.Editor editor2 = sharedPref2.edit();
        editor2.putBoolean("putBoolean", false);
        editor2.apply();
    }



    public void onBackPressed() {
        Intent intent = new Intent(listeCapteurs.this, Bienvenue.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
        return;
    }
    }
