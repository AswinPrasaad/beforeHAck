package com.springboot.curd.FirstDemo.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;
@Entity
@Table(name = "users", schema = "team3") 
public class User {

	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	
	private int userId;
	@NotEmpty(message="Should not be empty")
	private String userName;
	//@NotNull
	private String address;
    @Override
	public String toString() {
		return "User [userId=" + userId + ", userName=" + userName + ", address=" + address + ", password=" + password
				+ "]";
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}


	//@NotNull
	@NotEmpty(message="Should not be empty")
	private String password;
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
}
