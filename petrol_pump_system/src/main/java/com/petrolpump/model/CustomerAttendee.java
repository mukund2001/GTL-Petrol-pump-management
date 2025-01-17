package com.petrolpump.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
@Data
@Entity
@Getter
@Setter
public class CustomerAttendee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    @JsonProperty("name")
    private String name;

    @Column(name = "email")
    @JsonProperty("email")
    private String email;

    @Column(name = "phone")
    @JsonProperty("phone")
    private String phone;

    @Column(name = "nozzle_assigned")
    @JsonProperty("nozzleAssigned")
    private String nozzleAssigned;

    @Column(name = "shift_active")
    @JsonProperty("shiftActive")
    private Boolean shiftActive;

    @Column(name = "shift_start_time")
    @JsonProperty("shiftStartTime")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime shiftStartTime;

    @Column(name = "shift_end_time")
    @JsonProperty("shiftEndTime")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime shiftEndTime;

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getNozzleAssigned() {
        return nozzleAssigned;
    }

    public void setNozzleAssigned(String nozzleAssigned) {
        this.nozzleAssigned = nozzleAssigned;
    }

    public Boolean getShiftActive() {
        return shiftActive;
    }

    public void setShiftActive(Boolean shiftActive) {
        this.shiftActive = shiftActive;
    }

    public LocalDateTime getShiftStartTime() {
        return shiftStartTime;
    }

    public void setShiftStartTime(LocalDateTime shiftStartTime) {
        this.shiftStartTime = shiftStartTime;
    }

    public LocalDateTime getShiftEndTime() {
        return shiftEndTime;
    }

    public void setShiftEndTime(LocalDateTime shiftEndTime) {
        this.shiftEndTime = shiftEndTime;
    }
    
}
