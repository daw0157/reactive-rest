package dw.reactive.rest.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import dw.reactive.rest.model.Vendor;

public interface VendorRepository extends ReactiveMongoRepository<Vendor, String>{

}
