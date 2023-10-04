package project.samplejpa.project;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import project.samplejpa.project.entity.Product;
import project.samplejpa.project.service.ProductService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
class ProjectForJpaAndDatabaseApplicationTests {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private ProductService productService;



	@Test
	public void testGetAllProducts() throws Exception {
		List<Product> products = new ArrayList<>();
		products.add(new Product(1L, "Product 1", 10.0));
		products.add(new Product(2L, "Product 2", 15.0));

		when(productService.getAllProducts()).thenReturn(products);

		mockMvc.perform(get("/api/products"))
				.andExpect(status().isOk())
				.andExpect(content().contentType(MediaType.APPLICATION_JSON))
				.andExpect(jsonPath("$", hasSize(2)))  // Ensure there are two products in the response
				.andExpect(jsonPath("$[0].name").value("Product 1"))
				.andExpect(jsonPath("$[1].name").value("Product 2"));

		verify(productService, times(1)).getAllProducts();
	}


	@Test
	void contextLoads() {
		// This is an empty test method.
		// Spring Boot will automatically load the application context
		// and check if it can start without errors.
	}
}

