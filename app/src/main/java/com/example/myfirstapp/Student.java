package com.example.myfirstapp;

import android.os.Parcel;
import android.os.Parcelable;

public class Student implements Parcelable {

    private String name;
    private int age;

    public Student(String name, int age) {
        //构造函数
        this.name = name;
        this.age = age;
    }

    /*
    *从序列化 结构 中创建原始对象
    * */
    protected Student(Parcel in) {
        name = in.readString();
        age = in.readInt();
    }

    /*
    * 反序列化
    * */
    public static final Creator<Student> CREATOR = new Creator<Student>() {
        //从序列化 对象 中创建原始对象
        @Override
        public Student createFromParcel(Parcel in) {
            //构造新对象
            return new Student(in);
        }

        //创建指定长度的原始对象数组
        @Override
        public Student[] newArray(int size) {
            return new Student[size];
        }
    };

    @Override
    public int describeContents() {
        //当前对象的内容描述，存在文件描述符时返回1  其余全返回0
        return 0;
    }

    /*
    * 序列化：将当前对象写入序列化结构中
    * */
    @Override
    public void writeToParcel(Parcel dest, int flags) {
        //将成员变量写入序列化对象里
        dest.writeString(name);
        dest.writeInt(age);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
