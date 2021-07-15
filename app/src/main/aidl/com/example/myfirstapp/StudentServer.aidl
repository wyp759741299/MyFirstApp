// StudentServer.aidl
package com.example.myfirstapp;

// Declare any non-default types here with import statements
import com.example.myfirstapp.Student;

interface StudentServer {
    void getStudentInfo(int age, in Student student);
}