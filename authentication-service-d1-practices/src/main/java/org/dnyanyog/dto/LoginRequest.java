package org.dnyanyog.dto;

import org.springframework.stereotype.Component;

import jakarta.validation.constraints.Pattern;

@Component
public class LoginRequest { // DTO => Data Transfer Object
							// View
	private String username="Admin";
	@Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*[@_\\-]).{8,}$",
	        message = "Invalid password")
	private String password="Admin123";

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
