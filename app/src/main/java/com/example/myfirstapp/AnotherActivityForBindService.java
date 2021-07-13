package com.example.myfirstapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.view.View;

public class AnotherActivityForBindService extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_another_for_bind_service);
    }

    ServiceConnection serviceConnection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            //service 是从onBind(xx)方法里返回的(绑定者和Service同一进程)
            MyBinder myBinder = (MyBinder) service;
            //获取Service的引用
            MyService myService = (MyService) myBinder.getMyService();
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {
            //Service被销毁时调用,但正常解绑不会使用
        }
    };

    public void bindService(View view) {
        Intent intent = new Intent(this, MyService.class);
        bindService(intent, serviceConnection, BIND_AUTO_CREATE);
    }

}