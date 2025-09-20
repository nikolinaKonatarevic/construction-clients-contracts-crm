package com.Gradjevinsko_preduzece.controller;

import com.Gradjevinsko_preduzece.record.CreateCustomerRecord;
import com.Gradjevinsko_preduzece.record.CustomerRecord;
import com.Gradjevinsko_preduzece.record.UpdateCustomerRecord;
import com.Gradjevinsko_preduzece.service_imp.CustomerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/customer")
public class CustomerController {

    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping
    public ResponseEntity<List<CustomerRecord>> findAll(){
        return new ResponseEntity<>(customerService.getAllCustomers(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CustomerRecord> findById(@PathVariable Long id) {
        return new ResponseEntity<>(customerService.getCustomerById(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<CustomerRecord> save(@RequestBody CreateCustomerRecord createCustomerRecord) {
        return new ResponseEntity<>(customerService.createCustomer(createCustomerRecord), HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<CustomerRecord> update(@RequestBody UpdateCustomerRecord updateCustomerRecord) {
        return new ResponseEntity<>(customerService.updateCustomer(updateCustomerRecord), HttpStatus.OK);
    }
}
