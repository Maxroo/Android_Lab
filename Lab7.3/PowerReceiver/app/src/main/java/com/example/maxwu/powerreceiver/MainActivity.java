package com.example.maxwu.powerreceiver;

import android.content.Intent;
import android.content.IntentFilter;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    private static final String ACTION_CUSTOM_BROADCAST = BuildConfig.APPLICATION_ID + "Action";
    private CustomReceiver mReceiver = new CustomReceiver();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        IntentFilter filter = new IntentFilter();
        filter.addAction(Intent.ACTION_POWER_CONNECTED);
        filter.addAction(Intent.ACTION_POWER_DISCONNECTED);

        this.registerReceiver(mReceiver,filter);
        LocalBroadcastManager.getInstance(this).registerReceiver(mReceiver,new IntentFilter(Intent.ACTION_HEADSET_PLUG));
        LocalBroadcastManager.getInstance(this).registerReceiver(mReceiver,new IntentFilter(ACTION_CUSTOM_BROADCAST));
    }

    public void sendCustomBoardcast(View view) {
        Intent customBroadcastIntent = new Intent(ACTION_CUSTOM_BROADCAST);
        // "global" sendBroadcast();
        LocalBroadcastManager.getInstance(this).sendBroadcast(customBroadcastIntent);
    }

    @Override
    protected void onDestroy() {
        LocalBroadcastManager.getInstance(this).unregisterReceiver(mReceiver);
        this.unregisterReceiver(mReceiver);
        super.onDestroy();
    }
}
