package com.gocahum.store.serviceproduct;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.gocahum.store.serviceproduct.entity.Category;
import com.gocahum.store.serviceproduct.entity.Product;
import com.gocahum.store.serviceproduct.repository.ProductRepository;

@DataJpaTest
public class ProductReposirotyMockTest {
	@Autowired
	private ProductRepository productRepository;
	
	@Test
	public void whenFindBayCategory_thenResultListProduct() {
		Product product1 = Product.builder()
				.name("producto1")
				.category(Category.builder().id(1L).build())
				.description("")
				.stock(10d)
				.price(1240.99)
				.creatAt(new Date())
				.build();
		productRepository.save(product1);
		
		List<Product> founds = productRepository.findByCategory(product1.getCategory());
		assertThat(founds.size()).isEqualTo(3);
	}

}
