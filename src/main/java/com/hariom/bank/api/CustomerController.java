package com.hariom.bank.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.hariom.bank.entity.NewAccount;
import com.hariom.bank.service.CustomerService;
import com.hariom.bank.util.Constants;
/**
 * All Customer API
 * @author Hariom Yadav | 06-Jun-2020
 *
 */
@RestController
@RequestMapping("/bank")
public class CustomerController {
	
	@Autowired
	private CustomerService customerService;
	
	@RequestMapping(value = "/{branch_id}",
			method = RequestMethod.POST, 
			consumes = MediaType.APPLICATION_JSON_VALUE)
	public String addNewCustomer(
			@RequestBody NewAccount newAccount, 
			@PathVariable("branch_id") Integer branch_id){
		
		return this.customerService.insertCustomer(newAccount, branch_id);
	}
	
	@RequestMapping(value = "/{branch_id}/accounts",
			method = RequestMethod.POST, 
			consumes = MediaType.APPLICATION_JSON_VALUE)
	public String addNewCustomer_via_accAPI(
			@RequestBody NewAccount newAccount, 
			@PathVariable("branch_id") Integer branch_id){
		
		return this.customerService.insertCustomer(newAccount, branch_id);
	}
	
	@RequestMapping(value = "/{branch_id}/customers",
			method = RequestMethod.POST, 
			consumes = MediaType.APPLICATION_JSON_VALUE)
	public String addNewCustomer_via_custAPI(
			@RequestBody NewAccount newAccount, 
			@PathVariable("branch_id") Integer branch_id){
		
		return this.customerService.insertCustomer(newAccount, branch_id);
	}
}
