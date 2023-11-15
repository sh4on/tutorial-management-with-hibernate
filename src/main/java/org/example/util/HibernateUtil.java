package org.example.util;

import org.example.model.Tutorial;
import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
    private static final SessionFactory SESSION_FACTORY;

    private HibernateUtil() {
    }

    static {
        SESSION_FACTORY = buildSessionFactory();
    }

    private static SessionFactory buildSessionFactory() {
        SessionFactory sessionFactory = null;

        try {
            Configuration configuration = new Configuration();
            // Load Hibernate configuration from hibernate.cfg.xml
            configuration.configure();
            configuration.addAnnotatedClass(Tutorial.class);

            sessionFactory = configuration.buildSessionFactory();
        } catch (HibernateException e) {
            // Handle any exceptions that occur during SessionFactory creation
            System.err.println("SessionFactory creation failed: " + e.getMessage());
            e.printStackTrace();

            // Exit the application in case of failure
            System.exit(1);
        }

        return sessionFactory;
    }

    public static SessionFactory getSessionFactory() {
        return SESSION_FACTORY;
    }

    public static void closeSessionFactory() {
        if (SESSION_FACTORY.isOpen()) {
            SESSION_FACTORY.close();
        }
    }
}
