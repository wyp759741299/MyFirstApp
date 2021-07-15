package com.example.myfirstapp;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;

public class MyServiceStudent extends Service {

    private StudentServer.Stub stub = new StudentServer.Stub() {
        @Override
        public void getStudentInfo(int age, Student student) throws RemoteException {
            Log.i(MainActivity.TAG_MYAPP, "Received message from client: " + " name: " + student.getName() + ", age: " + student.getAge() + ". ");
            student.setAge(18);
            student.setName("XiaoMing");
            Log.i(MainActivity.TAG_MYAPP, "Changed the message received from client: " + " name: " + student.getName() + ", age: " + student.getAge() + ". ");
        }
    };

    @Override
    public IBinder onBind(Intent intent) {
        return stub;
    }
}