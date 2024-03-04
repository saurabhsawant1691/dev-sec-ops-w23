package org.dnyanyog.service;

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

public interface CustomerService {
	
	public AddCustomerResponse addCustomer(AddCustomerRequest addCusstomerRequest);
	
	public List<Customer> getAllCustomers();
	
	public UpdateCustomerResponse updateCustomer(UpdateCustomerRequest updateCustomerRequest);
	
	public GetCustomerResponse getCustomer(long customerId);
	
	public DeleteCustomerResponse deleteCustomer(long customerId);
	
	public int getDiscount(DiscountRequest discountRequest);
}
