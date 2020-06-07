package com.hariom.bank.entity.bankAccount;

import java.util.LinkedList;

import com.hariom.bank.entity.Transaction;
import com.hariom.bank.util.Constants;
import com.hariom.bank.util.NextID;
/**
 * CurrentAccount implementation class
 * @author Hariom Yadav | 06-Jun-2020
 *
 */
public class CurrentAccount extends BankAccount{

	public CurrentAccount() {
		super(NextID.accNu().toString(), 
				Constants.CURRENT_MIN_BALANCE, 
				new Double(0.0), 
				Constants.CURRENT_INTEREST_RATE, 
				new LinkedList<Transaction>());
	}

	@Override
	public String getAccountType() {
		return Constants.CURRENT;
	}
}
