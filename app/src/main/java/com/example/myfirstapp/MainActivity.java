package com.example.myfirstapp;

/*
* 主活动
* */

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    public static final String EXTRA_MESSAGE = "com.example.myfirstapp.MESSAGE";
    public static final String TAG_MYAPP = "MyFirstApp";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.i(TAG_MYAPP, "MainActivity onCreate method runs!");
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


//    public void sendMessage(View view) {
//        Intent intent = new Intent(Intent.ACTION_SEND);
//        intent.putExtra(Intent.EXTRA_EMAIL, "wangyoupeng@oppo.com");
//        startActivity(intent);
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
        super.onDestroy();
        Log.i(TAG_MYAPP, "MainActivity onDestroy method runs!!!!!");
    }
}