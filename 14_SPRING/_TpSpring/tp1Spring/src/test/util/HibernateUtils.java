package com.example.tp1spring.util;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtils {

    private static SessionFactory buildSessionFactory(){
        try{
            return new Configuration().configure("src/test/hibernate.cfg.xml.old").buildSessionFactory();
        }catch (HibernateException h){
            throw h;
        }
    }

    public static SessionFactory getSessionFactory(){
        return  buildSessionFactory();
    }


}
