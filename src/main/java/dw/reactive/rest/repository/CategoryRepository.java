package dw.reactive.rest.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import dw.reactive.rest.model.Category;

public interface CategoryRepository extends ReactiveMongoRepository<Category, String>{
	
}
