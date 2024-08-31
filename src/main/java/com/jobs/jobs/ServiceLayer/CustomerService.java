package com.jobs.jobs.ServiceLayer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jobs.jobs.Models.Customer;
import com.jobs.jobs.Repo.CustomerRepository;

@Service
public class CustomerService {


    @Autowired
    CustomerRepository customerRepo;

    public Customer getCustomerById(Long cutomerId) {
        return customerRepo.findById(cutomerId).orElse(null);
    }
}
