package dw.reactive.rest.bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import dw.reactive.rest.model.Category;
import dw.reactive.rest.model.Vendor;
import dw.reactive.rest.repository.CategoryRepository;
import dw.reactive.rest.repository.VendorRepository;

@Component
public class Bootstrap implements CommandLineRunner {

	CategoryRepository categoryRepository;
	
	VendorRepository vendorRepository;
	
	public Bootstrap(CategoryRepository categoryRepository, VendorRepository vendorRepository) {
		super();
		this.categoryRepository = categoryRepository;
		this.vendorRepository = vendorRepository;
	}



	@Override
	public void run(String... args) throws Exception {
		
		if(categoryRepository.count().block() == 0) {
			Category fish = new Category();
			fish.setDescription("fish");
			
			Category fruit = new Category();
			fruit.setDescription("fruit");
			
			categoryRepository.save(fish).block();
			categoryRepository.save(fruit).block();
		}
		
		if(vendorRepository.count().block() == 0) {
			Vendor sara = new Vendor();
			sara.setFirstName("sara");
			sara.setLastName("lee");
			
			Vendor johnson = new Vendor();
			johnson.setFirstName("johnson");
			johnson.setLastName("johnson");
			
			vendorRepository.save(sara).block();
			vendorRepository.save(johnson).block();
		}
		
		System.out.println("categories: " + categoryRepository.count().block());
		System.out.println("vendors: " + vendorRepository.count().block());
	}

}
