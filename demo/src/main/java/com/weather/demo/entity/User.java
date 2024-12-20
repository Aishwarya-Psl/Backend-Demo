package com.weather.demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Email;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class User {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank
	private String userName;
	
	@NotBlank
	private String password;
	
	@NotBlank
	@Email
	private String email;
	
	@Enumerated(EnumType.STRING)
	private Role role=Role.USER;
	
	public enum Role{
		USER,ADMIN;
	}

	public String getPassWord() {
		// TODO Auto-generated method stub
		return password;
	}

	public void setPassword(String encode) {
		// TODO Auto-generated method stub
		this.password=encode;
	}
}
