// MyServer.aidl
package com.example.myfirstapp;

// Declare any non-default types here with import statements

interface MyServer {

    //只有一个参数, 无返回
    void say(String word);

    //有两个参数, 返回一个int值
    int tell(String word, int age);
}