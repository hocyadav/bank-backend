package com.hariom.bank.entity.bankAccount;

import java.util.LinkedList;

import com.hariom.bank.entity.Transaction;
import com.hariom.bank.util.Constants;
import com.hariom.bank.util.NextID;
/**
 * SavingAccount implementation class
 * @author Hariom Yadav | 06-Jun-2020
 *
 */
public class SavingAccount extends BankAccount{

	public SavingAccount() {
		super(NextID.accNu().toString(), 
				Constants.SAVING_MIN_BALANCE, 
				new Double(0.0), 
				Constants.SAVING_INTEREST_RATE, 
				new LinkedList<Transaction>());
	}

	@Override
	public String getAccountType() {
		return Constants.SAVING;
	}
}
