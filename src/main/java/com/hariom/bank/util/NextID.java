package com.hariom.bank.util;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Get Next Unique Number
 * @author Hariom Yadav | 06-Jun-2020
 *
 */
public class NextID {

	private static final AtomicInteger accountNumber = new AtomicInteger(0);
	private static final AtomicInteger transactionID = new AtomicInteger(0);
	private static final AtomicInteger branchID = new AtomicInteger(0);
	private static final AtomicInteger branchDAO = new AtomicInteger(0);
	private static final AtomicInteger customerDAO = new AtomicInteger(0);

	public static Integer accNu() {
		return accountNumber.incrementAndGet();
	}

	public static Integer txnID() {
		return transactionID.incrementAndGet();
	}

	public static Integer branchID() {
		return branchID.incrementAndGet();
	}
	public static Integer branchDAO() {
		return branchDAO.incrementAndGet();
	}

	public static Integer customerDAO() {
		return customerDAO.incrementAndGet();
	}
}
