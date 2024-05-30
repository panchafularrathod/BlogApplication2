package com.mock.BlogApplication.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Builder
@Table(name = "user_tab")
public class User {
	@Id
	@Column(name = "user-id")
	private String userId;
	@Column(name = "user_name")
	private String userName;
	@Column(name = "user_email")
	private String userEmail;
	@Column(name = "user_password")
	private String password;
	@Column(name = "user_gender")
	private String gender;
	@Column(name = "user_age")
	private Integer age;
	@Column(name = "user_salary")
	private Double salary;
	

}
