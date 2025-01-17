package com.petrolpump.controller;

import com.petrolpump.model.Machine;
import com.petrolpump.service.MachineService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/machines")
public class MachineController {

    private final MachineService machineService;

    public MachineController(MachineService machineService) {
        this.machineService = machineService;
    }

    @GetMapping
    public String listMachines(Model model) {
        model.addAttribute("machines", machineService.getAllMachines());
        return "machine-list";
    }

    @GetMapping("/add")
    public String showAddForm(Model model) {
        model.addAttribute("machine", new Machine());
        return "machine-form";
    }

    @PostMapping("/add")
    public String addMachine(@ModelAttribute Machine machine) {
        machineService.addMachine(machine);
        return "redirect:/machines";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable("id") Long id, Model model) {
        model.addAttribute("machine", machineService.getMachineById(id).orElseThrow());
        return "machine-form";
    }

    @PostMapping("/edit/{id}")
    public String editMachine(@PathVariable("id") Long id, @ModelAttribute Machine machine) {
        machineService.updateMachine(id, machine);
        return "redirect:/machines";
    }

    @GetMapping("/delete/{id}")
    public String deleteMachine(@PathVariable("id") Long id) {
        machineService.deleteMachine(id);
        return "redirect:/machines";
    }
}
