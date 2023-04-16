package org.example;

import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Environment;

import java.util.HashMap;
import java.util.Map;

public class HibernateUtil {
    private static StandardServiceRegistry standardServiceRegistry;

    private static SessionFactory sessionFactory;

    static {
        try {
            if(sessionFactory == null){
                StandardServiceRegistryBuilder standardServiceRegistryBuilder = new StandardServiceRegistryBuilder();
                Map<String, String> databaseConfig = new HashMap<>();
                databaseConfig.put(Environment.URL, "jdbc:mysql://localhost:3306/asd_1?createDatabaseIfNotExist=true");
                databaseConfig.put(Environment.USER, "root");
                databaseConfig.put(Environment.PASS, "");
                databaseConfig.put(Environment.DRIVER, "com.mysql.cj.jdbc.Driver");
                databaseConfig.put(Environment.DIALECT, "org.hibernate.dialect.MySQL57Dialect");

                standardServiceRegistryBuilder.applySettings(databaseConfig);

                standardServiceRegistry= standardServiceRegistryBuilder.build();

                MetadataSources metadataSource = new MetadataSources(standardServiceRegistry);
                Metadata metadata = metadataSource.getMetadataBuilder().build();
                sessionFactory = metadata.getSessionFactoryBuilder().build();
            }
        }catch (Exception e) {
            if(standardServiceRegistry!=null){
                StandardServiceRegistryBuilder.destroy(standardServiceRegistry);
            }
            e.printStackTrace();
        }

    }
    public static SessionFactory getSessionFactory(){
        return sessionFactory;
    }
}
