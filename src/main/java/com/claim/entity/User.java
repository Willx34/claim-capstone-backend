package com.claim.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;




@Entity
@Table(name="user")
public class User {

	@Column(name="first_name")
	private String firstName;
	
	@Column(name="last_name")
	private String lastName;
	
	@Id
	@Column(name="email")//@Column allows you to specify the column mapping
	private String email;
		
	@Column(name="telephone")
	private String telephone;
	
	
	@Column(name="pass")
	private String password;
	
	@OneToMany(cascade=CascadeType.ALL,orphanRemoval = true)
	@JoinColumn(name="event_id")
	private List<Event> events = new ArrayList<Event>();
	
	@OneToMany(cascade=CascadeType.ALL,orphanRemoval = true)
	@JoinColumn(name="post_id")
	private List<EventPost> posts = new ArrayList<EventPost>();
	
	public List<EventPost> getPosts() {
		return posts;
	}

	public void setPosts(List<EventPost> posts) {
		this.posts = posts;
	}

	public List<Event> getEvents() {
		return events;
	}

	public void setEvents(List<Event> events) {
		this.events = events;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}


	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}


	
	
}
