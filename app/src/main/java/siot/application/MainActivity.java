package siot.application;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final Button suivant = (Button) findViewById(R.id.suivant);

        suivant.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ChoixCapteurs.class);
                startActivity(intent);

            }
        });
       // System.out.println("MainActivity.onCreate:" + FirebaseInstanceId.getInstance().getToken());
    }
}
