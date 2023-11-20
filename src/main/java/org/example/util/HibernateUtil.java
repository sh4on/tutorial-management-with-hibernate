package org.example.util;

import org.example.model.Tutorial;
import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

final public class HibernateUtil {
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
            configuration.configure();
            configuration.addAnnotatedClass(Tutorial.class);

            sessionFactory = configuration.buildSessionFactory();
        } catch (HibernateException e) {
            e.printStackTrace();
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
