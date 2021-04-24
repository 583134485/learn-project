package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        System.out.println();
        SpringApplication.run(Application.class, args);
//        HashMap a=new HashMap();
//        Collection
//
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("D");
        arrayList.get(1);
        arrayList.remove(1);
        arrayList.remove("sd");



    }

}
