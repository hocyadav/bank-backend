package com.hariom.bank.service;

import java.util.List;

import com.hariom.bank.entity.Branch;
/**
 * 
 * @author Hariom Yadav | 06-Jun-2020
 *
 */
public interface HeadOfficeService {

	List<Branch> getBranches();

	void createBranch();

	Branch getBranchById(String branchID);

	List<Branch> getAllBranches();

}