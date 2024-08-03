package com.micro.customerservice.Service;

import com.micro.customerservice.Controller.CustomerRequest;
import com.micro.customerservice.Controller.CustomerResponse;
import com.micro.customerservice.entities.Customer;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ICustomerService {
    Long createCustomer(CustomerRequest request);

    void updateCustomer(CustomerRequest request);

    List<CustomerResponse> findAllCustomers();

    Boolean existCustomerById(Long id);


    CustomerResponse findCustomerById(Long id);

    void deleteCustomer(Long id);
}
