package com.example.myfirstapp;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;
import android.widget.Toast;

public class MyService extends Service {

    public MyService() {
    }


    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Toast.makeText(this, "服务启动!", Toast.LENGTH_SHORT).show();
        Log.i(MainActivity.TAG_MYAPP, "MyService started!");
        for (int i = 0; i < 20; i++) {
            try {
                //Toast.makeText(this, "服务运行中。。。", Toast.LENGTH_SHORT).show();
                Log.i(MainActivity.TAG_MYAPP, "Service running...");
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        Toast.makeText(this, "服务即将停止。。。", Toast.LENGTH_SHORT).show();
        stopSelf();
        return super.onStartCommand(intent, flags, startId);
    }


    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.i(MainActivity.TAG_MYAPP, "MyService stopped!");
        Toast.makeText(this, "服务停止!", Toast.LENGTH_SHORT).show();
    }
}