package com.ers.service;

import java.sql.SQLException;
import java.util.ArrayList;

import com.ers.DAO.ReimbursementDao;
import com.ers.model.Reimbursement;

public class ReimbursementService {
	
	public static ArrayList<Reimbursement> getById(int id) throws ClassNotFoundException, SQLException {
		return new ReimbursementDao().getReimbEmp(id);
	}
}
