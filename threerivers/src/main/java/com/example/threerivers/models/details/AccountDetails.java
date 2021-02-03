package com.example.threerivers.models.details;

import com.example.threerivers.models.Transaction;
import lombok.Data;
import java.util.List;

@Data
public class AccountDetails {
	
	private Double balance;
	private List<Transaction> ListOfTransactions;
	public Double getBalance() {
		return balance;
	}
	public void setBalance(Double balance) {
		this.balance = balance;
	}
	public List<Transaction> getListOfTransactions() {
		return ListOfTransactions;
	}
	public void setListOfTransactions(List<Transaction> listOfTransactions) {
		ListOfTransactions = listOfTransactions;
	}
	
	

}
