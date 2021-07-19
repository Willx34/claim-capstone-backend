package com.claim.service;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.claim.dto.Business;
import com.claim.dto.YelpResponse;
import com.claim.dto.YelpReviewResponse;

@Service
public class YelpData {
	
	RestTemplate restTemplate = new RestTemplate();
	
	public YelpResponse search(String searchTerm, String location) {
		
		String url = "https://api.yelp.com/v3/businesses/search";
		
		searchTerm = searchTerm.replaceAll("\\s+","+");
		location = location.replaceAll("\\s+","+");
		
		UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(url)
		        .queryParam("categories", "food")
		        .queryParam("term", searchTerm)
		        .queryParam("location", location)
		        .queryParam("limit", 21);
		
		HttpHeaders headers = new HttpHeaders();
		headers.set("Authorization", ""); //insert API key here
		HttpEntity request = new HttpEntity(headers);
		
		System.out.println(builder.toUriString());
		
		return restTemplate.exchange(builder.toUriString(), HttpMethod.GET, request, YelpResponse.class).getBody();
	}
	
	public Business searchById(String id) {
		
		String url = "https://api.yelp.com/v3/businesses/" + id;
				
		HttpHeaders headers = new HttpHeaders();
		headers.set("Authorization", "Bearer YIS7aqXTgIsBRx2xezXTi79ysjcqUDy3gl7nkHHng_0HarNGJpR_HREzpcv7l5ije8A5cjw0Pt66jcCO5iH40L6bKzqWBnhwVP4t_IKSc4xw5dxQn2BZS9_sG4zGYHYx");
		HttpEntity request = new HttpEntity(headers);
		
		return restTemplate.exchange(url, HttpMethod.GET, request, Business.class).getBody();
	}
	
	public YelpReviewResponse reviews(String id) {
		
		String url = "https://api.yelp.com/v3/businesses/" + id + "/reviews";
				
		HttpHeaders headers = new HttpHeaders();
		headers.set("Authorization", "Bearer YIS7aqXTgIsBRx2xezXTi79ysjcqUDy3gl7nkHHng_0HarNGJpR_HREzpcv7l5ije8A5cjw0Pt66jcCO5iH40L6bKzqWBnhwVP4t_IKSc4xw5dxQn2BZS9_sG4zGYHYx");
		HttpEntity request = new HttpEntity(headers);
		
		return restTemplate.exchange(url, HttpMethod.GET, request, YelpReviewResponse.class).getBody();
	}
	
}
