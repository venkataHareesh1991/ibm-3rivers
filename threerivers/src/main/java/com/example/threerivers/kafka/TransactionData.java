package com.example.threerivers.kafka;
import com.example.threerivers.models.TypeOfTransaction;

import lombok.Data;
import java.time.Instant;

@Data
public class TransactionData {
	
	private String acNo;
	private Instant transactionTime;
	private TypeOfTransaction type;
	private Double amount;
	public String getAcNo() {
		return acNo;
	}
	public void setAcNo(String acNo) {
		this.acNo = acNo;
	}
	public Instant getTransactionTime() {
		return transactionTime;
	}
	public void setTransactionTime(Instant transactionTime) {
		this.transactionTime = transactionTime;
	}
	public TypeOfTransaction getType() {
		return type;
	}
	public void setType(TypeOfTransaction type) {
		this.type = type;
	}
	public Double getAmount() {
		return amount;
	}
	public void setAmount(Double amount) {
		this.amount = amount;
	}
	
	

}
