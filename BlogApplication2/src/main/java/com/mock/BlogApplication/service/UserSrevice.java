package com.mock.BlogApplication.service;


import java.util.List;

import org.springframework.stereotype.Service;

import com.mock.BlogApplication.dto.UserDto;

@Service
public interface UserSrevice  {
	
	// create user 
	
	UserDto createUser(UserDto userDto);
	
	// update user by using user_id
	UserDto updateUser(UserDto userDto,String userId);
	
	//  get all user 
	List<UserDto> getAllUsers();
	
	// delete user by using user_id
	
	 void deleteUser(String userId);
	
	// get user by using user_email
	 
	 UserDto getUserByEmail(String email);
	 

}
