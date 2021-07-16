package com.example.myfirstapp;

/*
* 主活动
* */

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;


import com.example.myfirstapp.BR.BroadcastReceiverDynamically;

public class MainActivity extends AppCompatActivity {

    public static final String EXTRA_MESSAGE = "com.example.myfirstapp.MESSAGE";
    public static final String TAG_MYAPP = "MyFirstApp";
//    public static final String LOCAL_BROADCAST = "com.example.myfirstapp.LOCAL_BROADCAST";

    //全局广播接收器
    BroadcastReceiverDynamically myReceiver;
    BroadcastReceiverDynamically myLocalReceiver;

    private void registerReceiverDynamic() {
        //在MainActivity中动态注册广播
        myReceiver = new BroadcastReceiverDynamically();
        IntentFilter itFilter = new IntentFilter();
        itFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
        registerReceiver(myReceiver, itFilter);
    }


//    //本地广播接收
//    private void registerLocalReceiver() {
//        IntentFilter intentFilter = new IntentFilter();
//        intentFilter.addAction(LOCAL_BROADCAST);
//        LocalBroadcastManager.getInstance(this).registerReceiver(myLocalReceiver, intentFilter);
//    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.    activity_main);
        Log.i(TAG_MYAPP, "MainActivity onCreate method runs!");

        //动态注册
        registerReceiverDynamic();
//        registerLocalReceiver();
    }

    public void sendMessage(View view) {
        Intent intent = new Intent(this, DisplayMessageActivity.class);
        EditText editText = (EditText) findViewById(R.id.editText);
        String message = editText.getText().toString();
        intent.putExtra(EXTRA_MESSAGE, message);
        startActivity(intent);
    }

    public void community(View view){
        Intent intent = new Intent(this, AnotherActivityForBindService.class);
        startActivity(intent);
    }

    public void startService(View view){
        startService(new Intent(this, MyService.class));
    }

    public void stopService(View view){
        stopService(new Intent(this, MyService.class));
    }

//    public void sendLocalBroadcast(View view){
//        Intent intent = new Intent();
//        intent.setAction(LOCAL_BROADCAST);
//        LocalBroadcastManager.getInstance(MainActivity.this).sendBroadcast(intent);
//    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i(TAG_MYAPP, "MainActivity onStart method runs!!");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.i(TAG_MYAPP, "MainActivity onRestart method runs!!");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i(TAG_MYAPP, "MainActivity onResume method runs!!");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i(TAG_MYAPP, "MainActivity onPause method runs!!!");
    }

    @Override
    protected void onStop() {
        super.onStop();

        //执行onStop()方法时可以存储一些数据或者进行一些CPU密集操作.
        EditText editText = (EditText) findViewById(R.id.editText);
        String message = editText.getText().toString();
        if (!message.equals("")){
            Log.i(TAG_MYAPP, message);
        }
        Log.i(TAG_MYAPP, "MainActivity onStop method runs!!!!");

    }

    @Override
    protected void onDestroy() {
        //把广播取消掉
        unregisterReceiver(myReceiver);

        LocalBroadcastManager.getInstance(this).unregisterReceiver(myLocalReceiver);

        super.onDestroy();
        Log.i(TAG_MYAPP, "MainActivity onDestroy method runs!!!!!");
    }
}