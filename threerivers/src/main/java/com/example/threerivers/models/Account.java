package com.example.threerivers.models;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.Instant;
import java.util.List;

@Data
@Document(collection = "account")
public class Account {
    @Id
    private String id;
    @Indexed
    private String acNo;
    private Instant lastUpdatedTime;
    private Double balance;
    private List<Transaction> transactions;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getAcNo() {
		return acNo;
	}
	public void setAcNo(String acNo) {
		this.acNo = acNo;
	}
	public Instant getLastUpdatedTime() {
		return lastUpdatedTime;
	}
	public void setLastUpdatedTime(Instant lastUpdatedTime) {
		this.lastUpdatedTime = lastUpdatedTime;
	}
	public Double getBalance() {
		return balance;
	}
	public void setBalance(Double balance) {
		this.balance = balance;
	}
	public List<Transaction> getTransactions() {
		return transactions;
	}
	public void setTransactions(List<Transaction> transactions) {
		this.transactions = transactions;
	}
    
    
}