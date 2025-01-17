package com.petrolpump.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.petrolpump.model.CustomerCredit;

public interface CustomerCreditRepository extends JpaRepository<CustomerCredit, Long> {
    // This interface will automatically provide basic CRUD operations
}
