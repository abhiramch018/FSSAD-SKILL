
package com.example;

import org.springframework.stereotype.Component;

@Component
public class Student {

    private int id;
    private String name;
    private String branch;
    private int year;

    public Student() {
        this.id = 309;
        this.name = "Ch Abhiram";
        this.branch = "CSE";
        this.year = 2;
    }

    public void display() {
        System.out.println(id + " " + name + " " + branch + " " + year);
    }
}

