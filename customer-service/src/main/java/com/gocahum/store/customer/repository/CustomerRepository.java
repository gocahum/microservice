package com.gocahum.store.customer.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gocahum.store.customer.entity.Customer;
import com.gocahum.store.customer.entity.Region;

public interface CustomerRepository extends JpaRepository<Customer, Long>{
	
	public Customer findByNumberID(String numberId);
	
	public List<Customer> findByLastName(String lastName);
	
	public List<Customer> findByRegion(Region region);

}
