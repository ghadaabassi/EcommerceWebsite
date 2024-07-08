package com.micro.customerservice.Controller;


import com.micro.customerservice.Service.ICustomerService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

}
