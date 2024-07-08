package com.micro.customerservice.Repositories;

import com.micro.customerservice.entities.Customer;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICustomerRepository extends MongoRepository<Customer,String> {
}
