package com.hariom.bank.api;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.hariom.bank.entity.Transaction;
import com.hariom.bank.service.BranchService;
/**
 * All Transactions API
 * @author Hariom Yadav | 07-Jun-2020
 *
 */
@RestController
@RequestMapping("/bank")
public class TransactionController {
	
	@Autowired
	private BranchService branchService;
	
	@RequestMapping(value = "/{branch_id}/txn",
			method = RequestMethod.GET)
	public List<Transaction> printBranchNumber(
			@PathVariable("branch_id") Integer branch_id){
		
		return branchService.getAllTxnInBranch(branch_id);
		
	}
}
