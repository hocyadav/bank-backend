package com.hariom.bank.service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.hariom.bank.dao.BranchDao;
import com.hariom.bank.entity.Branch;
import com.hariom.bank.entity.Customer;
import com.hariom.bank.entity.Transaction;
import com.hariom.bank.entity.bankAccount.BankAccount;
import com.hariom.bank.util.Constants;
import com.hariom.bank.util.DateTimeUtil;
import com.hariom.bank.util.NextID;
/**
 * Branch Service implementation 
 * @author Hariom Yadav | 06-Jun-2020
 *
 */
@Service
public class BranchServiceImpl implements BranchService {

	@Autowired
	@Qualifier("fakeDB")
	private BranchDao branchDao;

	@Override
	public Collection<Branch> getAllBranch(){
		return branchDao.getAllBranch();
	}

	@Override
	public Branch getBranchById(int id){
		return branchDao.getBranchById(id);
	}

	@Override
	public Customer getCustomerInBranch(int branchId, String custPan){
		Branch branchById = branchDao.getBranchById(branchId);
		System.out.println(branchById);

		List<Customer> allCustomers = branchById.getCustomers();
		for(Customer customer : allCustomers) {
			if(customer.getPanNumber().equalsIgnoreCase(custPan)) {
				return customer;
			}
		}
		System.err.println(Constants.PAN_NOT_AVAIL + custPan);

		return null;
	}

	@Override
	public BankAccount getCustomerAllAccountInBranch(int branchId, String custPan, String custAccId) {

		Customer customer = getCustomerInBranch(branchId, custPan);
		System.out.println(customer);
		Collection<BankAccount> accounts = customer.getAccounts();

		for(BankAccount account : accounts) {
			if(account.getAccountNumber().equalsIgnoreCase(custAccId)) {
				return account;
			}
		}
		System.err.println(Constants.CUST_NOT_AVAIL + custAccId);
		return null;
	}

	@Override
	public Collection<Transaction> getCustomerAllTxns(int branchId, String custPan, String custAccId) {

		BankAccount bankAccount = getCustomerAllAccountInBranch(branchId, custPan, custAccId);
		List<Transaction> listOfTxns = bankAccount.getListOfTxns();
		return listOfTxns;
	}

	@Override
	public String newTxn(Transaction newTxn, int branchId, String custPan, String custAccId) {
		Transaction txn = new Transaction(NextID.txnID().toString(), newTxn.getAmount(), newTxn.getType(), DateTimeUtil.dateTime());;
		BankAccount account = getCustomerAllAccountInBranch(branchId, custPan, custAccId);
		Double currentBalance = account.getCurrentBalance();

		if(txn.getType().equalsIgnoreCase(Constants.WITHDRAW)) {
			if(newTxn.getAmount() > currentBalance) {
				System.err.println(Constants.AMOUNT_GT);
				return Constants.AMOUNT_GT;
			} else {
				account.setCurrentBalance(currentBalance - newTxn.getAmount());
				account.getListOfTxns().add(txn);
				System.out.println(Constants.TXN_OK);
				return Constants.TXN_OK;
			}
		} else if(txn.getType().equalsIgnoreCase(Constants.DEPOSIT)) {
			if(newTxn.getAmount() < 0) {
				System.err.println(Constants.AMOUNT_LS);
				return Constants.AMOUNT_LS;
			} else {
				account.setCurrentBalance(currentBalance + newTxn.getAmount()); 
				account.getListOfTxns().add(txn);
				System.out.println(Constants.TXN_OK);
				return Constants.TXN_OK;
			}
		} else {
			System.err.println(Constants.TYPE_NOT_OK);
			return Constants.TYPE_NOT_OK;
		}
	}

	@Override
	public LinkedList<Transaction> getCustomerMiniSt(Integer branchId, String custPan, String custAccId) {
		BankAccount account = getCustomerAllAccountInBranch(branchId, custPan, custAccId);
		List<Transaction> allTxn = account.getListOfTxns();
		LinkedList<Transaction> mini = new LinkedList();
		int temp = (allTxn.size() >= 10) ? 10 : allTxn.size();
		for(int i = 0; i < temp; i++) {
			mini.add(allTxn.get(i));
		}
		return mini;
	}

	@Override
	public void removeBranchById(int id) {
		branchDao.removeBranchById(id);
	}

	@Override
	public void createNewBranch(){
		this.branchDao.insertBranch();
	}

	@Override
	public Map<String, Object> printBranchNumber() {
		Map<String, Object> addUser = new HashMap<>();

		Iterator<Branch> it = this.getAllBranch().iterator();
		Integer i = 1;
		while(it.hasNext()) {
			Branch next = it.next();
			String key = Constants.BRANCH_h + i.toString();
			addUser.put(key, next.getBranchID());
			i++;
		}
		return addUser;
	}
	
	@Override
	public List<BankAccount> getAllAccountsInBranch(Integer id) {
		return getBranchById(id).getBankAccounts();
	}

	@Override
	public List<Transaction> getAllTxnInBranch(Integer branch_id) {
		Branch branch = this.getBranchById(branch_id);
		List<Transaction> allTxn = new LinkedList<Transaction>();
		
		List<Customer> allCust = branch.getCustomers();
		for(Customer customer : allCust) {
			List<BankAccount> accounts = customer.getAccounts();
			for(BankAccount account : accounts) {
				List<Transaction> listOfTxns = account.getListOfTxns();
				allTxn.addAll(listOfTxns);
			}
		}
		return allTxn;
	}
}
