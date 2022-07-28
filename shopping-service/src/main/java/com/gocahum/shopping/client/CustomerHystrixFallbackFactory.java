package com.gocahum.shopping.client;

import org.springframework.http.ResponseEntity;

import com.gocahum.shopping.model.Customer;

public class CustomerHystrixFallbackFactory implements CustomerClient{

	@Override
	public ResponseEntity<Customer> getCustomer(long id) {
		Customer customer = Customer.builder()
				.firstName("none")
				.lastName("none")
				.email("none")
				.photoUrl("none")
				.build();
		return ResponseEntity.ok(customer);
	}

}
