package com.example.springcustomermanagementrestful.service;

import com.example.springcustomermanagementrestful.model.Customer;
import com.example.springcustomermanagementrestful.repository.ICustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomerService implements ICustomerService {
    @Autowired
    private ICustomerRepository iCustomerRepository;

    @Override
    public Iterable findAll() {
        return iCustomerRepository.findAll();
    }

    @Override
    public Customer save(Customer customer) {
        return iCustomerRepository.save(customer);
    }


    @Override
    public Optional findById(Long id) {
        return iCustomerRepository.findById(id);
    }

    @Override
    public void remove(Long id) {
        iCustomerRepository.deleteById(id);
    }
}
