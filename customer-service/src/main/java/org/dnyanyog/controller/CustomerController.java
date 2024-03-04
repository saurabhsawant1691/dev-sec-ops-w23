package org.dnyanyog.controller;

import java.util.List;


import org.dnyanyog.dto.AddCustomerRequest;
import org.dnyanyog.dto.AddCustomerResponse;
import org.dnyanyog.dto.DeleteCustomerResponse;
import org.dnyanyog.dto.DiscountRequest;
import org.dnyanyog.dto.DiscountResponse;
import org.dnyanyog.dto.GetCustomerResponse;
import org.dnyanyog.dto.UpdateCustomerRequest;
import org.dnyanyog.dto.UpdateCustomerResponse;
import org.dnyanyog.entity.Customer;
import org.dnyanyog.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;

@RestController
public class CustomerController {

	@Autowired
	CustomerService customerService;
	
	@GetMapping(path = "/api/v1/customer/getAllCustomers")
	public List<Customer> getAllCustomers(){
		
		return customerService.getAllCustomers();
	}
	
	@GetMapping(path = "/api/v1/customer/getCustomer/{customerId}")
	public GetCustomerResponse getCustomer(@PathVariable long customerId) {
		
		return customerService.getCustomer(customerId);
	}
	
	@PostMapping(path = "/api/v1/customer/addCustomer", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE}, consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
	public AddCustomerResponse addCustomer(@Valid @RequestBody AddCustomerRequest addCustomerRequest) {
		
		return customerService.addCustomer(addCustomerRequest);
	}
	
	@PostMapping(path = "/api/v1/customer/updateCustomer", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE}, consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
	public UpdateCustomerResponse updateCustomer(@Valid @RequestBody UpdateCustomerRequest updateCustomerRequest) {
		
		return customerService.updateCustomer(updateCustomerRequest);
	}
	
	@DeleteMapping(path = "/api/v1/customer/deleteCustomer/{customerId}")
	public DeleteCustomerResponse deleteCustomer(@PathVariable long customerId) {
		
		return customerService.deleteCustomer(customerId);
	}
	
	@PostMapping(path = "/api/v1/customer/getDiscount", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE}, consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
	public int getDiscount(@RequestBody DiscountRequest discountRequest) {
		
		return customerService.getDiscount(discountRequest); 
	}
}
