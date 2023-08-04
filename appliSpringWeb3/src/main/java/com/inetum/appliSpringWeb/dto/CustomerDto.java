package com.inetum.appliSpringWeb.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data @NoArgsConstructor
public class CustomerDto {

	private Long id;
	private String firstname;
	private String lastname;
	private String password;
	
	
	
	public CustomerDto(Long id, String firstname, String lastname, String password) {
		super();
		this.id = id;
		this.firstname = firstname;
		this.lastname = lastname;
		this.password = password;
	}
	
}
