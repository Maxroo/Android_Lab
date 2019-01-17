package com.example.maxwu.notifyme;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.os.Build;
import android.renderscript.RenderScript;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private static final int NOTIFICATION_ID = 0;
    private static final String UPDATE_NOTIFICATION = "Update Message";
    private Button mNotifyBtn;
    private static String PRIMARY_CHANNEL_ID = "Primary_notification";
    private NotificationManager notificationManager;
    private Button mUpdateBtn;
    private Button mCancelBtn;
    private NotificationReceiver mReceiver = new NotificationReceiver();

    public class NotificationReceiver extends BroadcastReceiver{
        public static final String UPDATE_NOTIFICATION = BuildConfig.APPLICATION_ID;
        public NotificationReceiver(){

        }

        @Override
        public void onReceive(Context context, Intent intent) {
            updateNotification();
        }
    }


    private NotificationCompat.Builder getNotificationbuilder()
    {
        Intent intent = new Intent(this, MainActivity.class);
        PendingIntent pendingIntent = PendingIntent.getActivity(this,NOTIFICATION_ID,intent,PendingIntent.FLAG_UPDATE_CURRENT);
        NotificationCompat.Builder notifyBuilder = new NotificationCompat.Builder(
                this,PRIMARY_CHANNEL_ID
        );
        notifyBuilder.setContentTitle("Title").setContentText("Text")
                .setSmallIcon(R.drawable.ic_stat_name).setContentIntent(pendingIntent).setAutoCancel(true).setPriority(NotificationCompat.PRIORITY_HIGH)
                .setDefaults(NotificationCompat.DEFAULT_LIGHTS);
        return notifyBuilder;
    }

    public void createNotificationChannel()
    {
        notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O)
        {
            NotificationChannel channel = new NotificationChannel(
                    PRIMARY_CHANNEL_ID,"CICCCC",notificationManager.IMPORTANCE_HIGH

            );
            channel.setLightColor(Color.BLACK);
            channel.enableVibration(true);
            channel.enableLights(true);
            channel.setDescription("Notify");
            notificationManager.createNotificationChannel(channel);
        }
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mNotifyBtn = findViewById(R.id.notifybtm);
        mUpdateBtn = findViewById(R.id.Updatebtm);
        mCancelBtn = findViewById(R.id.cancelbtm);
        registerReceiver(mReceiver, new IntentFilter(UPDATE_NOTIFICATION));
        mUpdateBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateNotification();
            }
        });

        mCancelBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cancelNotification();
            }
        });

        mNotifyBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendNotification();
            }
        });
        createNotificationChannel();
        setNotificationButtonState(true,false,false);
    }

    private void updateNotification() {
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.mascot_1);
        NotificationCompat.Builder builder = getNotificationbuilder();
        builder.setStyle(new NotificationCompat.BigPictureStyle().bigPicture(bitmap).setBigContentTitle("NotifcationUpdate"));
        notificationManager.notify(NOTIFICATION_ID,builder.build());
        setNotificationButtonState(false,false,true);
    }


    private void cancelNotification() {
        setNotificationButtonState(true,false,false);
        notificationManager.cancel(NOTIFICATION_ID);
    }

    private void sendNotification() {
        Intent updateintent = new Intent(UPDATE_NOTIFICATION);
        PendingIntent updatePendingintent = PendingIntent.getBroadcast(this,NOTIFICATION_ID,updateintent,PendingIntent.FLAG_ONE_SHOT);
        NotificationCompat.Builder notifyBuilder = getNotificationbuilder();
        notifyBuilder.addAction(R.drawable.ic_update,UPDATE_NOTIFICATION,updatePendingintent);
        notificationManager.notify(NOTIFICATION_ID, notifyBuilder.build());
        setNotificationButtonState(false,true,true);
    }

    private void setNotificationButtonState(Boolean notify, Boolean update, Boolean cancel)
    {
        mNotifyBtn.setEnabled(notify);
        mUpdateBtn.setEnabled(update);
        mCancelBtn.setEnabled(cancel);
    }

}


