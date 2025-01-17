package com.petrolpump.service;

import com.petrolpump.model.Machine;
import com.petrolpump.repository.MachineRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MachineService {

    private final MachineRepository machineRepository;

    public MachineService(MachineRepository machineRepository) {
        this.machineRepository = machineRepository;
    }

    public List<Machine> getAllMachines() {
        return machineRepository.findAll();
    }

    public Machine addMachine(Machine machine) {
        return machineRepository.save(machine);
    }

    public Optional<Machine> getMachineById(Long id) {
        return machineRepository.findById(id);
    }

    public Machine updateMachine(Long id, Machine machine) {
        if (machineRepository.existsById(id)) {
            machine.setId(id);
            return machineRepository.save(machine);
        }
        return null;
    }

    public boolean deleteMachine(Long id) {
        if (machineRepository.existsById(id)) {
            machineRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
