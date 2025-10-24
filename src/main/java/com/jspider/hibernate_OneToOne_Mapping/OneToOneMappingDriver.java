package com.jspider.hibernate_OneToOne_Mapping;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import com.jspider.hibernate_crud_operation.dao.StudentDao;

public class OneToOneMappingDriver {
	public static void main(String[] args) {
		
		System.out.println("==============Program Started===================");
		Configuration cfg = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Employee.class)
				.addAnnotatedClass(Address.class);
		
		SessionFactory factory = cfg.buildSessionFactory();
		
		Employee emp1=new Employee();
		emp1.setName("john");
		emp1.setSalary(123586.23);
		
		Address ad1 = new Address();
		ad1.setCity("London");
		ad1.setStreet("OxfordStreet");
		ad1.setState("GreaterLondon");
		
		emp1.setAddress(ad1);
	
		Employee emp2=new Employee();
		emp2.setName("Bob");
		emp2.setSalary(12386.23);
		
		Address ad2 = new Address();
		ad2.setCity("Perth");
		ad2.setStreet("PerthStreet");
		ad2.setState("Australia");
		
		emp2.setAddress(ad2);
		
		Session session = factory.openSession();
		Transaction tx =  session.beginTransaction();
		
		session.persist(emp1);
		session.persist(emp2);
		session.persist(ad1);
		session.persist(ad2);
		
		tx.commit();
		
		session.close();
		factory.close();
		
		System.out.println("Data inserted Successfully");
		System.out.println("Program Ends");
	}
}
