package com.mockathon.modelPojo;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.validator.constraints.NotEmpty;

public class Users {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int userId;
	
	@NotEmpty(message="Should not be empty")
	private String userName;
	
	@NotEmpty(message="Should not be empty")
	private String address;
    

	
	@NotEmpty(message="Should not be empty")
	private String password;
	
	@NotEmpty(message="Should not be empty")
	private String mailId;
	
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

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getMailId() {
		return mailId;
	}

	public void setMailId(String mailId) {
		this.mailId = mailId;
	}

	public Users() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Users [userId=" + userId + ", userName=" + userName + ", address=" + address + ", password=" + password
				+ ", mailId=" + mailId + "]";
	}

	public Users(int userId, String userName, String address, String password, String mailId) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.address = address;
		this.password = password;
		this.mailId = mailId;
	}

	
	
}
