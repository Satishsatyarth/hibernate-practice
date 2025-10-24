package com.jspider.hibernate_OneToOne_Mapping;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@Entity
public class Employee {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name="emp_name", length=100, nullable=false)
	private String name;
	
	@Column(name="emp_salary")
	private double salary;
	
	@OneToOne
	@JoinColumn(name="address_id")
	private Address address;
	
}
