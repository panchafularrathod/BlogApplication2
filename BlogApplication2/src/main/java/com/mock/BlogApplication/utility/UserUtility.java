package com.mock.BlogApplication.utility;


import org.springframework.stereotype.Component;

import com.mock.BlogApplication.dto.UserDto;
import com.mock.BlogApplication.entities.User;

@Component
public class UserUtility {
	
	
	// convert userDto to user
	
	public static User convertDtoToUser(UserDto userDto) {
		return User.builder()
		.userName(userDto.getUserName())
		.userEmail(userDto.getUserEmail())
		.password(userDto.getPassword())
		.gender(userDto.getGender())
		.age(userDto.getAge())
		.salary(userDto.getSalary())
		.build();
		
	}
	
	// convert user to userDto 
	
		public static UserDto convertUserToDto(User user) {
			return UserDto.builder()
			.userName(user.getUserName())
			.userEmail(user.getUserEmail())
			.password(user.getPassword())
			.gender(user.getGender())
			.age(user.getAge())
			.salary(user.getSalary())
			.build();
			
		}

}
