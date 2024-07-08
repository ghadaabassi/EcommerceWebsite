package com.micro.customerservice.Service;

import com.micro.customerservice.Controller.CustomerRequest;
import com.micro.customerservice.Repositories.ICustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RestController;

@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements ICustomerService{

    private final ICustomerRepository customerRepository;

    @Override
    public String createCustomer(CustomerRequest request) {
        return null;
    }
}
