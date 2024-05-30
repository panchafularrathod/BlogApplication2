package com.mock.BlogApplication.service.impl;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mock.BlogApplication.dto.UserDto;
import com.mock.BlogApplication.entities.User;
import com.mock.BlogApplication.exception.UserNotFoundException;
import com.mock.BlogApplication.repository.UserRepository;
import com.mock.BlogApplication.service.UserSrevice;
import com.mock.BlogApplication.utility.UserUtility;

@Service
public class UserSreviceImpl implements UserSrevice {
	
	@Autowired
	private UserRepository userRepository;

	@Override
	public UserDto createUser(UserDto userDto) {
		User dtoToUser = UserUtility.convertDtoToUser(userDto);
		dtoToUser.setUserId(UUID.randomUUID().toString());
		String pwd = userDto.getPassword();
		dtoToUser.setPassword(UUID.fromString(pwd).toString());
		
		User user = this.userRepository.save(dtoToUser);
		
		return UserUtility.convertUserToDto(user);

	}

	@Override
	public UserDto updateUser(UserDto userDto, String userId) {
	
		User user =this.userRepository.findById(userId).orElseThrow(()->new UserNotFoundException("User Not found for given User Id : "+ userId));
		user.setPassword(userDto.getPassword());
		user.setGender(userDto.getGender());
		user.setAge(userDto.getAge());
		User user2 = this.userRepository.save(user);
		return UserUtility.convertUserToDto(user2);
	}

	@Override
	public List<UserDto> getAllUsers() {
		
		List<User> allUsers = this.userRepository.findAll();
		return allUsers.stream().map(user-> UserUtility.convertUserToDto(user)).collect(Collectors.toList());
		
		
	}

	@Override
	public void deleteUser(String userId) {
		
		this.userRepository.deleteById(userId);
		
	}

	@Override
	public UserDto getUserByEmail(String email) {
		
		User userByEmail = this.userRepository.findByUserEmail(email).orElseThrow(()->new UserNotFoundException("User not found for given User ID : "+email));
		return UserUtility.convertUserToDto(userByEmail);
	}

}
