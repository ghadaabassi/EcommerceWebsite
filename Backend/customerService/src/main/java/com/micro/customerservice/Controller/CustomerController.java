package com.micro.customerservice.Controller;


import com.micro.customerservice.Service.ICustomerService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/customer")
@AllArgsConstructor
public class CustomerController {
    private ICustomerService customerService;

    @PostMapping("/addCustomer")
    public ResponseEntity<String> createCustomer(
            @RequestBody @Valid CustomerRequest request
    ){
        return ResponseEntity.ok(customerService.createCustomer(request));
    }

    @PutMapping("/updateCustomer")
    public ResponseEntity<Void> updateCustomer(
        @RequestBody @Valid CustomerRequest request){

        customerService.updateCustomer(request);
        return ResponseEntity.accepted().build();
    }

    @GetMapping("/getAllCustomers")
    public ResponseEntity<List<CustomerResponse>> findAllCustomers(){
        return ResponseEntity.ok(customerService.findAllCustomers());

    }

    @GetMapping("/existCustomer/{id}")
    public ResponseEntity<Boolean> existCustomerById(@PathVariable("id") String id ){
      return ResponseEntity.ok(customerService.existCustomerById(id));
    }

    @GetMapping("/findCustomer/{id}")
    public ResponseEntity<CustomerResponse> findCustomerById(@PathVariable("id") String id ){
        return ResponseEntity.ok(customerService.findCustomerById(id));
    }

    @DeleteMapping("/deleteCustomer/{id}")
    public ResponseEntity<Void> deleteCustomer(@PathVariable("id") String id ){
        customerService.deleteCustomer(id);
        return ResponseEntity.accepted().build();
    }

}
