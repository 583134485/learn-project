package com.example;

import sun.applet.AppletClassLoader;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.nio.ByteBuffer;
import java.nio.channels.Channels;
import java.nio.channels.FileChannel;
import java.nio.channels.WritableByteChannel;

//how to define class loader
public class ParentLoad {

    public static void main(String[] args) throws ClassNotFoundException {
        MyClassLoader classLoader = new MyClassLoader("C:\\Users\\Guo\\IdeaProjects\\learn-project\\target\\classes\\com\\example");
        Class<?> c = Class.forName("com.example.Application", true, classLoader);
        System.out.println(c.getName());
        //l
        AppletClassLoader.getSystemClassLoader()
    }



}