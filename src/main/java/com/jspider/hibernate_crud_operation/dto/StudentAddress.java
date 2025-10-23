package com.jspider.hibernate_crud_operation.dto;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor

@Entity
@Table(name="student_address")
public class StudentAddress {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="address_id")
	private int addressid;
	
	@Column(length=100,nullable = true)
	private String street;
	
	@Column(length=100,nullable = true)
	private String city;
	
	@Column(length=45,nullable = true)
	private String state;

	private boolean isOpen;
	
	@Lob
	private byte[] image;
	
}
