package stackjava.com.mongodb.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import stackjava.com.mongodb.entities.Customer;

@Repository
public interface CustomerRepository extends MongoRepository<Customer, String> {
    
}
