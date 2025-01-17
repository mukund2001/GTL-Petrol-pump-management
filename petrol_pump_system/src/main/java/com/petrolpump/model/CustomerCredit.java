package com.petrolpump.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Version;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Entity
@Data
@Getter
@Setter
public class CustomerCredit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String monoAddress;
    private BigDecimal balanceAmt;
    private BigDecimal paidAmt;
    private String email;
    private String moNo; 

    private LocalDateTime transactionDatetime;

    @Version
    private Long version = 0L;

    // Default constructor
    public CustomerCredit() {
       
        this.transactionDatetime = LocalDateTime.now(); 
    }

    // Parameterized constructor
    public CustomerCredit(String name, String monoAddress, BigDecimal balanceAmt, BigDecimal paidAmt, String email, String moNo) {
        this.name = name;
        this.monoAddress = monoAddress;
        this.balanceAmt = balanceAmt;
        this.paidAmt = paidAmt;
        this.email = email;
        this.moNo = moNo;
        this.transactionDatetime = LocalDateTime.now(); 
        this.version = 0L; 
    }

  /*  // Getters and Setters
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

    public String getMonoAddress() {
        return monoAddress;
    }

    public void setMonoAddress(String monoAddress) {
        this.monoAddress = monoAddress;
    }

    public BigDecimal getBalanceAmt() {
        return balanceAmt;
    }

    public void setBalanceAmt(BigDecimal balanceAmt) {
        this.balanceAmt = balanceAmt;
    }

    public BigDecimal getPaidAmt() {
        return paidAmt;
    }

    public void setPaidAmt(BigDecimal paidAmt) {
        this.paidAmt = paidAmt;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMoNo() {
        return moNo;
    }

    public void setMoNo(String moNo) {
        this.moNo = moNo;
    }

    public LocalDateTime getTransactionDatetime() {
        return transactionDatetime;
    }

    public void setTransactionDatetime(LocalDateTime transactionDatetime) {
        this.transactionDatetime = transactionDatetime;
    }

    public Long getVersion() {
        return version;
    }

    public void setVersion(Long version) {
        this.version = version;
    }*/
}  