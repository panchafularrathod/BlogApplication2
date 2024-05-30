package com.mock.BlogApplication.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mock.BlogApplication.dto.UserDto;
import com.mock.BlogApplication.service.UserSrevice;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/users")
public class UserController {
	
	@Autowired
	private UserSrevice userSrevice;
	
	
	
	@PostMapping("/")
	public ResponseEntity<UserDto> createUser(
		@Valid
		@RequestBody UserDto userDto) {
		
		return new ResponseEntity<UserDto>(this.userSrevice.createUser(userDto) ,HttpStatus.CREATED);	
	}
	
	@PutMapping("/userId/{userId}")
	public  ResponseEntity<UserDto> updateUser(
			@Valid
			@RequestBody UserDto userDto,
			@PathVariable String userId){
	
	return new ResponseEntity<>(this.userSrevice.updateUser(userDto, userId),HttpStatus.OK);

}
	@GetMapping("/")
	public ResponseEntity<List<UserDto>> getAllUsers(){
		
		return new ResponseEntity<>(this.userSrevice.getAllUsers(),HttpStatus.OK);
	
	}
	
	@DeleteMapping("/userId/{userId}")
	public ResponseEntity<?> deleteUser(
			@PathVariable String userId) {
		return ResponseEntity.ok(HttpStatus.OK);
		
	}
	
	@GetMapping("/email/{email}")	
	public ResponseEntity<UserDto> getUserByEmail(
			@PathVariable String email) {

		return new ResponseEntity<UserDto>(this.userSrevice.getUserByEmail(email),HttpStatus.OK);
		 
	 }


}
