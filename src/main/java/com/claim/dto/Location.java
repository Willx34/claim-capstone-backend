package com.claim.dto;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonSetter;

public class Location {
	
	private String[] displayAddress;

	@JsonGetter("displayAddress")
	public String[] getDisplayAddress() {
		return displayAddress;
	}
	
	@JsonSetter("display_address")
	public void setDisplayAddress(String[] displayAddress) {
		this.displayAddress = displayAddress;
	}
}
