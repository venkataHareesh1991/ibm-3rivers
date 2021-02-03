package com.example.threerivers.kafka;

import lombok.Data;
import java.time.Instant;

@Data
public class BalanceData {
	
	private String acNo;
	private Instant lastUpdatedTime;
	private Double balance;
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
	
	
}
