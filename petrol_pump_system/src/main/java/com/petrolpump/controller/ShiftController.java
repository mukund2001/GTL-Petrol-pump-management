package com.petrolpump.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.petrolpump.model.CustomerAttendeeShift;
import com.petrolpump.model.Transaction;
import com.petrolpump.service.ShiftService;

import java.math.BigDecimal;
import java.time.LocalDateTime; // Import LocalDateTime for date and time
import java.util.List;

@RestController
@RequestMapping("/shifts")
public class ShiftController {

    @Autowired
    private ShiftService shiftService;

    @PostMapping("/start")
    public ResponseEntity<?> startShift(
            @RequestParam("attendeeName") String attendeeName,
            @RequestParam("machineSelected") List<String> machineSelected,
            @RequestParam(value = "nozzlesSelected", required = false) List<String> nozzlesSelected,
            @RequestParam(value = "pricePerLiterPetrol", required = false) Double pricePerLiterPetrol,
            @RequestParam(value = "pricePerLiterDiesel", required = false) Double pricePerLiterDiesel) {

        try {
            // Check for nozzle selection
            if (nozzlesSelected == null || nozzlesSelected.isEmpty()) {
                return ResponseEntity.badRequest().body("Nozzles selection is required");
            }

            // Check for price per liter for both petrol and diesel
            if (pricePerLiterPetrol == null || pricePerLiterDiesel == null) {
                return ResponseEntity.badRequest().body("Price per liter for petrol and diesel must be provided");
            }

            // Convert List<String> to comma-separated String for machine and nozzles selection
            String machineSelectedStr = String.join(",", machineSelected);
            String nozzlesSelectedStr = String.join(",", nozzlesSelected);

            // Convert pricePerLiterPetrol and pricePerLiterDiesel from Double to BigDecimal
            BigDecimal petrolPrice = BigDecimal.valueOf(pricePerLiterPetrol);
            BigDecimal dieselPrice = BigDecimal.valueOf(pricePerLiterDiesel);

            // Create a new shift object
            CustomerAttendeeShift shift = new CustomerAttendeeShift();
            shift.setAttendeeName(attendeeName);
            shift.setMachineSelected(machineSelectedStr);
            shift.setNozzlesSelected(nozzlesSelectedStr);
            shift.setPricePerLiterPetrol(petrolPrice);
            shift.setPricePerLiterDiesel(dieselPrice);

            // Set the current date and time for the shift
            shift.setDateTime(LocalDateTime.now());  // Set current date and time

            // Start the shift and save it to the database
            CustomerAttendeeShift createdShift = shiftService.startShift(shift);

            // Return the created shift as the response
            return ResponseEntity.ok(createdShift);

        } catch (Exception e) {
            // Handle exceptions and return an error response
            return ResponseEntity.status(500).body("Error starting shift: " + e.getMessage());
        }
    }

    @PostMapping("/end/{id}")
    public ResponseEntity<?> endShift(@PathVariable Long id) {
        try {
            // End the shift based on the provided ID
            shiftService.endShift(id);

            // Return a response with no content (200 OK)
            return ResponseEntity.ok().build();

        } catch (Exception e) {
            // Handle exceptions and return an error response
            return ResponseEntity.status(500).body("Error ending shift: " + e.getMessage());
        }
    }

    @PostMapping("/transaction")
    public ResponseEntity<?> recordTransaction(@RequestBody Transaction transaction) {
        try {
            // Record the transaction and return the recorded transaction
            Transaction recordedTransaction = shiftService.recordTransaction(transaction);

            // Return the recorded transaction with 200 OK status
            return ResponseEntity.ok(recordedTransaction);

        } catch (Exception e) {
            // Handle exceptions and return an error response
            return ResponseEntity.status(500).body("Error recording transaction: " + e.getMessage());
        }
    }
}
