package com.example.myfirstapp;

import android.os.Binder;

public class MyBinder extends Binder {
    //实例化一个服务, 使得其他组件可以通过这个Binder调用该服务中的公共方法
    private MyService myService;

    public MyBinder(MyService myService) {
        //构造函数
        this.myService = myService;
    }

    public MyService getMyService() {
        //返回服务实例
        return myService;
    }
}
