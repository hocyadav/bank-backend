package com.hariom.bank.service;

import java.util.LinkedList;
import java.util.List;

import org.springframework.stereotype.Service;
import com.hariom.bank.entity.Branch;
import com.hariom.bank.util.Constants;
/**
 * Head Office Service implementation 
 * @author Hariom Yadav | 06-Jun-2020
 *
 */
@Service
public class HeadOfficeServiceImpl implements HeadOfficeService {

	private List<Branch> branches = new LinkedList<>();

	@Override
	public List<Branch> getBranches() {
		return branches;
	}

	@Override
	public void createBranch(){
		Branch branch = new Branch();
		System.out.println(Constants.BRANCH_OK + branch.getBranchID());
		this.branches.add(branch);
	}

	@Override
	public Branch getBranchById(String branchID) {
		Branch branch_ = null;
		for(Branch b : this.branches) {
			if(b.getBranchID().equalsIgnoreCase(branchID)) {
				branch_ = b;
				break;
			}
		}
		if(branch_ == null) {
			System.err.println(Constants.BRANCH_NOT_AVAIL);
		}
		return branch_;
	}

	@Override
	public List<Branch> getAllBranches() {
		return this.branches;
	}
}
