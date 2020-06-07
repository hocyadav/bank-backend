package com.hariom.bank.service;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import com.hariom.bank.entity.Branch;
import com.hariom.bank.entity.Customer;
import com.hariom.bank.entity.Transaction;
import com.hariom.bank.entity.bankAccount.BankAccount;
/**
 * 
 * @author Hariom Yadav | 06-Jun-2020
 *
 */
public interface BranchService {

	Collection<Branch> getAllBranch();

	Branch getBranchById(int id);

	Customer getCustomerInBranch(int branchId, String custPan);

	BankAccount getCustomerAllAccountInBranch(int branchId, String custPan, String custAccId);

	Collection<Transaction> getCustomerAllTxns(int branchId, String custPan, String custAccId);

	String newTxn(Transaction newTxn, int branchId, String custPan, String custAccId);

	LinkedList<Transaction> getCustomerMiniSt(Integer branchId, String custPan, String custAccId);

	void removeBranchById(int id);

	void createNewBranch();

	Map<String, Object> printBranchNumber();

	List<BankAccount> getAllAccountsInBranch(Integer id);

	List<Transaction> getAllTxnInBranch(Integer branch_id);

}