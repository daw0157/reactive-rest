package dw.reactive.rest.controller;

import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.Test;
import org.mockito.BDDMockito;
import org.mockito.Mockito;
import org.springframework.test.web.reactive.server.WebTestClient;

import dw.reactive.rest.model.Category;
import dw.reactive.rest.repository.CategoryRepository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class CategoryControllerTest {

	WebTestClient webTestClient;
	
	CategoryRepository categoryRepository;
	
	CategoryController categoryController;
	
	@Before
	public void setUp() {
		categoryRepository = Mockito.mock(CategoryRepository.class);
		categoryController = new CategoryController(categoryRepository);
		webTestClient = WebTestClient.bindToController(categoryController).build();
	}
	
	@Test
	public void testList() {
		Category cat = new Category();
		cat.setDescription("cat1");
		Category cat2 = new Category();
		cat2.setDescription("cat2");
		BDDMockito.given(categoryRepository.findAll())
			.willReturn(Flux.just(cat, cat2));
		
		webTestClient.get().uri("/api/v1/categories")
			.exchange()
			.expectBodyList(Category.class)
			.hasSize(2);
			
	}

	@Test
	public void testGetById() {
		Category cat = new Category();
		cat.setId("id");
		cat.setDescription("test");
		
		BDDMockito.given(categoryRepository.findById("id"))
			.willReturn(Mono.just(cat));
		
		webTestClient.get().uri("/api/v1/categories/someid")
		.exchange()
		.expectBody(Category.class);
	}

}
