package com.jspider.hibernate_crud_operation.main;

import com.jspider.hibernate_crud_operation.dao.StudentDao;
import com.jspider.hibernate_crud_operation.dto.Certificate;
import com.jspider.hibernate_crud_operation.dto.Student;

public class EmbedableDemo {
	public static void main(String[] args) {
		
		Student student = new Student();
		student.setName("Sagar");
		student.setGender("Jharkhand");
		student.setGender("Male");
		
		Certificate  certificate = new Certificate();
		certificate.setCourse("Web Development");
		certificate.setDuration("6 months");
		student.setCertificate(certificate);
		
		Student student1 = new Student();
		student1.setName("Sourav");
		student1.setGender("Bihar");
		student1.setGender("Male");
		
		Certificate  certificate1 = new Certificate();
		certificate1.setCourse("Bihar Police");
		certificate1.setDuration("3 months");
		student1.setCertificate(certificate1);
		
		StudentDao dao = new StudentDao();
		dao.saveStudentDetails(student1);
		dao.saveStudentDetails(student);
		
		
	}
}
