package com.example.myfirstapp;
/*
* @Arthur
* 这个服务用来演示使用startService方法创建并启动服务
* */

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;
import android.widget.Toast;

public class MyService extends Service {

    public MyService() {
        super();
    }

    //在MyService里添加子线程, 用于执行耗时操作, 通过继承Thread类并重写run()方法实现.
    private void goThread(){
        //开启线程, 没有线程时创建线程
        if(null == myThread){
            myThread = new MyThread();
        }
        myThread.start();
    }
    private void stopThread() {
        //打断线程, 首先判断线程是否存活, 然后进行打断并置空
        if(null != myThread && myThread.isAlive()){
            myThread.interrupt();
            myThread = null;
        }
    }

    private class MyThread extends Thread{
        @Override
        public void run() {
            super.run();
            // 判断状态，如果被打断则跳出并将线程置空
            while (!isInterrupted()){
                Log.i(MainActivity.TAG_MYAPP, "中国万岁!");
                try {
                    Thread.sleep(500);
                    Log.i(MainActivity.TAG_MYAPP, "人民万岁!");
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    //判断线程是否有异常抛出, 抛出则打断
                    e.printStackTrace();
                    Log.i(MainActivity.TAG_MYAPP, "异常抛出, 停止线程");
                    break;
                }
            }
        }
    }
    //创建线程实例
    MyThread myThread = new MyThread();

    @Override
    public void onCreate() {
        //与onDestroy()相对, 第一次创建该服务时会调用这个方法
        //在这里可以进行一些初始化操作
        super.onCreate();
        Log.i(MainActivity.TAG_MYAPP, "MyService onCreate!");

        goThread();

    }

    @Override
    public IBinder onBind(Intent intent) {
        //组件使用绑定的方式启动服务时, 该方法被调用
        Log.i(MainActivity.TAG_MYAPP, "MyService onBind!");
        Toast.makeText(this, "服务绑定启动!", Toast.LENGTH_SHORT).show();
        return new MyBinder(this);
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        //这个方法紧接在onCreate()方法后, 在这个方法里执行service主要做的事
        Toast.makeText(this, "服务创建启动!", Toast.LENGTH_SHORT).show();
        Log.i(MainActivity.TAG_MYAPP, "MyService onStartCommand runs!");
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        stopThread();
        super.onDestroy();
        Log.i(MainActivity.TAG_MYAPP, "MyService stopped!");
        Toast.makeText(this, "服务停止!", Toast.LENGTH_SHORT).show();
    }
}