package com.claim.entity;

public class DataTransferObject {

	
	private String message;
	private String name;
	
	public DataTransferObject() {
		
	}
	
	public DataTransferObject(String name, String message) {
		this.message = message;	
		this.name = name;
	}
	
	public String getMessage() {
		return message;		
	}
	
	public String getName() {
		return name;		
	}
	
	
}
