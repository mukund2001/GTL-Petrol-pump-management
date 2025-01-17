package com.petrolpump.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import java.util.List;

@Entity
@Table(name = "machines")
public class Machine {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    @NotNull(message = "Machine name cannot be null")
    @Size(min = 2, message = "Machine name should be at least 2 characters long")
    private String name;

    @Column(nullable = false)
    @NotNull(message = "Machine type cannot be null")
    @Size(min = 2, message = "Machine type should be at least 2 characters long")
    private String machineType;

    @OneToMany(mappedBy = "machine", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Nozzle> nozzles;

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

    public String getMachineType() {
        return machineType;
    }

    public void setMachineType(String machineType) {
        this.machineType = machineType;
    }

    public List<Nozzle> getNozzles() {
        return nozzles;
    }

    public void setNozzles(List<Nozzle> nozzles) {
        this.nozzles = nozzles;
    }

    @Override
    public String toString() {
        return "Machine{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", machineType='" + machineType + '\'' +
                '}';
    }
}
