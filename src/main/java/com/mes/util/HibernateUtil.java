package com.mes.util;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public final class HibernateUtil {
    private static EntityManagerFactory factory;

    static {
        try {
            factory = Persistence.createEntityManagerFactory("taemyung");
        } catch (Exception e) {
            System.out.println("create entity manager factory error");
        }
    }

    public static EntityManagerFactory getFactory(){
        return factory;
    }

    public static void closeFactory(){
        try {
            factory.close();
        }catch (IllegalStateException e){
            e.printStackTrace();
            System.out.println("close entity manager factory error");
        }

    }
}
