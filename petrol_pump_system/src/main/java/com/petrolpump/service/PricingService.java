package com.petrolpump.service;

import com.petrolpump.model.Pricing;
import com.petrolpump.repository.PricingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PricingService {

    @Autowired
    private PricingRepository pricingRepository;

    // Method to set new pricing
    public Pricing setPricing(Pricing pricing) {
        return pricingRepository.save(pricing);
    }

    // Method to get all pricing records
    public List<Pricing> getAllPricing() {
        return pricingRepository.findAll();
    }

    // Method to get the current/latest pricing
    public Pricing getCurrentPricing() {
        return pricingRepository.findTopByOrderByCreatedAtDesc()
                .orElseThrow(() -> new RuntimeException("No pricing data found"));
    }
}
