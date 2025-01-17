package com.petrolpump.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.petrolpump.model.CustomerCredit;
import com.petrolpump.service.CustomerCreditService;

@RestController
@RequestMapping("customer-credit")
public class CustomerCreditController {

    @Autowired
    private CustomerCreditService service;

    // Get all customer credits
    @GetMapping
    public List<CustomerCredit> getAllCustomerCredits() {
        return service.getAllCustomerCredits();
    }

    // Get customer credit by ID
    @GetMapping("/{id}")
    public CustomerCredit getCustomerCreditById(@PathVariable Long id) {
        return service.getCustomerCreditById(id);
    }

    // Create a new customer credit
    @PostMapping
    public CustomerCredit createCustomerCredit(@RequestBody CustomerCredit customerCredit) {
        return service.saveCustomerCredit(customerCredit);
    }

    // Update customer credit by ID
    @PutMapping("/{id}")
    public CustomerCredit updateCustomerCredit(@PathVariable Long id, @RequestBody CustomerCredit customerCredit) {
        CustomerCredit existingCustomerCredit = service.getCustomerCreditById(id);
        
        if (existingCustomerCredit == null) {
            throw new RuntimeException("CustomerCredit with ID " + id + " not found.");
        }

        existingCustomerCredit.setName(customerCredit.getName());
        existingCustomerCredit.setBalanceAmt(customerCredit.getBalanceAmt());
        existingCustomerCredit.setPaidAmt(customerCredit.getPaidAmt());
        existingCustomerCredit.setEmail(customerCredit.getEmail());
        existingCustomerCredit.setTransactionDatetime(customerCredit.getTransactionDatetime());
        existingCustomerCredit.setMoNo(customerCredit.getMoNo());
        existingCustomerCredit.setMonoAddress(customerCredit.getMonoAddress());

        return service.saveCustomerCredit(existingCustomerCredit);
    }

    // Delete customer credit by ID
    @DeleteMapping("/{id}")
    public String deleteCustomerCredit(@PathVariable Long id) {
        CustomerCredit customerCredit = service.getCustomerCreditById(id);

        if (customerCredit == null) {
            throw new RuntimeException("CustomerCredit with ID " + id + " not found.");
        }

        service.deleteCustomerCredit(id);
        return "Customer Credit with ID " + id + " has been deleted.";
    }
}
