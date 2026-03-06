
package com.example;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainXML {
    public static void main(String[] args) {

        ApplicationContext context =
                new ClassPathXmlApplicationContext("spring.xml");

        Student s = (Student) context.getBean("studentBean");
        s.display();
    }
}
