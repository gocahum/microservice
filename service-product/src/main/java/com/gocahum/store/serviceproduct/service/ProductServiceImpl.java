package com.gocahum.store.serviceproduct.service;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import com.gocahum.store.serviceproduct.entity.Category;
import com.gocahum.store.serviceproduct.entity.Product;
import com.gocahum.store.serviceproduct.repository.ProductRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ProductServiceImpl implements ProductService {
	
	private final ProductRepository productRepository;

	@Override
	public List<Product> listAllProduct() {
		// TODO Auto-generated method stub
		return productRepository.findAll();
	}

	@Override
	public Product getProduct(Long id) {
		// TODO Auto-generated method stub
		return productRepository.findById(id).orElse(null);
	}

	@Override
	public Product createProduct(Product product) {
		product.setStatus("CREATED");
		product.setCreatAt(new Date());
		return productRepository.save(product);
	}

	@Override
	public Product updateProduct(Product product) {
		Product productDB = getProduct(product.getId());
		if(null == productDB) {
			return null;
		}
		productDB.setName(product.getName());
		product.setDescription(product.getDescription());
		productDB.setCategory(product.getCategory());
		productDB.setPrice(product.getPrice());
		return productRepository.save(productDB);
	}

	@Override
	public Product deleteProduct(Long id) {
		Product productDB = getProduct(id);
		if(null == productDB) {
			return null;
		}
		productDB.setStatus("DELETED");
		return productRepository.save(productDB);
	}

	@Override
	public List<Product> findByCategory(Category category) {
		// TODO Auto-generated method stub
		return productRepository.findByCategory(category);
	}

	@Override
	public Product updateStock(Long id, double quantity) {
		Product productDB = getProduct(id);
		if(null == productDB) {
			return null;
		}
		productDB.setStock(quantity);
		return productRepository.save(productDB);
	}

}
