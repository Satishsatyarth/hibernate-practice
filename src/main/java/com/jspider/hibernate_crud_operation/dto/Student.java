package com.jspider.hibernate_crud_operation.dto;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class Student {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) // Auto generated ID
	private int id;
	
	@Column(length=45, nullable=false)
	private String name;
	
	@Column(length=45)
	private String city;
	private String gender;
	
	private Certificate certificate;

	public Student() {
		
	}
	public Student(String name,String city,String gender){
		this.name = name;
		this.city = city;
		this.gender = gender;
	}
}
