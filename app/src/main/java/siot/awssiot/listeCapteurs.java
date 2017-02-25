package siot.awssiot;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class listeCapteurs extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_liste_capteurs);


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
    }
}