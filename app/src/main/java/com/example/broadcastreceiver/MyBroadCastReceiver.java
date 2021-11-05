package com.example.broadcastreceiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

public class MyBroadCastReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent){

        //String msgReceived = intent.getAction().toString();
       // Toast.makeText(context, msgReceived, Toast.LENGTH_SHORT).show();

        if (intent.getAction().equals(Intent.ACTION_POWER_CONNECTED)){
            Toast.makeText(context, context.getString(R.string.disconnected), Toast.LENGTH_SHORT).show();
        }
        else{
            Toast.makeText(context, context.getString(R.string.connected), Toast.LENGTH_SHORT).show();
        }
    }
}
