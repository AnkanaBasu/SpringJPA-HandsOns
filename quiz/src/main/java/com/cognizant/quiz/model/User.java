package com.cognizant.quiz.model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="user")
public class User {

	@Id
	@Column(name="us_id")
	Integer id;
	
	@Column(name="us_name")
	String name;
	
	@Column(name="us_email")
	String email;

	@OneToMany(mappedBy="user_id",fetch = FetchType.EAGER)
	Set<Attempt> attempt;
	
	
	
	
	
	public Set<Attempt> getAttempt() {
		return attempt;
	}

	public void setAttempt(Set<Attempt> attempt) {
		this.attempt = attempt;
	}

	public User() {
		super();
	}

	public User(Integer id, String name, String email) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", email=" + email + ", attempt=" + attempt + "]";
	}
	
	
	
	
}
