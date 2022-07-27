package com.gocahum.store.serviceproduct;

import java.util.Optional;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import com.gocahum.store.serviceproduct.entity.Category;
import com.gocahum.store.serviceproduct.entity.Product;
import com.gocahum.store.serviceproduct.repository.ProductRepository;
import com.gocahum.store.serviceproduct.service.ProductService;
import com.gocahum.store.serviceproduct.service.ProductServiceImpl;

@SpringBootTest
public class ProductserviceMockTest {
	@Mock
	private ProductRepository productRepository;
	
	private ProductService productService;
	
	@BeforeEach
	public void setup() {
		MockitoAnnotations.initMocks(this);
		productService = new ProductServiceImpl(productRepository);
		Product computer = Product.builder()
				.id(1L)
				.name("Computer")
				.category(Category.builder().id(1L).build())
				.price(12.5)
				.stock(5d)
				.build();
		Mockito.when(productRepository.findById(1L))
		.thenReturn(Optional.of(computer));
	}
	
	@Test
	public void whenValidGetIdThenReturnProduct() {
		Product found = productService.getProduct(1L);
		Assertions.assertThat(found.getName()).isEqualTo("Computer");
	}

}
