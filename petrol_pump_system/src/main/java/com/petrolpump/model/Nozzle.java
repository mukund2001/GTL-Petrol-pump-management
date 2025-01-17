package com.petrolpump.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "nozzles")
public class Nozzle {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private double startReading;
    private double endReading;
    private double fuelDispensed;
    private double totalPrice;
    private LocalDateTime createdAt;
    private String description;

    @ManyToOne
    @JoinColumn(name = "machine_id", nullable = false)
    private Machine machine;

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public double getStartReading() {
        return startReading;
    }

    public void setStartReading(double startReading) {
        this.startReading = startReading;
    }

    public double getEndReading() {
        return endReading;
    }

    public void setEndReading(double endReading) {
        this.endReading = endReading;
    }

    public double getFuelDispensed() {
        return fuelDispensed;
    }

    public void setFuelDispensed(double fuelDispensed) {
        this.fuelDispensed = fuelDispensed;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Machine getMachine() {
        return machine;
    }

    public void setMachine(Machine machine) {
        this.machine = machine;
    }
}
