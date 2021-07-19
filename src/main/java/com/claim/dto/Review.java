package com.claim.dto;

import com.fasterxml.jackson.annotation.JsonSetter;

public class Review {

	private String id;
	private String text;
	private String rating;
	private ReviewUser user;
	private String timeCreated;
	
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public String getRating() {
		return rating;
	}
	public void setRating(String rating) {
		this.rating = rating;
	}
	public ReviewUser getUser() {
		return user;
	}
	public void setUser(ReviewUser user) {
		this.user = user;
	}
	@JsonSetter("timeCreated")
	public String getTimeCreated() {
		return timeCreated;
	}
	@JsonSetter("time_created")
	public void setTimeCreated(String timeCreated) {
		this.timeCreated = timeCreated;
	}
	
	
	
}
