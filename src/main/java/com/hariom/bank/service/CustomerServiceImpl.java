package com.hariom.bank.service;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.hariom.bank.dao.CustomerDao;
import com.hariom.bank.entity.Customer;
import com.hariom.bank.entity.NewAccount;
import com.hariom.bank.util.Constants;
/**
 * Customer Service implementation 
 * @author Hariom Yadav | 06-Jun-2020
 *
 */
@Service
public class CustomerServiceImpl implements CustomerService {
	
	@Autowired
	@Qualifier("fakeDB")
	private CustomerDao customerDao;
	
	@Override
	public Collection<Customer> getAllCustomer(){
        return customerDao.getAllCustomer();
    }
	
    @Override
	public Customer getCustomerById(int id){
        return customerDao.getCustomerById(id); 
    }

    @Override
	public void removeCustomerById(int id) {
    	customerDao.removeCustomerById(id);
    }

    @Override
	public String insertCustomer(NewAccount newAccount, Integer branch_id) {
    	return customerDao.insertCustomer(newAccount, branch_id);
    }

    @Override
	public Customer getCustomerByPan(String panNumber) {
    	List<Customer> allCustomer = (List<Customer>) customerDao.getAllCustomer();
    	
    	for(Customer customer : allCustomer) {
    		if(customer.getPanNumber().equalsIgnoreCase(panNumber)) {
    			return customer;
    		}
    	}
    	System.err.println(Constants.PAN_NOT_AVAIL + panNumber);
    	return null;
    }
}
