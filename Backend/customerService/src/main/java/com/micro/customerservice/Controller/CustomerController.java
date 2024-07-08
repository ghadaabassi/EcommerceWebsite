package com.micro.customerservice.Controller;


import com.micro.customerservice.Service.ICustomerService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
