package com.petrolpump.service;

import com.petrolpump.model.Nozzle;
import com.petrolpump.model.Machine;
import com.petrolpump.repository.NozzleRepository;
import com.petrolpump.repository.MachineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NozzleService {

    @Autowired
    private NozzleRepository nozzleRepository;

    @Autowired
    private MachineRepository machineRepository;

    // Get nozzles by machine ID
    public List<Nozzle> getNozzlesByMachineId(Long machineId) {
        return nozzleRepository.findByMachineId(machineId);
    }

    // Add a new nozzle
    public Nozzle addNozzle(Nozzle nozzle) {
        Optional<Machine> machineOpt = machineRepository.findById(nozzle.getMachine().getId());
        if (machineOpt.isPresent()) {
            nozzle.setMachine(machineOpt.get());
            return nozzleRepository.save(nozzle);
        } else {
            throw new RuntimeException("Machine with ID " + nozzle.getMachine().getId() + " not found");
        }
    }
}
