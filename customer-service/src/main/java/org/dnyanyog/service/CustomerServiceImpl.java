package org.dnyanyog.service;

import java.util.List;

import org.dnyanyog.common.ResponseCodes;
import org.dnyanyog.dto.AddCustomerRequest;
import org.dnyanyog.dto.AddCustomerResponse;
import org.dnyanyog.dto.CustomerData;
import org.dnyanyog.dto.DeleteCustomerResponse;
import org.dnyanyog.dto.DiscountRequest;
import org.dnyanyog.dto.DiscountResponse;
import org.dnyanyog.dto.GetCustomerResponse;
import org.dnyanyog.dto.UpdateCustomerRequest;
import org.dnyanyog.dto.UpdateCustomerResponse;
import org.dnyanyog.entity.Customer;
import org.dnyanyog.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceImpl implements CustomerService{

	@Autowired
	CustomerRepository customerRepo;
	@Autowired
	Customer customer;
	@Autowired
	AddCustomerResponse addCustomerResponse;
	@Autowired
	UpdateCustomerResponse updateCustomerResponse;
	@Autowired
	GetCustomerResponse getCustomerResponse;
	@Autowired
	DeleteCustomerResponse deleteCustomerResponse;
	@Autowired
	DiscountResponse discountResponse;
	

	public AddCustomerResponse addCustomer(AddCustomerRequest addCustomerRequest) {
		
		addCustomerResponse = new AddCustomerResponse();
		addCustomerResponse.setCustomerData(new CustomerData());
		
//		customer = customerRepo.findByEmail(addCustomerRequest.getEmail());
		
		if (null != customerRepo.findByEmail(addCustomerRequest.getEmail())) {
			return getConflictDuplicateEmailResponse();
		}
		
		if (null != customerRepo.findByPhoneNumber(addCustomerRequest.getPhoneNumber())) {
			return getConflictDuplicatePhoneNumberResponse();
		}
		
		customer.setFirstName(addCustomerRequest.getFirstName());
		customer.setLastName(addCustomerRequest.getLastName());
		customer.setEmail(addCustomerRequest.getEmail());
		customer.setPhoneNumber(addCustomerRequest.getPhoneNumber());
		customer.setAddress(addCustomerRequest.getAddress());
		
		customer = customerRepo.save(customer);
		
		addCustomerResponse.setStatus(ResponseCodes.ADD_CUSTOMER_SUCCESS.getCode());
		addCustomerResponse.setMessage(ResponseCodes.ADD_CUSTOMER_SUCCESS.getMessage());
		addCustomerResponse.getCustomerData().setId(customer.getCustomerId());
		addCustomerResponse.getCustomerData().setFirstName(customer.getFirstName());
		addCustomerResponse.getCustomerData().setLastName(customer.getLastName());
		addCustomerResponse.getCustomerData().setEmail(customer.getEmail());
		addCustomerResponse.getCustomerData().setAddress(customer.getAddress());
		addCustomerResponse.getCustomerData().setPhoneNumber(customer.getPhoneNumber());
		
		return addCustomerResponse;
	}
	
	public List<Customer> getAllCustomers() {

		return customerRepo.findAll();
	}
	
	public GetCustomerResponse getCustomer(long customerId) {
		
		customer = customerRepo.findByCustomerId(customerId);
		
		if(null == customer) {
			return getConflictInvalidIdResponse();
		}
		
		customer = customerRepo.findByCustomerId(customerId);
		
		getCustomerResponse.setStatus(ResponseCodes.ADD_CUSTOMER_SUCCESS.getCode());
		getCustomerResponse.setStatus(ResponseCodes.ADD_CUSTOMER_SUCCESS.getMessage());
		getCustomerResponse.getCustomerData().setId(customer.getCustomerId());
		getCustomerResponse.getCustomerData().setFirstName(customer.getFirstName());
		getCustomerResponse.getCustomerData().setLastName(customer.getLastName());
		getCustomerResponse.getCustomerData().setEmail(customer.getEmail());
		getCustomerResponse.getCustomerData().setPhoneNumber(customer.getPhoneNumber());
		getCustomerResponse.getCustomerData().setAddress(customer.getAddress());

		return getCustomerResponse;
	}
	
	public UpdateCustomerResponse updateCustomer(UpdateCustomerRequest updateCustomerRequest) {

		updateCustomerResponse = new UpdateCustomerResponse();
		updateCustomerResponse.setCustomerData(new CustomerData());
		
		if (null == customerRepo.findByEmail(updateCustomerRequest.getEmail())) {
			return getConflictInvalidEmailResponse();
		}
		
		if (null == customerRepo.findByPhoneNumber(updateCustomerRequest.getPhoneNumber())) {
			return getConflictInvalidPhoneNumberResponse();
		}
		
		customer = customerRepo.findByEmail(updateCustomerRequest.getEmail());
		customer.setFirstName(updateCustomerRequest.getFirstName());
		customer.setLastName(updateCustomerRequest.getLastName());
		customer.setEmail(updateCustomerRequest.getEmail());
		customer.setPhoneNumber(updateCustomerRequest.getPhoneNumber());
		customer.setAddress(updateCustomerRequest.getAddress());
		
		customer = customerRepo.save(customer);

		updateCustomerResponse.setStatus(ResponseCodes.UPDATE_CUSTOMER_SUCCESS.getCode());
		updateCustomerResponse.setMessage(ResponseCodes.UPDATE_CUSTOMER_SUCCESS.getMessage());
		updateCustomerResponse.getCustomerData().setId(customer.getCustomerId());
		updateCustomerResponse.getCustomerData().setFirstName(customer.getFirstName());
		updateCustomerResponse.getCustomerData().setLastName(customer.getLastName());
		updateCustomerResponse.getCustomerData().setEmail(customer.getEmail());
		updateCustomerResponse.getCustomerData().setAddress(customer.getAddress());
		updateCustomerResponse.getCustomerData().setPhoneNumber(customer.getPhoneNumber());
		
		return updateCustomerResponse;
	}

	public DeleteCustomerResponse deleteCustomer(long customerId) {

		customer = customerRepo.findByCustomerId(customerId);
		
		if(null == customer) {
			return getConflictInvalidCustomerIdResponse();
		}
		
		customerRepo.deleteById(customerId);
		
		deleteCustomerResponse.setStatus(ResponseCodes.DELETE_CUSTOMER_SUCCESS.getCode());
		deleteCustomerResponse.setMessage(ResponseCodes.DELETE_CUSTOMER_SUCCESS.getMessage());
		
		return deleteCustomerResponse;
	}
	
	public int getDiscount(DiscountRequest discountRequest) {
		
		int discount = 0;
		
		if(discountRequest.getAge() < 30) {
			discount = 10;
		}
		if(discountRequest.getAge() >= 30 && discountRequest.getAge() < 60) {
			discount = 5;
		}
		if(discountRequest.getAge() >= 60) {
			discount = 15;
		}
		if(discountRequest.getGender().equalsIgnoreCase("F")) {
			discount = discount + 5;
		}
		
		return discount;
	}
	
	private AddCustomerResponse getConflictDuplicateEmailResponse() {
		AddCustomerResponse addCustomerResponse = new AddCustomerResponse();
		addCustomerResponse.setStatus(ResponseCodes.ADD_CUSTOMER_DUPLICATE_EMAIL.getCode());
		addCustomerResponse.setMessage(ResponseCodes.ADD_CUSTOMER_DUPLICATE_EMAIL.getMessage());
		
		return addCustomerResponse;
	}
	
	private AddCustomerResponse getConflictDuplicatePhoneNumberResponse() {
		AddCustomerResponse addCustomerResponse = new AddCustomerResponse();
		addCustomerResponse.setStatus(ResponseCodes.ADD_CUSTOMER_DUPLICATE_PHONE_NUMBER.getCode());
		addCustomerResponse.setMessage(ResponseCodes.ADD_CUSTOMER_DUPLICATE_PHONE_NUMBER.getMessage());
		return addCustomerResponse;
	}

	private UpdateCustomerResponse getConflictInvalidEmailResponse() {
		UpdateCustomerResponse updateCustomerResponse = new UpdateCustomerResponse();
		updateCustomerResponse.setStatus(ResponseCodes.UPDATE_CUSTOMER_NOT_FOUND_EMAIL.getCode());
		updateCustomerResponse.setMessage(ResponseCodes.UPDATE_CUSTOMER_NOT_FOUND_EMAIL.getMessage());
		
		return updateCustomerResponse;
	}
	
	private UpdateCustomerResponse getConflictInvalidPhoneNumberResponse() {
		UpdateCustomerResponse updateCustomerResponse = new UpdateCustomerResponse();
		updateCustomerResponse.setStatus(ResponseCodes.UPDATE_CUSTOMER_NOT_FOUND_PHONE_NUMBER.getCode());
		updateCustomerResponse.setMessage(ResponseCodes.UPDATE_CUSTOMER_NOT_FOUND_PHONE_NUMBER.getMessage());
		
		return updateCustomerResponse;
	}
	
	private GetCustomerResponse getConflictInvalidIdResponse() {
		GetCustomerResponse getCustomerResponse = new GetCustomerResponse();
		getCustomerResponse.setStatus(ResponseCodes.CUSTOMER_NOT_FOUND_CUSTOMER_ID.getCode());
		getCustomerResponse.setMessage(ResponseCodes.CUSTOMER_NOT_FOUND_CUSTOMER_ID.getMessage());
		
		return getCustomerResponse;
	}
	
	private DeleteCustomerResponse getConflictInvalidCustomerIdResponse() {
		DeleteCustomerResponse deleteCustomerResponse = new DeleteCustomerResponse();
		deleteCustomerResponse.setStatus(ResponseCodes.CUSTOMER_NOT_FOUND_CUSTOMER_ID.getCode());
		deleteCustomerResponse.setMessage(ResponseCodes.CUSTOMER_NOT_FOUND_CUSTOMER_ID.getMessage());
		
		return deleteCustomerResponse;
	}
}
 