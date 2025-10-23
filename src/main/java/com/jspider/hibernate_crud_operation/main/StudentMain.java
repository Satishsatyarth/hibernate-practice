package com.jspider.hibernate_crud_operation.main;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.SQLSyntaxErrorException;

import com.jspider.hibernate_crud_operation.dao.StudentDao;
import com.jspider.hibernate_crud_operation.dto.Student;
import com.jspider.hibernate_crud_operation.dto.StudentAddress;

public class StudentMain {
	public static void main(String[] args) throws IOException {
		
		StudentDao dao = new StudentDao();
	
		Student s4 = new Student("Kundan","barajor","Male");
		
//		dao.saveStudentDetails(s1);
//		dao.saveStudentDetails(s2);
//		dao.saveStudentDetails(s3);
//		dao.saveStudentDetails(s4);
		
//		Student st = dao.getStudentByID(1);
//		dao.deleteStudent(19);
		
//		dao.updateStudent(s4);
	
		StudentAddress stdAd = new StudentAddress();
		stdAd.setStreet("Kali mandir");
		stdAd.setCity("jhajha");
		stdAd.setState("Bihar");
		stdAd.setOpen(true);
		
		FileInputStream fis = new FileInputStream("src/main/resources/profile.jpeg");
		byte[] imageData = new byte[fis.available()];
		fis.read(imageData);
		stdAd.setImage(imageData);
		
		dao.saveStudentaddress(stdAd);
	}

	
}
