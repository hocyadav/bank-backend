package com.hariom.bank.dao;

import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.hariom.bank.entity.Branch;
import com.hariom.bank.entity.Customer;
import com.hariom.bank.entity.NewAccount;
import com.hariom.bank.entity.Transaction;
import com.hariom.bank.entity.bankAccount.BankAccount;
import com.hariom.bank.entity.bankAccount.CurrentAccount;
import com.hariom.bank.entity.bankAccount.SavingAccount;
import com.hariom.bank.util.Constants;
import com.hariom.bank.util.DateTimeUtil;
import com.hariom.bank.util.NextID;
/**
 * Customer In memory Database
 * @author Hariom Yadav | 06-Jun-2020
 *
 */
@Repository
@Qualifier("fakeDB")
public class CustomerDaoImpl implements CustomerDao {

	@Autowired
	@Qualifier("fakeDB")
	private BranchDao branchDao;

	private static Map<Integer, Customer> customers;

	static {//dummy data : In memory data

		customers = new HashMap<Integer, Customer>(){
			{	
				Transaction txn = 
						new Transaction(NextID.txnID().toString(), new Double(1000), "deposit", DateTimeUtil.dateTime());

				BankAccount bankAcc = new CurrentAccount();
				bankAcc.getListOfTxns().add(txn);
				List<BankAccount> allAcc = new LinkedList<BankAccount>();
				allAcc.add(bankAcc);
				
				put(NextID.customerDAO(), new Customer("123ABC", allAcc));
			}
		};
	}

	@Override
	public Collection<Customer> getAllCustomer(){
		return customers.values();
	}

	@Override
	public Customer getCustomerById(int id){
		return customers.get(id); 
	}

	@Override
	public void removeCustomerById(int id) {
		customers.remove(id);
	}

	@Override
	public Customer getCustomerByPan(String pan) {
		Collection<Customer> allCustomer = this.getAllCustomer();
		for(Customer customer : allCustomer) {
			if(customer.getPanNumber().equalsIgnoreCase(pan)) {
				return customer;
			}
		}
		System.err.println(Constants.PAN_NOT_AVAIL + pan);
		return null;
	}

	@Override
	public String insertCustomer(NewAccount newAccount, Integer branch_id){
		//1. bank acc obj
		BankAccount bankAccount = null;
		if(newAccount.getAccountType().equalsIgnoreCase(Constants.SAVING)) {
			bankAccount = new SavingAccount();
			bankAccount.setCurrentBalance(newAccount.getInitialBalance());
		}else if(newAccount.getAccountType().equalsIgnoreCase(Constants.CURRENT)){
			bankAccount = new CurrentAccount();
			bankAccount.setCurrentBalance(newAccount.getInitialBalance());
		} else {
			System.err.println(Constants.ACCOUNT_TYPE_NOT_CORRECT + newAccount.getAccountType());
			return Constants.ACCOUNT_TYPE_NOT_CORRECT ;
		}
		//cust obj - old or new
		Customer customer = null;
		String panNumber = newAccount.getPanNumber();
		Branch branchObj = branchDao.getBranchById(branch_id);
		List<Customer> allCust = branchObj.getCustomers();
		boolean custCheck = checkCustPresentOrNot(allCust, panNumber);
		
		if(custCheck == false) {
			customer = new Customer(panNumber, new LinkedList<BankAccount>());
			allCust.add(customer);
			customer.getAccounts().add(bankAccount);//3. add bank account to cust obj
			branchObj.getBankAccounts().add(bankAccount);
			return Constants.NEW_CUST_ADDED;
		} else {
			customer = getCustomerByPAN(allCust, panNumber);
			customer.getAccounts().add(bankAccount);//3. add bank account to cust obj
			branchObj.getBankAccounts().add(bankAccount);
			return Constants.CUSTOMER_AVAIL;
		}
	}

	private Customer getCustomerByPAN(List<Customer> customers2, String panNumber) {
		for(Customer customer : customers2) {
			if(customer.getPanNumber().equalsIgnoreCase(panNumber)) {
				return customer;
			}
		}
		return null;
	}

	private boolean checkCustPresentOrNot(List<Customer> customers2, String panNumber) {
		for(Customer customer: customers2) {
			if(customer.getPanNumber().equalsIgnoreCase(panNumber) ) {
				return true;
			}
		}
		return false;
	}

	private Customer newCustomerUtil(String panNumber) {
		List<BankAccount> accounts = new LinkedList<BankAccount>();
		Customer customer = new Customer(panNumber, accounts);
		return customer;
	}

}
