package com.petrolpump.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.petrolpump.model.CustomerCredit;
import com.petrolpump.repository.CustomerCreditRepository;

import java.util.List;

@Service
public class CustomerCreditService {

    @Autowired
    private CustomerCreditRepository repository;

    // Fetch all customer credits
    public List<CustomerCredit> getAllCustomerCredits() {
        return repository.findAll();
    }

    // Save or update a customer credit
    @Transactional
    public CustomerCredit saveCustomerCredit(CustomerCredit customerCredit) {
        return repository.save(customerCredit);
    }

    // Find customer credit by ID
    public CustomerCredit getCustomerCreditById(Long id) {
        return repository.findById(id).orElse(null);
    }

    // Delete a customer credit by ID
    public void deleteCustomerCredit(Long id) {
        repository.deleteById(id);
    }
}
