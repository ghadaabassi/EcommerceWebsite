package com.micro.customerservice.Service;

import com.micro.customerservice.Controller.CustomerRequest;
import com.micro.customerservice.Controller.CustomerResponse;
import com.micro.customerservice.Repositories.IAdressRepository;
import com.micro.customerservice.Repositories.ICustomerRepository;
import com.micro.customerservice.entities.Adress;
import com.micro.customerservice.entities.Customer;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements ICustomerService{

    private final ICustomerRepository customerRepository;
    private final CustomerMapper customerMapper;
    private final IAdressRepository adressRepository;

    @Override
    public Long createCustomer(CustomerRequest request) {


       adressRepository.save(request.address());

        var customer = customerRepository.save(customerMapper.toCustomer(request));
        return customer.getId();
    }

    @Override
    public void updateCustomer(CustomerRequest request) {

        var customer= customerRepository.findById(request.id()).orElse(null);
        mergeCustomer(customer,request);
        customerRepository.save(customer);
    }

    @Override
    public List<CustomerResponse> findAllCustomers() {
        return customerRepository.findAll()
                .stream()
                .map(customerMapper::fromCustomer)
                .collect(Collectors.toList())
                ;
    }

    @Override
    public Boolean existCustomerById(Long id) {
        return customerRepository.findById(id).isPresent();
    }

    @Override
    public CustomerResponse findCustomerById(Long id) {
        return customerRepository.findById(id)
                .map(customerMapper::fromCustomer)
                .orElse(null);
    }

    @Override
    public void deleteCustomer(Long id) {
        customerRepository.deleteById(id);
    }

    private  void mergeCustomer(Customer customer, CustomerRequest request){
        if(StringUtils.isNotBlank(request.firstname())){
            customer.setFirstname(request.firstname());
        }

        if(StringUtils.isNotBlank(request.lastname())){
            customer.setLastname(request.lastname());
        }

        if(StringUtils.isNotBlank(request.email())){
            customer.setEmail(request.email());
        }

        if(request.address()!=null){
            customer.setAddress(request.address());
        }
    }

}
