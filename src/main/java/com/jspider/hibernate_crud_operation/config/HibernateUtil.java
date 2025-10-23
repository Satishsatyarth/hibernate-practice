package com.jspider.hibernate_crud_operation.config;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import com.jspider.hibernate_crud_operation.dto.Student;

public class HibernateUtil {
	private static SessionFactory sessionFactory;

	static {
		try {
			Configuration cfg = new Configuration();
			cfg.configure("hibernate.cfg.xml"); // DB load
			cfg.addAnnotatedClass(Student.class);

			ServiceRegistry registry = new StandardServiceRegistryBuilder().applySettings(cfg.getProperties()).build();

			sessionFactory = cfg.buildSessionFactory(registry);
		}

		catch (Exception e) {
			e.printStackTrace();
			throw new ExceptionInInitializerError("SessionFactory creation failed: " + e);
		}
	}

	
	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public static void closeFactory() {
		if (sessionFactory != null)
			sessionFactory.close();
	}
}
