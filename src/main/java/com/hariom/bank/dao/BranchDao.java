package com.hariom.bank.dao;

import java.util.Collection;

import com.hariom.bank.entity.Branch;
/**
 * Branch DAO Interface
 * @author Hariom Yadav | 06-Jun-2020
 *
 */
public interface BranchDao {

	Collection<Branch> getAllBranch();

	Branch getBranchById(int id);

	void removeBranchById(int id);

	void insertBranch();

}