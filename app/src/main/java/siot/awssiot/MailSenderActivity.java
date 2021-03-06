package siot.awssiot;

import android.app.Activity;


import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import siot.awssiot.GMailSender;
import siot.awssiot.R;

public class MailSenderActivity extends Activity {

    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Button send = (Button) this.findViewById(R.id.logTokenButton);
        send.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                // TODO Auto-generated method stub

                try {
                    GMailSender sender = new GMailSender("safetyinternetofthings@gmail.com", "siot2016");
                    sender.sendMail("This is Subject",
                            "This is Body",
                            "user@gmail.com",
                            "user@yahoo.com");
                } catch (Exception e) {
                    Log.e("SendMail", e.getMessage(), e);
                }

            }
        });

    }
}