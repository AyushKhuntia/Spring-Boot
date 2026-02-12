package com.ayush.ticketbooking.model;

import javax.persistence.*;
import java.util.Set;
@Entity
@Table(name = "user_security")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "userid")
	private int userid;
	
	@Column(name="email")
	private String email;
	
	@Column(name="name")
	private String name;
	
	@Column(name="password")
	private String password;
	
	@Column(name = "activy")
	private int active;
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinTable(name = "user_role", 
	           joinColumns = @JoinColumn(name = "userid"), 
	           inverseJoinColumns = @JoinColumn(name = "role_id"))
	private Set<Role> role;

	public int getUserid() {
		return userid;
	}

	public void setUserid(int userid) {
		this.userid = userid;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getActive() {
		return active;
	}

	public void setActive(int active) {
		this.active = active;
	}

	public Set<Role> getRole() {
		return role;
	}

	public void setRole(Set<Role> role) {
		this.role = role;
	}

	public User(int userid, String email, String name, int active, Set<Role> role) {
		super();
		this.userid = userid;
		this.email = email;
		this.name = name;
		this.active = active;
		this.role = role;
	}
	
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "User [userid=" + userid + ", email=" + email + ", name=" + name + ", active=" + active + ", role="
				+ role + "]";
	}
	
	
	
	
}
