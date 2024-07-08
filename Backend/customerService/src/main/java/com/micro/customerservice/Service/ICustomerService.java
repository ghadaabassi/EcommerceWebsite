package com.micro.customerservice.Service;

import com.micro.customerservice.Controller.CustomerRequest;
import com.micro.customerservice.Controller.CustomerResponse;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ICustomerService {
    String createCustomer(CustomerRequest request);

    void updateCustomer(CustomerRequest request);

    List<CustomerResponse> findAllCustomers();

    Boolean existCustomerById(String id);
}
