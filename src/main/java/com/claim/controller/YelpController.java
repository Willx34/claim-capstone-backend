package com.claim.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.claim.dto.Business;
import com.claim.dto.YelpResponse;
import com.claim.service.YelpData;

@CrossOrigin
@RestController
public class YelpController {

	@Autowired
	private YelpData yelpData;
	
	
	@RequestMapping(value = "/search", method= RequestMethod.GET)
	public ResponseEntity<YelpResponse> search(String searchTerm, String location) {
		
		
		return new ResponseEntity<YelpResponse>(yelpData.search(searchTerm, location),HttpStatus.OK);
		
	}
	
	@RequestMapping(value = "/searchById", method= RequestMethod.GET)
	public ResponseEntity<Business> searchById(String id) {
	
		System.out.println("Searching for: " + id);
		
		Business business = yelpData.searchById(id);
		business.setReviewsFromResponse(yelpData.reviews(id));
				
		return new ResponseEntity<Business>(business,HttpStatus.OK);
		
	}
	
	@RequestMapping(value = "/searchByIdInternal",
			consumes = MediaType.APPLICATION_JSON_VALUE,
			method= RequestMethod.POST)
	public ResponseEntity<Business> searchByIdInternal(@RequestBody Business business) {
		
		System.out.println("Searching for: " + business.getId());
		
		business = yelpData.searchById(business.getId());
		business.setReviewsFromResponse(yelpData.reviews(business.getId()));
				
		return new ResponseEntity<Business>(business,HttpStatus.OK);
		
	}
		
}
