package com.example.springcustomermanagementrestful.controller;

import com.example.springcustomermanagementrestful.model.Customer;
import com.example.springcustomermanagementrestful.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/customer")
public class CustomerController {
    @Autowired
    private ICustomerService iCustomerService;

    @GetMapping
    public ResponseEntity<Iterable<Customer>> findAllCustomer() {
        Iterable<Customer> customers = iCustomerService.findAll();
        return new ResponseEntity<>(customers, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Customer> saveCustomer(@RequestBody Customer customer) {
        return new ResponseEntity<>(iCustomerService.save(customer), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Customer> findByIdCustomer(@PathVariable Long id) {
        Optional<Customer> customerOptional = iCustomerService.findById(id);
        return new ResponseEntity<>(customerOptional.get(), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Customer> updateCustomer(@PathVariable Long id, @RequestBody Customer customer) {
        Optional<Customer> customerOptional = iCustomerService.findById(id);
        customer.setId(customerOptional.get().getId());
        return new ResponseEntity<>(iCustomerService.save(customer), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Customer> deleteCustomer(@PathVariable Long id) {
        Optional<Customer> customerOptional = iCustomerService.findById(id);
        if(customerOptional.isPresent()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        iCustomerService.remove(id);
        return new ResponseEntity<>(customerOptional.get(), HttpStatus.OK);
    }
}
