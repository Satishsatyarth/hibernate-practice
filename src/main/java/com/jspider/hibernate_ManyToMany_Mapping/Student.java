package com.jspider.hibernate_ManyToMany_Mapping;

import java.util.List;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name = "student_table")
public class Student {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name="std_name")
	private String name;
	
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(
		    name = "student_course",
		    joinColumns = @JoinColumn(name="student_id"),
		    inverseJoinColumns = @JoinColumn(name="course_id")
		)

	private List<Course> courses;
	

}
