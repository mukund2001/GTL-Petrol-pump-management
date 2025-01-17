package com.petrolpump.service;

import com.petrolpump.model.CustomerAttendee;
import com.petrolpump.repository.CustomerAttendeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerAttendeeService {

    @Autowired
    private CustomerAttendeeRepository repository;

    public List<CustomerAttendee> getAllCustomerAttendees() {
        List<CustomerAttendee> attendees = repository.findAll();
        attendees.forEach(attendee -> System.out.println("Service Layer Attendee: " + attendee)); // Debug
        return attendees;
    }

    public Optional<CustomerAttendee> getCustomerAttendeeById(Long id) {
        return repository.findById(id);
    }

    public CustomerAttendee saveCustomerAttendee(CustomerAttendee customerAttendee) {
        return repository.save(customerAttendee);
    }

    public void deleteCustomerAttendeeById(Long id) {
        // Using the injected repository to delete by ID
        repository.deleteById(id); // Deletes by ID
    }
}
