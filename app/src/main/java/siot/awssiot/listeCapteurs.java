package siot.awssiot;

import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.widget.TextView;

public class listeCapteurs extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_liste_capteurs);


        TextView fumee = (TextView)findViewById(R.id.mouvement);
        fumee.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(listeCapteurs.this, capteurMouvement.class);
                startActivity(intent);

            }
        });

        TextView lumiere = (TextView)findViewById(R.id.lumiere);
        lumiere.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(listeCapteurs.this, capteurLumiere.class);
                startActivity(intent);

            }
        });
    }
}