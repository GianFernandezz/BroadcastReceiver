package com.example.broadcastreceiver;

import androidx.appcompat.app.AppCompatActivity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView tvBroadCast;
    private IntentFilter chargingIntentFilter;
    private CharginBroadCastReceiver chargingBroadCastReceiver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }

    private void init(){
        tvBroadCast = (TextView) findViewById(R.id.tvBroadCast);
        chargingIntentFilter = new IntentFilter();
        chargingIntentFilter.addAction(Intent.ACTION_POWER_DISCONNECTED);
        chargingIntentFilter.addAction(Intent.ACTION_POWER_CONNECTED);
        chargingBroadCastReceiver = new CharginBroadCastReceiver();

    }
    public class CharginBroadCastReceiver extends BroadcastReceiver {
        @Override
        public void onReceive(Context context, Intent intent){
            String action = intent.getAction();
            boolean isChagin = (action.equals(Intent.ACTION_POWER_CONNECTED));
            showCharging(isChagin);
        }
    }

    private void showCharging(boolean isCharging){
        if(isCharging){
            tvBroadCast.setText("Conectado");
            tvBroadCast.setTextColor(Color.parseColor("#0000FF"));
        }
        else{
            tvBroadCast.setText("Desconectado");
            tvBroadCast.setTextColor(Color.parseColor("#FF0000"));
        }
    }

    @Override
    protected void onResume(){
        super.onResume();
        registerReceiver(chargingBroadCastReceiver,chargingIntentFilter);
    }
    @Override
    protected void onPause(){
        super.onPause();
        unregisterReceiver(chargingBroadCastReceiver);
    }
}