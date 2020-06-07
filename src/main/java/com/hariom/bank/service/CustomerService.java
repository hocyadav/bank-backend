package com.hariom.bank.service;

import java.util.Collection;

import com.hariom.bank.entity.Customer;
import com.hariom.bank.entity.NewAccount;
/**
 * 
 * @author Hariom Yadav | 06-Jun-2020
 *
 */
public interface CustomerService {

	Collection<Customer> getAllCustomer();

	Customer getCustomerById(int id);

	void removeCustomerById(int id);

	String insertCustomer(NewAccount newAccount, Integer branch_id);

	Customer getCustomerByPan(String panNumber);

}