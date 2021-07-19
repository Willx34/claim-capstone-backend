package com.claim.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
@Table(name="event")
@JsonIdentityInfo (generator = ObjectIdGenerators.PropertyGenerator.class, 
property = "eventId")
public class Event {
	
	@Id
	@Column(name="event_id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer eventId;

	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="created_by")
	private User createdBy;
	
	@Column(name="business_id")
	private String businessId;
	
	@Column(name="scheduled_date")
	private String scheduledDate;
	
	@Column(name="rating")
	private String rating;
	
	@Column(name="attendee_count")
	private Integer attendeeCount;
	

	@OneToMany(cascade=CascadeType.ALL,orphanRemoval = true)
	@JoinColumn(name="post_id")
	private List<EventPost> posts = new ArrayList<EventPost>();

	public Integer getAttendeeCount() {
		return attendeeCount;
	}

	public void setAttendeeCount(Integer attendeeCount) {
		this.attendeeCount = attendeeCount;
	}	
	
	public List<EventPost> getPosts() {
		return posts;
	}

	public void setPosts(List<EventPost> posts) {
		this.posts = posts;
	}

	public Integer getEventId() {
		return eventId;
	}

	public void setEventId(Integer eventId) {
		this.eventId = eventId;
	}	
	
	public User getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(User createdBy) {
		this.createdBy = createdBy;
	}

	public String getBusinessId() {
		return businessId;
	}

	public void setBusinessId(String businessId) {
		this.businessId = businessId;
	}

	public String getScheduledDate() {
		return scheduledDate;
	}

	public void setScheduledDate(String scheduledDate) {
		this.scheduledDate = scheduledDate;
	}

	public String getRating() {
		return rating;
	}

	public void setRating(String rating) {
		this.rating = rating;
	}




	
	
	
}
