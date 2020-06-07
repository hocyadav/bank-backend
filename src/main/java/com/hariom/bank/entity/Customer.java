package com.hariom.bank.entity;

import java.util.List;

import com.hariom.bank.entity.bankAccount.BankAccount;
/**
 * Customer entity
 * @author Hariom Yadav | 06-Jun-2020
 *
 */
public class Customer {

	String panNumber;
	List<BankAccount> accounts;

	public Customer() {}

	public Customer(String panNumber, List<BankAccount> accounts) {
		super();
		this.panNumber = panNumber;
		this.accounts = accounts;
	}
	public String getPanNumber() {
		return panNumber;
	}
	public void setPanNumber(String panNumber) {
		this.panNumber = panNumber;
	}
	public List<BankAccount> getAccounts() {
		return this.accounts;
	}
	public void setAccounts(List<BankAccount> accounts) {
		this.accounts = accounts;
	}

	@Override
	public String toString() {
		return "Customer [panNumber=" + panNumber + ", accounts=" + accounts + "]";
	}

}
