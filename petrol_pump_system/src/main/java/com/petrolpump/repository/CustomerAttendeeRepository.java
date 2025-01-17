package com.petrolpump.repository;

import com.petrolpump.model.CustomerAttendee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerAttendeeRepository extends JpaRepository<CustomerAttendee, Long> {
    // JpaRepository already provides a deleteById method
}
