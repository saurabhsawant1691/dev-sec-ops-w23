package org.dnyanyog.dto;

import org.springframework.stereotype.Component;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;



@Component
public class AddCustomerRequest {
	
	@NotNull(message = "First name is mandatory")
	@NotBlank(message = "First name should not be blank")
	private String firstName;
	
	@NotNull(message = "Last name is mandatory")
	@NotBlank(message = "Last name should not be blank")
	private String lastName;
	
	@Email(message = "Invalid Email Format")
	@NotNull(message = "Email is mandatory")
	@NotBlank(message = "Email should not be blank")
	private String email;
	
	@Min(value = 10, message = "Minimum digits should be 10")
	@Max(value = 12, message = "Maximum digits should be 12")
	private String phoneNumber;
	
	@NotNull(message = "Address is mandatory")
	private String address;
	
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
}
