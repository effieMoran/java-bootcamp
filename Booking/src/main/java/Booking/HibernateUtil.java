package Booking;

import org.hibernate.cfg.Configuration;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

/**
 * Hibernate Utility class with a convenient method to get Session Factory
 * object.
 *
 * @author german
 */
public class HibernateUtil {

     private static SessionFactory sessionFactory ;
     static {
    	Configuration configuration = new Configuration().configure();
    	StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties());
        sessionFactory = configuration.buildSessionFactory(builder.build());
     }
    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}
