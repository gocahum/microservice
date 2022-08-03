package com.gocahum.store.serviceproduct.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gocahum.store.serviceproduct.entity.Category;
import com.gocahum.store.serviceproduct.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Long>{
	
	public List<Product> findByCategory(Category category);

}
