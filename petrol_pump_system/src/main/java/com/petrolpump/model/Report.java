package com.petrolpump.model;

import java.time.LocalDate;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "reports")
public class Report {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private LocalDate date;

    @Column(nullable = false)
    private double totalFuelDispensed;

    @Column(nullable = false)
    private double totalAmountEarned;

    @Column(nullable = false)
    private double totalFuelConsumedForTesting;

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public double getTotalFuelDispensed() {
        return totalFuelDispensed;
    }

    public void setTotalFuelDispensed(double totalFuelDispensed) {
        this.totalFuelDispensed = totalFuelDispensed;
    }

    public double getTotalAmountEarned() {
        return totalAmountEarned;
    }

    public void setTotalAmountEarned(double totalAmountEarned) {
        this.totalAmountEarned = totalAmountEarned;
    }

    public double getTotalFuelConsumedForTesting() {
        return totalFuelConsumedForTesting;
    }

    public void setTotalFuelConsumedForTesting(double totalFuelConsumedForTesting) {
        this.totalFuelConsumedForTesting = totalFuelConsumedForTesting;
    }

    // toString for debugging
    @Override
    public String toString() {
        return "Report{" +
                "id=" + id +
                ", date=" + date +
                ", totalFuelDispensed=" + totalFuelDispensed +
                ", totalAmountEarned=" + totalAmountEarned +
                ", totalFuelConsumedForTesting=" + totalFuelConsumedForTesting +
                '}';
    }
}
