package com.hariom.bank.entity;

/**
 * Transaction entity
 * @author Hariom Yadav | 06-Jun-2020
 *
 */
public class Transaction {
	String transactionID;
	Double amount;
	String type;
	String txnDate;
	
	public Transaction() {}
	
	public Transaction(String transactionID, Double amount, String type, String txnDate) {
		super();
		this.transactionID = transactionID;
		this.amount = amount;
		this.type = type;
		this.txnDate = txnDate;
	}
	public String getTransactionID() {
		return transactionID;
	}
	public void setTransactionID(String transactionID) {
		this.transactionID = transactionID;
	}
	public Double getAmount() {
		return amount;
	}
	public void setAmount(Double amount) {
		this.amount = amount;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}

	public String getTxnDate() {
		return txnDate;
	}

	public void setTxnDate(String txnDate) {
		this.txnDate = txnDate;
	}

	@Override
	public String toString() {
		return "Transaction [transactionID=" + transactionID + ", amount=" + amount + ", type=" + type + ", txnDate="
				+ txnDate + "]";
	}
}
