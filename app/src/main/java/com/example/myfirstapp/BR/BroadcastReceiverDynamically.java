package com.example.myfirstapp.BR;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

import com.example.myfirstapp.MainActivity;

public class BroadcastReceiverDynamically extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        Toast.makeText(context, "接收到广播", Toast.LENGTH_SHORT).show();
        Log.i(MainActivity.TAG_MYAPP, "Broadcast Received.");
    }

}
