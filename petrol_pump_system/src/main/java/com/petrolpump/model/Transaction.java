package com.petrolpump.model;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "transactions")
public class Transaction {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;  // Primary key for the transaction

    @Column(name = "shift_id", nullable = false)
    private Long shiftId;  // Foreign key to link to a shift in the customer_attendee_shifts table

    @Column(name = "payment_mode", nullable = false)
    private String paymentMode;  // Mode of payment (Card, UPI, Cash, Credit)

    @Column(name = "amount", nullable = false)
    private BigDecimal amount;  // Amount paid in the transaction

    @Column(name = "transaction_date", nullable = false)
    private LocalDateTime transactionDate;  // Date and time when the transaction occurred

    // Getters and Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getShiftId() {
        return shiftId;
    }

    public void setShiftId(Long shiftId) {
        this.shiftId = shiftId;
    }

    public String getPaymentMode() {
        return paymentMode;
    }

    public void setPaymentMode(String paymentMode) {
        this.paymentMode = paymentMode;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public LocalDateTime getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(LocalDateTime transactionDate) {
        this.transactionDate = transactionDate;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "id=" + id +
                ", shiftId=" + shiftId +
                ", paymentMode='" + paymentMode + '\'' +
                ", amount=" + amount +
                ", transactionDate=" + transactionDate +
                '}';
    }
}
