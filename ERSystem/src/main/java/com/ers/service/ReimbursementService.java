package com.ers.service;

import com.ers.DAO.ReimbursementDao;
import com.ers.model.Reimbursement;

public class ReimbursementService {
	
	public static Reimbursement getById(int id) {
		return new ReimbursementDao().getById(id);
	}
}
