package com.ers.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ers.DAO.ReimbursementDao;
import com.ers.model.Reimbursement;

public class ReimbursementService {
	
	public static ArrayList<String[]> getById(int id) throws ClassNotFoundException, SQLException {
		return new ReimbursementDao().getReimbEmp(id);
	}
	
	public static List<String[]> getAll() throws ClassNotFoundException, SQLException {
		return new ReimbursementDao().getAll();
	}
}
