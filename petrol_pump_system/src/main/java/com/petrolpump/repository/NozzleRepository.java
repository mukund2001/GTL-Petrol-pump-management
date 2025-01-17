package com.petrolpump.repository;

import com.petrolpump.model.Nozzle;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface NozzleRepository extends JpaRepository<Nozzle, Long> {
    List<Nozzle> findByMachineId(Long machineId); // Custom query to fetch nozzles by machine ID
}
