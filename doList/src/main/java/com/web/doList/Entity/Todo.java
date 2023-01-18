package com.web.doList.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Todo {
	
	@Id  @GeneratedValue(strategy = GenerationType.AUTO)
	private Long wid;
	private String title;
	private boolean done = false;
	
	
	public Todo() {
		
	}
	public Todo(Long wid, String title, boolean done) {

		this.wid = wid;
		this.title = title;
		this.done = done;
	}
	public Long getId() {
		return wid;
	}
	public void setId(Long wid) {
		this.wid = wid;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public boolean isDone() {
		return done;
	}
	public void setDone(boolean done) {
		this.done = done;
	} 

}
