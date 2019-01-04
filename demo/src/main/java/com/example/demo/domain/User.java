package com.example.demo.domain;

import java.io.Serializable;

public class User implements Serializable{
	private int age;
	private int id;
	private String account;
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	@Override
	public String toString() {
		return "User [age=" + age + ", id=" + id + ", account=" + account + "]";
	}
	
	
	
}
