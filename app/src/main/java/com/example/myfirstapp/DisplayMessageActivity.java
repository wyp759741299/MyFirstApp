package com.example.myfirstapp;

/*
 * 第二个活动,该活动可以显示从第一个活动传来的intent里面的字符串，同时
 * 该活动绑定了一个Service(MyServiceBind), 该service会随着该活动
 * 的销毁而销毁.
 * */

import androidx.appcompat.app.AppCompatActivity;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class DisplayMessageActivity extends AppCompatActivity {

    MyServiceBind myServiceBind;
    boolean mBound = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_message);

        Log.i(MainActivity.TAG_MYAPP, "DisplayMessageActivity onCreate method runs!!");

        // Get the Intent that started this activity and extract the string
        Intent intent = getIntent();
        String message = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);

        // Capture the layout's TextView and set the string as its text

        if (!message.equals("")){
            TextView textView = findViewById(R.id.textView);
            textView.setText(message);
        }
    }

    @Override
    protected void onStop() {
        super.onStop();
        if (mBound) {
            unbindService(connection);
            mBound = false;
        }
    }

    public void onButtonClick (View v){
        if (mBound){
            myServiceBind.LogShow();
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
        Intent intent = new Intent(this, MyServiceBind.class);
        bindService(intent, connection, Context.BIND_AUTO_CREATE);
    }

    /** Defines callbacks for service binding, passed to bindService() */
    private ServiceConnection connection = new ServiceConnection() {

        @Override
        public void onServiceConnected(ComponentName className,
                                       IBinder service) {
            // We've bound to LocalService, cast the IBinder and get LocalService instance
            MyServiceBind.LocalBinder binder = (MyServiceBind.LocalBinder) service;
            myServiceBind = binder.getService();
            mBound = true;
        }

        @Override
        public void onServiceDisconnected(ComponentName arg0) {
            mBound = false;
        }
    };

}