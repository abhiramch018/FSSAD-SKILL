
package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Student {

    private int id = 2400032309;
    private String name = "Ch Abhiram";
    private String gender = "Male";

    @Autowired
    private Certification certification;

    public void display(){
        System.out.println("Student ID: " + id);
        System.out.println("Name: " + name);
        System.out.println("Gender: " + gender);
        System.out.println("---- Certification Details ----");
        certification.display();
    }
}
