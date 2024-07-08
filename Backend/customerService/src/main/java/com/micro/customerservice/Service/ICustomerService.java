package com.micro.customerservice.Service;

import com.micro.customerservice.Controller.CustomerRequest;

public interface ICustomerService {
    String createCustomer(CustomerRequest request);
}
