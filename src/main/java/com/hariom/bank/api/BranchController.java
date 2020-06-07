package com.hariom.bank.api;

import java.util.Collection;
import java.util.LinkedList;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.hariom.bank.entity.Branch;
import com.hariom.bank.entity.Customer;
import com.hariom.bank.entity.Transaction;
import com.hariom.bank.entity.bankAccount.BankAccount;
import com.hariom.bank.service.BranchService;
import com.hariom.bank.util.Constants;
/**
 * All Branch API
 * @author Hariom Yadav | 06-Jun-2020
 *
 */
@RestController
@RequestMapping("/bank")
public class BranchController {

	@Autowired
	private BranchService branchService;

	@RequestMapping(method = RequestMethod.POST, 
			consumes = MediaType.APPLICATION_JSON_VALUE)
	public String insertBranch(){
		
		this.branchService.createNewBranch();
		return Constants.BRANCH_OK;
		
	}

	@RequestMapping(method = RequestMethod.GET)
	public Map<String, Object> printBranchNumber(){
		
		return branchService.printBranchNumber();
		
	}

	@RequestMapping(value = "/{id}", 
			method = RequestMethod.GET)
	public Branch getBranchById(@PathVariable("id") Integer id){
		
		return branchService.getBranchById(id);
		
	}

	@RequestMapping(value = "/{id}/customers", 
			method = RequestMethod.GET)
	public Collection<Customer> getBranch_AllUser(@PathVariable("id") Integer id){
		
		return branchService.getBranchById(id).getCustomers();
		
	}

	@RequestMapping(value = "/{id}/customers/{pan}", 
			method = RequestMethod.GET)
	public Customer getBranch_PanUser(
			@PathVariable("id") Integer id,
			@PathVariable("pan") String pan){
		
		return branchService.getCustomerInBranch(id, pan);
		
	}

	@RequestMapping(value = "/{id}/customers/{pan}/{acc_id}", 
			method = RequestMethod.GET)
	public BankAccount getCustomerAllAccount(
			@PathVariable("id") Integer id, 
			@PathVariable("pan") String pan, 
			@PathVariable("acc_id") String acc_id){
		
		return branchService.getCustomerAllAccountInBranch(id, pan, acc_id);
		
	}

	@RequestMapping(value = "/{id}/customers/{pan}/{acc_id}/mini", 
			method = RequestMethod.GET)
	public LinkedList<Transaction> getCustomerMiniSt(
			@PathVariable("id") Integer id, 
			@PathVariable("pan") String pan, 
			@PathVariable("acc_id") String acc_id){
		
		return branchService.getCustomerMiniSt(id, pan, acc_id);
		
	}

	//new txn -> withdraw and deposit
	@RequestMapping(value = "/{id}/customers/{pan}/{acc_id}", 
			method = RequestMethod.POST)
	public String newTxn(
			@RequestBody Transaction newTxn,
			@PathVariable("id") Integer id, 
			@PathVariable("pan") String pan, 
			@PathVariable("acc_id") String acc_id){
		
		return branchService.newTxn(newTxn, id, pan, acc_id);
		
	}

	@RequestMapping(value = "/{id}/customers/{pan}/{acc_id}/txn", 
			method = RequestMethod.GET)
	public Collection<Transaction> getCustomerTxns(
			@PathVariable("id") Integer id, 
			@PathVariable("pan") String pan, 
			@PathVariable("acc_id") String acc_id){
		
		return branchService.getCustomerAllTxns(id, pan, acc_id);
		
	}

	//TODO : Testing Pending
	//	@RequestMapping(value = "/{id}",
	//			method = RequestMethod.DELETE)
	//	public String removeBranchById(@PathVariable("id") int id) {
	//		branchService.removeBranchById(id);
	//		return "deleted..";
	//	}

}
