package com.hariom.bank.util;

/**
 * All Constants
 * @author Hariom Yadav | 06-Jun-2020
 *
 */
public class Constants {
	
	public static final Double SAVING_MIN_BALANCE = new Double(20000.0);
	public static final Double SAVING_INTEREST_RATE = new Double(4.5);
	
	public static final Double CURRENT_MIN_BALANCE = new Double(10000.0);
	public static final Double CURRENT_INTEREST_RATE = new Double(0);
	
	public static final String SAVING = "Saving";
	public static final String CURRENT = "Current";
	public static final String WITHDRAW = "withdraw";
	public static final String DEPOSIT = "deposit";
	public static final String AMOUNT_GT = "Transaction FAIL : Amount Greater than available Balance !!";
	public static final String AMOUNT_LS = "Transaction FAIL : Amount Less than 0 !!";
	public static final String TYPE_NOT_OK = "Transaction FAIL : Transaction type is not correct !!";
	public static final String TXN_OK = "Transaction COMPLETED !!";
	public static final String BRANCH_OK = "New Branch Created !!";
	public static final String BRANCH_NOT_AVAIL = "ERROR : Branch not found";
	public static final String BRANCH_h = "Branch #";
	public static final String PAN_NOT_AVAIL = "Customer not found with PAN # ";
	public static final String CUST_NOT_AVAIL = "Bank account not found with customer ID # ";
	public static final String NEW_CUST_OK = "New Customer Created OR Updated Old Customer";
	public static final String NEW_CUST_ADDED = "New Customer Added !!";
	public static final String ACCOUNT_TYPE_NOT_CORRECT = "Account type not currect : ";
	public static final String CUSTOMER_AVAIL = "Customer already present adding new account";
	
}
