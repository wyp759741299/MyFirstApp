package com.example.myfirstapp.BR;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

import com.example.myfirstapp.MainActivity;

public class BroadcastReceiverStatic extends BroadcastReceiver {
    private final String ACTION_BOOT = "android.intent.action.BOOT_COMPLETED";
    private final String MY_OWN_BROADCAST = "com.example.myfirstapp.A_SIMPLE_BROADCAST";
    @Override
    public void onReceive(Context context, Intent intent) {
        if (intent.getAction().equals(ACTION_BOOT)){
            Toast.makeText(context, "开机!", Toast.LENGTH_SHORT).show();
            Log.i(MainActivity.TAG_MYAPP, "Received BOOT Broadcast!");
        }
        if (intent.getAction().equals(MY_OWN_BROADCAST)){
            Toast.makeText(context, "宝塔镇河妖!", Toast.LENGTH_SHORT).show();
            Log.i(MainActivity.TAG_MYAPP, "Received MY_OWN_BROADCAST!");
        }
    }
}
