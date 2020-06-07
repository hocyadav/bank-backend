package com.hariom.bank.entity;

import java.util.List;

import org.springframework.boot.autoconfigure.domain.EntityScan;

import com.hariom.bank.entity.bankAccount.BankAccount;
/**
 * Branch entity
 * @author Hariom Yadav | 06-Jun-2020
 *
 */
public class Branch {

	String branchID;
	List<Customer> customers;
	List<BankAccount> bankAccounts;

	public Branch() {}

	public Branch(String branchID, List<Customer> customers, List<BankAccount> bankAccounts) {
		super();
		this.branchID = branchID;
		this.customers = customers;
		this.bankAccounts = bankAccounts;
	}

	public String getBranchID() {
		return branchID;
	}
	public void setBranchID(String branchID) {
		this.branchID = branchID;
	}
	public List<Customer> getCustomers() {
		return customers;
	}
	public void setCustomers(List<Customer> customers) {
		this.customers = customers;
	}
	public List<BankAccount> getBankAccounts() {
		return bankAccounts;
	}
	public void setBankAccounts(List<BankAccount> bankAccounts) {
		this.bankAccounts = bankAccounts;
	}
	@Override
	public String toString() {
		return "Branch [branchID=" + branchID + ", customers=" + customers + ", bankAccounts=" + bankAccounts + "]";
	}

}
