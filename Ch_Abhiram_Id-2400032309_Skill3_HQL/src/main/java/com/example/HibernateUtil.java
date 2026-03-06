
package com.example;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {

    private static final SessionFactory sessionFactory;

    static{
        try{
            sessionFactory = new Configuration()
                    .configure()
                    .addAnnotatedClass(Product.class)
                    .buildSessionFactory();
        }catch(Exception e){
            throw new ExceptionInInitializerError(e);
        }
    }

    public static SessionFactory getSessionFactory(){
        return sessionFactory;
    }
}
