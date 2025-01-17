package com.petrolpump.controller;

import com.petrolpump.model.Pricing;
import com.petrolpump.service.PricingService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pricing")
public class PricingController {

    private final PricingService pricingService;

    public PricingController(PricingService pricingService) {
        this.pricingService = pricingService;
    }

    @GetMapping
    public List<Pricing> getAllPricing() {
        return pricingService.getAllPricing();
    }

    @PostMapping
    public ResponseEntity<String> setPrice(@RequestBody Pricing pricing) {
        try {
            pricingService.setPricing(pricing); // Updated method name to match the service method
            return ResponseEntity.ok("Price updated successfully!");
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Error updating price: " + e.getMessage());
        }
    }
}
