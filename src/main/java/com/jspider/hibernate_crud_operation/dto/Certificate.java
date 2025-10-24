package com.jspider.hibernate_crud_operation.dto;

import jakarta.persistence.Embeddable;
import lombok.Data;

@Data
@Embeddable
public class Certificate {

	private String course;
	private String duration;
	
}
