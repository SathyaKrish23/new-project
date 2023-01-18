package com.web.doList.Controller;

import java.util.List;




import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.web.doList.Entity.Person;
import com.web.doList.Entity.Todo;
import com.web.doList.Service.UserService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class UserController {

	@Autowired
	UserService service;
	
	@PostMapping("/login")
	public ResponseEntity<Person> userLogin(@RequestBody Person user ){
		return service.userLogin(user);
	}
	
	
	@PostMapping("/register")
	public Person newUser(@RequestBody Person user) {
		return service.newUser(user);
	}
	
	
	@PutMapping("{id}/todos")
	public Person updateUser(@RequestBody Person user,@PathVariable Long id ) {
		return service.updateUser(user, id);
	}
	
	
	@DeleteMapping("{id}/todos")
	public void deleteUser(@PathVariable Long id) {
		 service.deleteUser(id);
	}
	
	@PostMapping("/{id}/todos")
	public void addTodo(@RequestBody  Todo work, @PathVariable Long id) {
		 service.addTodo(work, id);
	}
	
	@GetMapping("/{id}/todos")
	public  List<Todo> getWorks(@PathVariable Long id) {
		 return service.getWorks(id);
	}
	
	@PostMapping("/{id}/todos/{wid}")
	public void todoCompleted(@PathVariable Long id,@PathVariable Long wid) {
		service.todoCompleted(id,wid);
	}
	
	@DeleteMapping("{id}/todos/{wid}")
	public void deleteTodo(@PathVariable Long id, @PathVariable Long wid) {
		service.deleteTodo(id,wid);
	}
	
	
}
