package com.hariom.bank.entity.bankAccount;

import java.util.List;

import com.hariom.bank.entity.Transaction;
/**
 * BankAccount Abstract class
 * @author Hariom Yadav | 06-Jun-2020
 *
 */
public abstract class BankAccount {//AbstractBankAccount
	
	String accountNumber;
	Double minimumBalance;
	Double currentBalance;
	Double interestRate;
	List<Transaction> listOfTxns;
	
	public BankAccount() {}
	
	public BankAccount(String accountNumber, Double minimumBalance, Double currentBalance, Double interestRate,
			List<Transaction> listOfTxns) {
		super();
		this.accountNumber = accountNumber;
		this.minimumBalance = minimumBalance;
		this.currentBalance = currentBalance;
		this.interestRate = interestRate;
		this.listOfTxns = listOfTxns;
	}
	
	public abstract String getAccountType();

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public Double getMinimumBalance() {
		return minimumBalance;
	}

	public void setMinimumBalance(Double minimumBalance) {
		this.minimumBalance = minimumBalance;
	}

	public Double getCurrentBalance() {
		return currentBalance;
	}

	public void setCurrentBalance(Double currentBalance) {
		this.currentBalance = currentBalance;
	}

	public Double getInterestRate() {
		return interestRate;
	}

	public void setInterestRate(Double interestRate) {
		this.interestRate = interestRate;
	}

	public List<Transaction> getListOfTxns() {
		return listOfTxns;
	}

	public void setListOfTxns(List<Transaction> listOfTxns) {
		this.listOfTxns = listOfTxns;
	}

	@Override
	public String toString() {
		return "BankAccount [accountNumber=" + accountNumber + ", minimumBalance=" + minimumBalance
				+ ", currentBalance=" + currentBalance + ", interestRate=" + interestRate + ", listOfTxns=" + listOfTxns
				+ "]";
	}
}
