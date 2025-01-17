package com.petrolpump.controller;

import com.petrolpump.model.Nozzle;
import com.petrolpump.service.NozzleService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/nozzles")
@Validated // Ensure validation is enabled
public class NozzleController {

    private final NozzleService nozzleService;

    public NozzleController(NozzleService nozzleService) {
        this.nozzleService = nozzleService;
    }

    // Fetch all nozzles for a machine (GET request)
    @GetMapping("/machine/{machineId}")
    public ResponseEntity<List<Nozzle>> getNozzlesByMachineId(@PathVariable Long machineId) {
        List<Nozzle> nozzles = nozzleService.getNozzlesByMachineId(machineId);
        if (nozzles.isEmpty()) {
            return ResponseEntity.noContent().build(); // 204 No Content
        }
        return ResponseEntity.ok(nozzles); // 200 OK
    }

    // Add a new nozzle (POST request)
    @PostMapping
    public ResponseEntity<String> addNozzle(@Valid @RequestBody Nozzle nozzle, BindingResult result) {
        if (result.hasErrors()) {
            StringBuilder errorMessages = new StringBuilder("Validation errors: ");
            result.getAllErrors().forEach(error -> errorMessages.append(error.getDefaultMessage()).append("; "));
            return ResponseEntity.badRequest().body(errorMessages.toString());
        }
        nozzleService.addNozzle(nozzle);
        return ResponseEntity.status(HttpStatus.CREATED).body("Nozzle added successfully!"); // 201 Created
    }

    // Error handling - global error handler
    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleExceptions(Exception ex) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An error occurred: " + ex.getMessage());
    }
}
