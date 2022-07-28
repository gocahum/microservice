package com.gocahum.shopping.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.gocahum.shopping.model.Customer;

@FeignClient(name ="customer-service", path ="/customers", fallback = CustomerHystrixFallbackFactory.class)
//@RequestMapping("/customers")
public interface CustomerClient {
	
//	@GetMapping
//    public ResponseEntity<List<Customer>> listAllCustomers(@RequestParam(name = "regionId" , required = false) Long regionId );
	
    @GetMapping(value = "/{id}")
    public ResponseEntity<Customer> getCustomer(@PathVariable("id") long id);
    
//    @PostMapping
//    public ResponseEntity<?> createCustomer(@Valid @RequestBody Customer customer, BindingResult result);
//    
//    @PutMapping(value = "/{id}")
//    public ResponseEntity<?> updateCustomer(@PathVariable("id") long id, @RequestBody Customer customer);
//    
//    @DeleteMapping(value = "/{id}")
//    public ResponseEntity<Customer> deleteCustomer(@PathVariable("id") long id);

}
