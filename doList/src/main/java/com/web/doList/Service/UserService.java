package com.web.doList.Service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.web.doList.Entity.Person;
import com.web.doList.Entity.Todo;


public interface UserService {
	

	public ResponseEntity<Person> userLogin(Person user);
	
	public Person newUser(Person user);
	
	public Person updateUser(Person user,Long id);
	
	public void addTodo(Todo work, Long uid);
	
	public List<Todo> getWorks( Long uid);
	
	public void todoCompleted(Long uid,Long id);
	
	public void deleteTodo(Long uid, Long id);
	
	public void deleteUser(Long uid);


	


}
