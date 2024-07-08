package com.micro.customerservice.Service;

import com.micro.customerservice.Controller.CustomerRequest;
import com.micro.customerservice.Controller.CustomerResponse;
import com.micro.customerservice.entities.Customer;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ICustomerService {
    String createCustomer(CustomerRequest request);

    void updateCustomer(CustomerRequest request);

    List<CustomerResponse> findAllCustomers();

    Boolean existCustomerById(String id);


    CustomerResponse findCustomerById(String id);

    void deleteCustomer(String id);
}
