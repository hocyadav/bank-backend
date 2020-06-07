package com.hariom.bank.entity;

import java.util.LinkedList;
import java.util.List;
/**
 * HeadOffice entity 
 * @author Hariom Yadav | 06-Jun-2020
 *
 */
public class HeadOffice {

	List<Branch> branches = new LinkedList<>();

	public HeadOffice() {}

	public HeadOffice(List<Branch> branches) {
		super();
		this.branches = branches;
	}

	public List<Branch> getBranches() {
		return branches;
	}

	public void setBranches(List<Branch> branches) {
		this.branches = branches;
	}

	@Override
	public String toString() {
		return "HeadOffice [branches=" + branches + "]";
	}

}
