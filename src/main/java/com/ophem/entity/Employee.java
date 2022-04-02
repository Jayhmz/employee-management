package com.ophem.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;

import lombok.Data;

import javax.persistence.Id;

@Data
@Entity
@Table(name = "employees")
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer Id;
	
	@Column(name= "first_name")
	private String firstname;

	@Column(name= "last_name")
	private String lastname;

	@Column(name= "email")
	private String email;
	
	
}
