package com.oocl.genesys.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name="GS_USERS")
public class User {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
	
	@NotNull
    @Size(min=3, max=20)
    @Column(name = "USERNAME", nullable = false)
    private String username;
    
	@NotNull
    @Size(min=3, max=20)
    @Column(name = "PASSWORD", nullable = false)
    private String password;
	
	@NotNull
    @Column(name = "ROLE", nullable = false)
    private int role;
	
	@NotNull
    @Size(min=3, max=30)
    @Column(name = "EMAIL", nullable = false)
    private String email;
    
	@NotNull
    @Size(min=1, max=30)
    @Column(name = "FIRST_NAME", nullable = false)
    private String first_name;
	
	@NotNull
    @Size(min=1, max=30)
    @Column(name = "LAST_NAME", nullable = false)
    private String last_name;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

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

	public int getRole() {
		return role;
	}

	public void setRole(int role) {
		this.role = role;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFirst_name() {
		return first_name;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}
	
	
    
}
