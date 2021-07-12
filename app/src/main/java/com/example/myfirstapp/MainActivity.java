package com.example.myfirstapp;

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
        Log.i(TAG_MYAPP, "onCreate method runs!");
    }

    public void sendMessage(View view) {
        Intent intent = new Intent(this, DisplayMessageActivity.class);
        EditText editText = (EditText) findViewById(R.id.editText);
        String message = editText.getText().toString();
        intent.putExtra(EXTRA_MESSAGE, message);
        startActivity(intent);
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i(TAG_MYAPP, "onStart method runs!!");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.i(TAG_MYAPP, "onRestart method runs!!");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i(TAG_MYAPP, "onResume method runs!!");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i(TAG_MYAPP, "onPause method runs!!!");
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
        Log.i(TAG_MYAPP, "onStop method runs!!!!");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i(TAG_MYAPP, "onDestroy method runs!!!!!");
    }
}