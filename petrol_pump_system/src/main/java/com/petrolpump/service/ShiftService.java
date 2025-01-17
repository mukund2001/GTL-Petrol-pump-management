package com.petrolpump.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.petrolpump.model.CustomerAttendeeShift;
import com.petrolpump.model.Transaction;
import com.petrolpump.repository.CustomerAttendeeShiftRepository;
import com.petrolpump.repository.TransactionRepository;

@Service
public class ShiftService {
    @Autowired
    private CustomerAttendeeShiftRepository shiftRepository;

    @Autowired
    private TransactionRepository transactionRepository;

    public CustomerAttendeeShift startShift(CustomerAttendeeShift shift) {
        return shiftRepository.save(shift);
    }

    public void endShift(Long shiftId) {
        CustomerAttendeeShift shift = shiftRepository.findById(shiftId).orElseThrow();
        shift.setShiftStatus("Ended");
        shiftRepository.save(shift);
    }

    public Transaction recordTransaction(Transaction transaction) {
        return transactionRepository.save(transaction);
    }
}
