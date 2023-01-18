package com.web.doList.Service;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.web.doList.Entity.Person;
import com.web.doList.Entity.Todo;
import com.web.doList.Repository.TodoRepository;
import com.web.doList.Repository.UserRepository;




@Service
public class ServiceImplements implements UserService {
	
	@Autowired 
	private UserRepository userRep;
	
	@Autowired 
	private TodoRepository todoRep;
	

	@Override
	public ResponseEntity<Person> userLogin(Person user) {
		System.out.println(user);
		Person user1 = userRep.findByName(user.getName());
		if(user1.getPassword().equals(user.getPassword())) {
			return ResponseEntity.ok(user1);
		}
		return (ResponseEntity<Person>) ResponseEntity.internalServerError();
		
	}

	@Override
	public void addTodo(Todo work,Long id) {
		Person user = userRep.findById(id).orElseThrow(()-> new NoSuchElementException());
		Todo work1 = new Todo();
		
		work1.setTitle(work.getTitle());
		user.getWork().add(work1);
		
		todoRep.save(work1);
		userRep.save(user);
	}
	
	@Override
	public Person updateUser(Person user, Long id) {
		Person user1 = userRep.findById(id).orElseThrow(()-> new NoSuchElementException());
		user1.setName(user.getName());
		user1.setEmail(user.getEmail());
		return userRep.save(user1);
	}
	
	@Override
	public List<Todo> getWorks(Long id) {
		Person user = userRep.findById(id).orElseThrow(()-> new NoSuchElementException());
		return user.getWork();
	}
	
	@Override
	public void todoCompleted(Long id,Long wid) {
		Todo work = todoRep.findById(wid).orElseThrow(()-> new NoSuchElementException());
		work.setDone(!work.isDone());
		todoRep.save(work);
	}
	
	@Override
	public void deleteTodo(Long id, Long wid) {
		Todo todo = todoRep.findById(wid).orElseThrow(()-> new NoSuchElementException());
		Person user = userRep.findById(id).orElseThrow(()-> new NoSuchElementException());
		user.getWork().remove(todo);
		todoRep.delete(todo);

	}
	
	@Override
	public void deleteUser(Long id) {
		Person user = userRep.findById(id).orElseThrow(()-> new NoSuchElementException());
		userRep.delete(user);
	}

	@Override
	public Person newUser(Person user) {
		Person user1 = new Person();
		user1.setName(user.getName());
		user1.setPassword(user.getPassword());
		user1.setEmail(user.getEmail());
		user1.setGender(user.getGender());
		return userRep.save(user1);
	}

	
	

}
