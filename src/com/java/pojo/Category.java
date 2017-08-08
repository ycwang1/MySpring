package com.java.pojo;

import org.springframework.stereotype.Component;
@Component("c")
public class Category {
	private int id=0;
	private String name="hello";
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
}
