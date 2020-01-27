package com.ers.service;

import java.sql.Timestamp;

import com.ers.DAO.ReimbursementDao;
import com.ers.DAO.UserDao;
import com.ers.model.Reimbursement;
import com.ers.model.User;

public class CreateService {
	
	public static void createReimbursement(int id, int amount, Timestamp submitted, Timestamp resolved,
			String description, byte receipt, int author, int resolver, int status_id, int type_id) {
		 int result = new ReimbursementDao().insert(new Reimbursement(id,amount,submitted,resolved,description,receipt,author,
				resolver,status_id,type_id));
	}
	
	public static void createUser(int user_id, String username, String password, String first_name, String last_name, String email,
			int role_id) {
		int result = new UserDao().insert(new User(user_id, username, password, first_name, last_name, email,role_id));
	}
	
	
}
