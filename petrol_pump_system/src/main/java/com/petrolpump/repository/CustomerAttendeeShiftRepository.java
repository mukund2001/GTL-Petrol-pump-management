package com.petrolpump.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.petrolpump.model.CustomerAttendeeShift;

@Repository
public interface CustomerAttendeeShiftRepository extends JpaRepository<CustomerAttendeeShift, Long> {}
