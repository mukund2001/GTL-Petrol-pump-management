package com.petrolpump.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.petrolpump.model.CustomerAttendee;
import com.petrolpump.service.CustomerAttendeeService;

@RestController
@RequestMapping("/customer-attendees")
public class CustomerAttendeeController {

    @Autowired
    private CustomerAttendeeService service;

    @GetMapping
    public List<CustomerAttendee> getAllCustomerAttendees() {
        List<CustomerAttendee> attendees = service.getAllCustomerAttendees();
        attendees.forEach(attendee -> System.out.println("Fetched Attendee: " + attendee)); // Debug each attendee
        return attendees;
    }

    @GetMapping("/{id}")
    public ResponseEntity<CustomerAttendee> getCustomerAttendeeById(@PathVariable Long id) {
        Optional<CustomerAttendee> customerAttendee = service.getCustomerAttendeeById(id);
        System.out.println("Fetched Attendee by ID: " + id + " -> " + customerAttendee);
        return customerAttendee
            .map(ResponseEntity::ok)
            .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    @PostMapping
    public ResponseEntity<CustomerAttendee> saveCustomerAttendee(@RequestBody CustomerAttendee customerAttendee) {
        System.out.println("Saving Attendee: " + customerAttendee);
        CustomerAttendee savedAttendee = service.saveCustomerAttendee(customerAttendee);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedAttendee);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CustomerAttendee> updateCustomerAttendee(@PathVariable("id") Long id, @RequestBody CustomerAttendee customerAttendee) {
        System.out.println("Updating Attendee with ID: " + id);
        if (!service.getCustomerAttendeeById(id).isPresent()) {
            System.out.println("Attendee not found with ID: " + id);
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        customerAttendee.setId(id);
        CustomerAttendee updatedAttendee = service.saveCustomerAttendee(customerAttendee);
        return ResponseEntity.ok(updatedAttendee);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCustomerAttendee(@PathVariable("id") Long id) {
        Optional<CustomerAttendee> attendee = service.getCustomerAttendeeById(id);
        if (!attendee.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build(); // If not found
        }
        service.deleteCustomerAttendeeById(id); // Call the service to delete
        return ResponseEntity.noContent().build(); // Return 204 No Content if successful
    }

}
