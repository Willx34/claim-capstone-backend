package com.claim.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.claim.entity.User;
import com.claim.repository.UserRepository;

@CrossOrigin
@RestController
public class UserController {

	@Autowired
	private UserRepository userRepository;
	

	@RequestMapping(value="/save",
			consumes = MediaType.APPLICATION_JSON_VALUE,
			method= RequestMethod.POST
			)
	public void submitStudentDetails(@RequestBody User user) {
		this.userRepository.save(user);
		
	}
	
	@RequestMapping(value = "/findUserByEmail", 
			produces = MediaType.APPLICATION_JSON_VALUE,
			method= RequestMethod.GET
			)
	public ResponseEntity<Optional<User>> findById(String email) {
		
		Optional<User> student = this.userRepository.findById(email);
		
		return new ResponseEntity<Optional<User>>(student, HttpStatus.OK);
			}
	
	@RequestMapping(value = "/login", 
			consumes = MediaType.APPLICATION_JSON_VALUE,
			method= RequestMethod.POST
			)
	public ResponseEntity<Optional<User>> login(@RequestBody User userRequest) {
		
		Optional<User> user = this.userRepository.findUserByEmailAndPassword(userRequest.getEmail(), userRequest.getPassword());
		
		if (user.isPresent()) {
			return new ResponseEntity<Optional<User>>(user, HttpStatus.OK);
		} 
		
			return new ResponseEntity<Optional<User>>(HttpStatus.UNAUTHORIZED);
	
			}
	

	
}
