package com.example.myfirstapp;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;

public class MyServiceForIPC extends Service {

    private final String TAG = "IPC";

    //构造内部类
    private MyServer.Stub stub = new MyServer.Stub() {
        @Override
        public void say(String word) throws RemoteException {
            Log.i(MainActivity.TAG_MYAPP, "receive say content: " + word + " in server");
        }

        @Override
        public int tell(String word, int age) throws RemoteException {
            Log.i(MainActivity.TAG_MYAPP, "receive tell content: " + word + "age: " + age + " in server");
            return age+1;
        }
    };

    @Override
    public IBinder onBind(Intent intent) {
        //Stub继承了Binder, 因此是Binder类型
        return stub;
    }
}