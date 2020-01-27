package com.ers.service;

import com.ers.DAO.UserDao;
import com.ers.model.Reimbursement;
import com.ers.model.User;

public class UserService {
	
	public static User getById(int id) {
		return new UserDao().getById(id);
	}
	
	public void verifyLoginCredientials(String username, String password) {
		
	}
	
	public Reimbursement retreiveReimbursements(User user) {
		return null;
	}
	
	public void registerUser(User user) {
		
	}
}
