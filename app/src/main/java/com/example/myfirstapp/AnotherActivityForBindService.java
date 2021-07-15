package com.example.myfirstapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;
import android.view.View;

public class AnotherActivityForBindService extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_another_for_bind_service);
    }
//    /*
//    * 这部分代码用来绑定启动MyService
//    * */
//    ServiceConnection serviceConnection = new ServiceConnection() {
//        @Override
//        public void onServiceConnected(ComponentName name, IBinder service) {
//            //service 是从onBind(xx)方法里返回的(绑定者和Service同一进程)
//            MyBinder myBinder = (MyBinder) service;
//            //获取Service的引用
//            MyService myService = (MyService) myBinder.getMyService();
//            Log.i(MainActivity.TAG_MYAPP, "serviceConnection中的onServiceConnected()方法被执行!");
//        }
//
//        @Override
//        public void onServiceDisconnected(ComponentName name) {
//            Log.e(MainActivity.TAG_MYAPP, "非常正常解绑!");
//            //Service被销毁时调用,但正常解绑不会使用
//        }
//    };
//
//    public void unBindService(View view) {
//        Log.i(MainActivity.TAG_MYAPP, "unBindService()方法被执行!");
//        unbindService(serviceConnection);
//    }
//
//    public void bindService(View view) {
//        Intent intent = new Intent(this, MyService.class);
//        bindService(intent, serviceConnection, BIND_AUTO_CREATE);
//        Log.i(MainActivity.TAG_MYAPP, "bindService()方法被执行!");
//    }

//    /*
//    * 这部分代码用来绑定启动使用AIDL文件生成的MyServer接口实现的MyServerForIPC服务
//    * */
//
//    ServiceConnection serviceConnection = new ServiceConnection() {
//        @Override
//        public void onServiceConnected(ComponentName name, IBinder service) {
//            MyServer myServer = MyServer.Stub.asInterface(service);
//            try {
//                myServer.say("Hello! ");
//                int result = myServer.tell("Hey!!! ", 18);
//                Log.i(MainActivity.TAG_MYAPP, "receive return content:" + result + " in client");
//            } catch (RemoteException e) {
//                e.printStackTrace();
//            }
//        }
//
//        @Override
//        public void onServiceDisconnected(ComponentName name) {
//
//        }
//    };
//
//    public void bindService(View view) {
//        Intent intent = new Intent(this, MyServiceForIPC.class);
//        bindService(intent, serviceConnection, BIND_AUTO_CREATE);
//        Log.i(MainActivity.TAG_MYAPP, "bindService()方法被执行!");
//    }
//
//    public void unBindService(View view) {
//        Log.i(MainActivity.TAG_MYAPP, "unBindService()方法被执行!");
//        unbindService(serviceConnection);
//    }

    /*
    * 这部分代码用来实践使用AIDL传递自定义数据类型对象
    * */

    ServiceConnection serviceConnection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            StudentServer server = StudentServer.Stub.asInterface(service);
            try {
                server.getStudentInfo(2, new Student("Arthur", 24));
            } catch (RemoteException e) {

            }
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {

        }
    };

    public void bindService(View view) {
        Intent intent = new Intent(this, MyServiceStudent.class);
        bindService(intent, serviceConnection, BIND_AUTO_CREATE);
        Log.i(MainActivity.TAG_MYAPP, "bindService()方法被执行!");
    }

    public void unBindService(View view) {
        Log.i(MainActivity.TAG_MYAPP, "unBindService()方法被执行!");
        unbindService(serviceConnection);
    }


}