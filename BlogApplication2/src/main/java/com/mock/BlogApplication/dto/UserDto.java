package com.mock.BlogApplication.dto;

import com.mock.BlogApplication.entities.User;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Builder

public class UserDto {
	
	
	@NotBlank(message = "User name field is mandatory")
	private String userName;
	@NotBlank(message = "User email field is mandatory")
	private String userEmail;
	@NotBlank(message = "User password field is mandatory")
	private String password;
	@NotBlank(message = "User gender field is mandatory")
	private String gender;
	@NotBlank(message = "User age field is mandatory")
	private Integer age;
	
	private Double salary;

}
