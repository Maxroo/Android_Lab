package com.example.maxwu.powerreceiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class CustomReceiver extends BroadcastReceiver {
    private static final String ACTION_CUSTOM_BROADCAST = BuildConfig.APPLICATION_ID + "Action";

    @Override
    public void onReceive(Context context, Intent intent) {
        String intentAction = intent.getAction();
        String message = "unkown";
        if (intentAction != null)
        {
            switch (intentAction)
            {
                case Intent.ACTION_HEADSET_PLUG:
                    message = "Head Phone Plugged";
                    break;
                case Intent.ACTION_POWER_CONNECTED:
                    message = "connected";
                    break;
                case Intent.ACTION_POWER_DISCONNECTED:
                    message = "disconnected";
                    break;
                case ACTION_CUSTOM_BROADCAST:
                    message = "Custom";
                    break;
            }
        }
        Toast.makeText(context,message,Toast.LENGTH_LONG);
    }
}
