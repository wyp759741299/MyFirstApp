package com.example.myfirstapp;

import android.os.Binder;

import androidx.annotation.Nullable;

public class MyBinder extends Binder {
    private MyService myService;

    public MyBinder(MyService myService) {
        this.myService = myService;
    }

    public MyService getMyService() {
        return myService;
    }
}
