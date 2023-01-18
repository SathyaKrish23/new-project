package com.web.doList.Entity;

import java.util.ArrayList;


import java.util.List;
import jakarta.persistence.Id;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotBlank;
import jakarta.persistence.CascadeType;



@Entity
public class Person {
	
	@Id  @GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@NotBlank(message = "name is required")
	private String name;
	
	@NotBlank(message = "password is required")
	private String password;
	
	private String email;
	
	private String gender;
	
	@OneToMany(cascade = CascadeType.ALL)
	private List <Todo> work = new ArrayList<>();


	

	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getGender() {
		return gender;
	}


	public void setGender(String gender) {
		this.gender = gender;
	}


	public List<Todo> getWork() {
		return work;
	}


	public void setWork(List<Todo> work) {
		this.work = work;
	}

	public Person() {
		
	}
	
	public Person(Long id, String name, String password, String email,String gender, List<Todo> work) {
		this.id = id;
		this.name = name;
		this.password = password;
		this.email = email;
		this.gender = gender;
		this.work = work;
	}


	@Override
	public String toString() {
		return "Person [id=" + id + ", name=" + name +"password"+ ", email=" + email + ", work=" + work + "]";
	}


	
	
	
	
	

}
