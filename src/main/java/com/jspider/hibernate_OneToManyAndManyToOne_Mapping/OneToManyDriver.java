package com.jspider.hibernate_OneToManyAndManyToOne_Mapping;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class OneToManyDriver {
    public static void main(String[] args) {

        Configuration cfg = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Department.class)
                .addAnnotatedClass(Employee.class);

        SessionFactory factory = cfg.buildSessionFactory();
        Session session = factory.openSession();
        Transaction tx = session.beginTransaction();

        // Create Department
        Department dept = new Department();
        dept.setDeptName("IT Department");

        // Create Employees
        Employee e1 = new Employee();
        e1.setEmpName("Satish");
        e1.setDepartment(dept);

        Employee e2 = new Employee();
        e2.setEmpName("Shiva");
        e2.setDepartment(dept);

        // Link Employees to Department
        List<Employee> empList = new ArrayList<>();
        empList.add(e1);
        empList.add(e2);
        dept.setEmployees(empList);

        session.persist(dept);

        tx.commit();
        session.close();
        factory.close();

        System.out.println("✅ One-to-Many & Many-to-One mapping saved successfully!");
    }
}
