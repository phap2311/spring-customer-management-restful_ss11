package com.example.springcustomermanagementrestful.repository;

import com.example.springcustomermanagementrestful.model.Customer;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICustomerRepository extends PagingAndSortingRepository<Customer,Long> {
}
