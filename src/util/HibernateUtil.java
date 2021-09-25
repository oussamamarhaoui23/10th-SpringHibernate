package util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
    public static SessionFactory sessionFactory;
    static {
    	try {
    		//Cr�ation de la SessionFactory � partir de hibernate.cfg.xml
    		sessionFactory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
    	}catch(Exception e) {
    		e.printStackTrace();
    	}
    }
	public static SessionFactory getSessionfactory() {
		return sessionFactory;
	}
    
}
