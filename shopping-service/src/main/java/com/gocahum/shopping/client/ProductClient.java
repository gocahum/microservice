package com.gocahum.shopping.client;

import java.util.List;

import javax.validation.Valid;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.gocahum.shopping.model.Product;


@FeignClient(name ="product-service", path ="/products")
//@RequestMapping("/products")
public interface ProductClient {

//	@GetMapping
//	public ResponseEntity<List<Product>> listProduct(@RequestParam (name ="categoryId", required = false ) Long categoryId);
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Product> getProduct(@PathVariable("id") Long id);
	
//	@PostMapping
//	public ResponseEntity<Product> createProduct(@Valid @RequestBody Product product, BindingResult result);
	
//	@PutMapping("/{id}")
//	public ResponseEntity<Product> updateProduct (@PathVariable("id") Long id, @RequestBody Product product);
	
	@GetMapping(value = "/{id}/{stock}")
	public ResponseEntity<Product> updateStockProduct (@PathVariable Long id, @RequestParam(name="quantity", required = true) double quantity);
	
//	@DeleteMapping(value = "/{id}")
//	public ResponseEntity<Product> deleteProduct(@PathVariable("id") Long id);
//	
	
	
	
}
