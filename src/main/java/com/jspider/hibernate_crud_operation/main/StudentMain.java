package com.jspider.hibernate_crud_operation.main;

import java.sql.SQLSyntaxErrorException;

import com.jspider.hibernate_crud_operation.dao.StudentDao;
import com.jspider.hibernate_crud_operation.dto.Student;

public class StudentMain {
	public static void main(String[] args) {
		
		StudentDao dao = new StudentDao();
	
		Student s4 = new Student("Kundan","barajor","Male");
		
//		dao.saveStudentDetails(s1);
//		dao.saveStudentDetails(s2);
//		dao.saveStudentDetails(s3);
//		dao.saveStudentDetails(s4);
		
//		Student st = dao.getStudentByID(1);
//		dao.deleteStudent(19);
		
		dao.updateStudent(s4);
	
		
		
		
	}

	
}
