package com.hariom.bank.dao;

import java.util.Collection;

import com.hariom.bank.entity.Customer;
import com.hariom.bank.entity.NewAccount;
/**
 * Customer DAO interface
 * @author Hariom Yadav | 06-Jun-2020
 *
 */
public interface CustomerDao {

	Collection<Customer> getAllCustomer();

	Customer getCustomerById(int id);

	void removeCustomerById(int id);

	Customer getCustomerByPan(String pan);

	String insertCustomer(NewAccount newAccount, Integer branch_id);

}