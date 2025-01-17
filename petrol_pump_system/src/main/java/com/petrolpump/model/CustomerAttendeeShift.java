package com.petrolpump.model;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "customer_attendee_shifts")
public class CustomerAttendeeShift {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;  // Primary key for the shift entry

    @Column(name = "attendee_name", nullable = false)
    private String attendeeName;  // Name of the attendee

    @Column(name = "machine_selected", nullable = false)
    private String machineSelected;  // Machine selected (Machine 1 or 2)

    @Column(name = "nozzles_selected")
    private String nozzlesSelected;  // Nozzles selected (Comma separated for multiple)

    @Column(name = "price_per_liter_petrol", nullable = false)
    private BigDecimal pricePerLiterPetrol;  // Price per liter for petrol

    @Column(name = "price_per_liter_diesel", nullable = false)
    private BigDecimal pricePerLiterDiesel;  // Price per liter for diesel

    @Column(name = "readings")
    private String readings;  // Manual readings of the nozzles

    @Column(name = "date_time", nullable = false)
    private LocalDateTime dateTime;  // Date and time of the shift

    @Column(name = "shift_status", nullable = false)
    private String shiftStatus;  // Status of the shift (Started or Ended)

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAttendeeName() {
        return attendeeName;
    }

    public void setAttendeeName(String attendeeName) {
        this.attendeeName = attendeeName;
    }

    public String getMachineSelected() {
        return machineSelected;
    }

    public void setMachineSelected(String machineSelected) {
        this.machineSelected = machineSelected;
    }

    public String getNozzlesSelected() {
        return nozzlesSelected;
    }

    public void setNozzlesSelected(String nozzlesSelected) {
        this.nozzlesSelected = nozzlesSelected;
    }

    public BigDecimal getPricePerLiterPetrol() {
        return pricePerLiterPetrol;
    }

    public void setPricePerLiterPetrol(BigDecimal pricePerLiterPetrol) {
        this.pricePerLiterPetrol = pricePerLiterPetrol;
    }

    public BigDecimal getPricePerLiterDiesel() {
        return pricePerLiterDiesel;
    }

    public void setPricePerLiterDiesel(BigDecimal pricePerLiterDiesel) {
        this.pricePerLiterDiesel = pricePerLiterDiesel;
    }

    public String getReadings() {
        return readings;
    }

    public void setReadings(String readings) {
        this.readings = readings;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public String getShiftStatus() {
        return shiftStatus;
    }

    public void setShiftStatus(String shiftStatus) {
        this.shiftStatus = shiftStatus;
    }

    @Override
    public String toString() {
        return "CustomerAttendeeShift{" +
                "id=" + id +
                ", attendeeName='" + attendeeName + '\'' +
                ", machineSelected='" + machineSelected + '\'' +
                ", nozzlesSelected='" + nozzlesSelected + '\'' +
                ", pricePerLiterPetrol=" + pricePerLiterPetrol +
                ", pricePerLiterDiesel=" + pricePerLiterDiesel +
                ", readings='" + readings + '\'' +
                ", dateTime=" + dateTime +
                ", shiftStatus='" + shiftStatus + '\'' +
                '}';
    }
}
