package com.ayush.collections.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.*;

@Entity
@Table(name="user_info")
public class UserInfo {
	
	@Id
	@Column(name="username",length=20,nullable=false)
	private String username;
	
	@Column(name="password",length=100,nullable=false)
	private String password;
	
	@Column(name="role",length=20)
	private String role;
	
	@Column(name="full_name",length=50)
	private String fullName;
	
	@Column(name="country",length=50)
	private String country;
	
	@Column(name="enabled")
	private short enabled;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public short getEnabled() {
		return enabled;
	}

	public void setEnabled(short enabled) {
		this.enabled = enabled;
	}

	public UserInfo(String username, String password, String role, String fullName, String country, short enabled) {
		super();
		this.username = username;
		this.password = password;
		this.role = role;
		this.fullName = fullName;
		this.country = country;
		this.enabled = enabled;
	}
	
	public UserInfo() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "UserInfo [username=" + username + ", password=" + password + ", role=" + role + ", fullName=" + fullName
				+ ", country=" + country + ", enabled=" + enabled + "]";
	}
	
	 
	
	
}
