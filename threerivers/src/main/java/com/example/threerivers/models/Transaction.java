package com.example.threerivers.models;

import lombok.Data;
import java.time.Instant;

@Data
public class Transaction {

	private Instant transactionTime;
	private TypeOfTransaction transactionType;
	private Double amount;
	public Instant getTransactionTime() {
		return transactionTime;
	}
	public void setTransactionTime(Instant transactionTime) {
		this.transactionTime = transactionTime;
	}
	public TypeOfTransaction getTransactionType() {
		return transactionType;
	}
	public void setTransactionType(TypeOfTransaction transactionType) {
		this.transactionType = transactionType;
	}
	public Double getAmount() {
		return amount;
	}
	public void setAmount(Double amount) {
		this.amount = amount;
	}
	
	
}
