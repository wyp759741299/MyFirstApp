package com.example.myfirstapp;


/*
* 这个服务被绑定到第二个活动上.
* */

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.util.Log;
import android.widget.Toast;

public class MyServiceBind extends Service {
    // Binder given to clients
    private final IBinder binder = new LocalBinder();

//    public MyServiceBind getService() {
//        return MyServiceBind.this;
//    }
//    // Random number generator

    /**
     * Class used for the client Binder.  Because we know this service always
     * runs in the same process as its clients, we don't need to deal with IPC.
     */
    public class LocalBinder extends Binder {
        MyServiceBind getService() {
            // Return this instance of LocalService so clients can call public methods
            return MyServiceBind.this;
        }
    }

    public MyServiceBind() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        Toast.makeText(this, "绑定服务启动!", Toast.LENGTH_SHORT).show();
        Log.i(MainActivity.TAG_MYAPP, "Bind_Service_Started!");
        return binder;
    }

    public void LogShow(){
        Log.i(MainActivity.TAG_MYAPP, "I am Groot.");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Toast.makeText(this, "绑定服务停止!", Toast.LENGTH_SHORT).show();

        Log.i(MainActivity.TAG_MYAPP, "Bind_Service_Stopped!");
    }
}