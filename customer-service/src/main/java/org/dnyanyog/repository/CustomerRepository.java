
package org.dnyanyog.repository;

import org.dnyanyog.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long>{

	Customer findByCustomerId(long customerId);
	Customer findByEmail(String email);
	Customer findByPhoneNumber(String phoneNumber);

}
