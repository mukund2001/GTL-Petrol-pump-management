package com.petrolpump.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.petrolpump.model.Transaction;
import com.petrolpump.repository.TransactionRepository;

import java.util.List;

@Service
public class TransactionService {

    @Autowired
    private TransactionRepository transactionRepository;

    // Create a new transaction
    public Transaction createTransaction(Transaction transaction) {
        return transactionRepository.save(transaction);
    }

    // Get all transactions for a specific shift
    public List<Transaction> getTransactionsByShiftId(Long shiftId) {
        return transactionRepository.findByShiftId(shiftId);
    }

    // Update a transaction
    public Transaction updateTransaction(Long id, Transaction updatedTransaction) {
        Transaction transaction = transactionRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Transaction not found with id: " + id));
        
        transaction.setPaymentMode(updatedTransaction.getPaymentMode());
        transaction.setAmount(updatedTransaction.getAmount());
        return transactionRepository.save(transaction);
    }

    // Delete a transaction
    public void deleteTransaction(Long id) {
        transactionRepository.deleteById(id);
    }
}
