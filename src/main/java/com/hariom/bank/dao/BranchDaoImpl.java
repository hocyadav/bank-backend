package com.hariom.bank.dao;

import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.hariom.bank.entity.Branch;
import com.hariom.bank.entity.Customer;
import com.hariom.bank.entity.Transaction;
import com.hariom.bank.entity.bankAccount.BankAccount;
import com.hariom.bank.entity.bankAccount.CurrentAccount;
import com.hariom.bank.entity.bankAccount.SavingAccount;
import com.hariom.bank.util.DateTimeUtil;
import com.hariom.bank.util.NextID;
/**
 * Branch In memory Database
 * @author Hariom Yadav | 06-Jun-2020
 *
 */
@Repository
@Qualifier("fakeDB")
public class BranchDaoImpl implements BranchDao {
	private static Map<Integer, Branch> branches;

	static {//dummy data : In memory data

		branches = new HashMap<Integer, Branch>(){
			{	//LOGIC : txn obj -> bank acc obj -> customer obj -> branch obj
				
				Transaction txnObj = 
						new Transaction(NextID.txnID().toString(), new Double(2000), "deposit", DateTimeUtil.dateTime());
				
				BankAccount bankObj = new CurrentAccount();
				//currentBankAccount.getListOfTxns().add(transaction);
				
				BankAccount savingBankAccount = new SavingAccount();
				savingBankAccount.getListOfTxns().add(txnObj);
				
				List<BankAccount> allAcc = new LinkedList<BankAccount>();
				allAcc.add(bankObj);
				allAcc.add(savingBankAccount);
				
				Customer customer = new Customer("ABC123", allAcc);
				//Customer customer2 = new Customer("98877ABd", allAcc);

				List<Customer> allCustObj = new LinkedList<Customer>();
				allCustObj.add(customer); 
				//customers.add(customer2);

				List<BankAccount> accounts = new LinkedList<BankAccount>();
				accounts.add(bankObj); accounts.add(savingBankAccount);
				Integer id1 = NextID.branchDAO();
				put(id1, new Branch(id1.toString(), allCustObj, accounts));
				
				//Uncomment to add new dummy branch
				
//				Integer id2 = NextID.branchDAO();
//				put(id2, new Branch(id2.toString(), customers, accounts));
//				Integer id3 = NextID.branchDAO();
//				put(id3, new Branch(id3.toString(), customers, accounts));

			}
		};
	}

	@Override
	public Collection<Branch> getAllBranch(){
		return branches.values();
	}

	@Override
	public Branch getBranchById(int id){
		return branches.get(id); 
	}

	@Override
	public void removeBranchById(int id) {
		branches.remove(id);
	}

	@Override
	public void insertBranch(){
		Branch branch = newBranchUtil();
		this.branches.put(Integer.parseInt(branch.getBranchID()), branch);
	}

	private Branch newBranchUtil() {

		List<Customer> customers = new LinkedList<Customer>();
		List<BankAccount> accounts = new LinkedList<BankAccount>();
		
		Integer id1 = NextID.branchDAO();
		Branch branch = new Branch(id1.toString(), customers, accounts);
		return branch;
	}

}
