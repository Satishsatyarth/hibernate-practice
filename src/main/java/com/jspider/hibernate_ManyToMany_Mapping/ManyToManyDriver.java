package com.jspider.hibernate_ManyToMany_Mapping;

import java.util.ArrayList;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class ManyToManyDriver {
    public static void main(String[] args) {

        Configuration cfg = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .addAnnotatedClass(Course.class);

        SessionFactory factory = cfg.buildSessionFactory();
        Session session = factory.openSession();
        Transaction tx = session.beginTransaction();

        // Students
        Student s1 = new Student();
        s1.setName("Lakshmi");

        Student s2 = new Student();
        s2.setName("Saraswati");

        // Courses
        Course c1 = new Course();
        c1.setName("CSE");

        Course c2 = new Course();
        c2.setName("ECE");

        // Mapping lists
        List<Course> courses = new ArrayList<>();
        courses.add(c1);
        courses.add(c2);

        List<Student> students = new ArrayList<>();
        students.add(s1);
        students.add(s2);

        // Setting relationships
        s1.setCourses(courses);
        s2.setCourses(courses);

        c1.setStudent(students);
        c2.setStudent(students);

        // Persist from owning side
        session.persist(s1);

        tx.commit();
        session.close();
        factory.close();

        System.out.println("✅ Many-to-Many Mapping saved successfully!");
    }
}
