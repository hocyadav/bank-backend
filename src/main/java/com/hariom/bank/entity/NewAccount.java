package com.hariom.bank.entity;
/**
 * NewAccount entity
 * @author Hariom Yadav | 06-Jun-2020
 *
 */
public class NewAccount {
	String panNumber;
	String accountType;
	Double initialBalance;
	
	public NewAccount() {}
	
	public NewAccount(String panNumber, String accountType, Double initialBalance) {
		super();
		this.panNumber = panNumber;
		this.accountType = accountType;
		this.initialBalance = initialBalance;
	}
	
	public String getPanNumber() {
		return panNumber;
	}
	public void setPanNumber(String panNumber) {
		this.panNumber = panNumber;
	}
	public String getAccountType() {
		return accountType;
	}
	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}
	public Double getInitialBalance() {
		return initialBalance;
	}
	public void setInitialBalance(Double initialBalance) {
		this.initialBalance = initialBalance;
	}

	@Override
	public String toString() {
		return "NewAccount [panNumber=" + panNumber + ", accountType=" + accountType + ", initialBalance="
				+ initialBalance + "]";
	}
	
}
