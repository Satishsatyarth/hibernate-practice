package com.jspider.hibernate_crud_operation.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.jspider.hibernate_crud_operation.config.HibernateUtil;
import com.jspider.hibernate_crud_operation.dto.Student;

public class StudentDao {

	public void saveStudentDetails(Student student) {
		Transaction tx = null;

		try {
			Session session = HibernateUtil.getSessionFactory().openSession();
			tx = session.beginTransaction();
			session.persist(student);
			tx.commit();
			System.out.println("✅ Student saved successfully!");

		} catch (Exception e) {
			e.printStackTrace();
			if (tx != null)
				tx.rollback();
		}
	}

//	public Student getStudentByID(int id) {
//
//		Session session = HibernateUtil.getSessionFactory().openSession();
//		return session.get(Student.class, id);
//
//	}

	public void deleteStudent(int id) {
        Transaction tx = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            tx = session.beginTransaction();
            Student s = (Student)session.find(Student.class, id);
            if (s != null) {
                session.remove(s);
                System.out.println("✅ Student deleted successfully!");
            } else {
                System.out.println("⚠️ Student not found!");
            }
            tx.commit();
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        }
    }
	
	// UPDATE
    public void updateStudent(Student student) {
        Transaction tx = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            tx = session.beginTransaction();
            session.merge(student);
            tx.commit();
            System.out.println("✅ Student updated successfully!");
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        }
    }
}

