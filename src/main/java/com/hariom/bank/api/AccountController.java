package com.hariom.bank.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.hariom.bank.entity.bankAccount.BankAccount;
import com.hariom.bank.service.BranchService;
/**
 * All Account API
 * @author Hariom Yadav | 06-Jun-2020
 *
 */
@RestController
@RequestMapping("/bank")
public class AccountController {
	
	@Autowired
	private BranchService branchService;
	
	@RequestMapping(value = "/{id}/accounts", 
			method = RequestMethod.GET)
	public List<BankAccount>  getAllAccountsInBranch(@PathVariable("id") Integer id){
		
		return branchService.getAllAccountsInBranch(id);
		
	}
}
