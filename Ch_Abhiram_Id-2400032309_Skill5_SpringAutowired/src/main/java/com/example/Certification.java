
package com.example;

import org.springframework.stereotype.Component;

@Component
public class Certification {

    private int id = 101;
    private String name = "Java Full Stack";
    private String dateOfCompletion = "2026-03-01";

    public void display(){
        System.out.println("Certification ID: " + id);
        System.out.println("Certification Name: " + name);
        System.out.println("Date Of Completion: " + dateOfCompletion);
    }
}
