package com.claim.dto;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonSetter;

public class Business {

	private String id;
	private String name;
	private String imageUrl;
	private String url;
	private String rating;
	private Location location;
	private String[] photos;
	private Review[] reviews;
	
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@JsonGetter("imageUrl")
	public String getImageUrl() {
		return imageUrl;
	}
	
	@JsonSetter("image_url")
	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getRating() {
		return rating;
	}
	public void setRating(String rating) {
		this.rating = rating;
	}
	public Location getLocation() {
		return location;
	}
	public void setLocation(Location location) {
		this.location = location;
	}
	public String[] getPhotos() {
		return photos;
	}
	public void setPhotos(String[] photos) {
		this.photos = photos;
	}
	public Review[] getReviews() {
		return reviews;
	}
	public void setReviews(Review[] reviews) {
		this.reviews = reviews;
	}

	public void setReviewsFromResponse(YelpReviewResponse reviews) {
		setReviews(reviews.getReviews());
	}
	
}
