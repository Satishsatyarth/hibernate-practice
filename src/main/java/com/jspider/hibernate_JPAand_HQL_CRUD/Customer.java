package com.jspider.hibernate_JPAand_HQL_CRUD;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;


@Data
@Entity
@Table(name="customer_table")
public class Customer {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name="customer_name", nullable=false,length=100)
	private String name;
	
	@Column(length=100,nullable = false)
	private String email;
	
	@OneToMany(mappedBy = "customer",cascade = CascadeType.ALL)
	private List<Product> product;
	
}
