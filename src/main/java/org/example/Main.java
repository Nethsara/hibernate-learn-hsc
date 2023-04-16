package org.example;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Environment;
import org.hibernate.mapping.MetadataSource;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        //Hibernate util class created with static constructor
        try ( Session session = HibernateUtil.getSessionFactory().openSession()){
            Object singleResult = session.createNativeQuery("SELECT NOW()").getSingleResult();

        }

    }
}