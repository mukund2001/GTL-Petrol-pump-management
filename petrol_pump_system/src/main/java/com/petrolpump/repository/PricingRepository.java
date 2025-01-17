package com.petrolpump.repository;

import com.petrolpump.model.Pricing;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PricingRepository extends JpaRepository<Pricing, Long> {
    // Custom query to get the latest pricing entry
    Optional<Pricing> findTopByOrderByCreatedAtDesc();
}
