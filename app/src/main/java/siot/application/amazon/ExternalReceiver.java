package siot.application.amazon;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import siot.application.AndroidMobilePushApp;

public class ExternalReceiver extends BroadcastReceiver {

    public void onReceive(Context context, Intent intent) {
        if(intent!=null){
            Bundle extras = intent.getExtras();
            if(!AndroidMobilePushApp.inBackground){
                MessageReceivingService.sendToApp(extras, context);
            }
            else{
                MessageReceivingService.saveToLog(extras, context);
            }
        }
    }
}

