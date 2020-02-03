package com.ers.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.ers.DAO.ReimbursementDao;
import com.ers.DAO.UserDao;
import com.ers.model.Reimbursement;
import com.ers.model.User;

public class UserService {
	
	public static User getById(int id) {
		return new UserDao().getById(id);
	}
	public int verifyLoginCredientials(String username, String password) throws ClassNotFoundException {
		int yes = -1;
		try {
	        Class.forName("org.postgresql.Driver");
	        Connection con = DriverManager.getConnection("jdbc:postgresql://regaedb.ce8a70kibcmu.us-east-2.rds.amazonaws.com:5432/projectone","admin", "password");
			PreparedStatement ps = con.prepareStatement("select * from ersystem.\"ers-users\" where ers_password = md5(?||?||'password')");
			ps.setString(1, username);
			ps.setString(2, password);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				 yes = Integer.parseInt(rs.getString("ers_users_id"));
			}
			return yes;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return yes;
	}
	
	public void retreiveReimbursements(HttpServletRequest req, HttpServletRequest resp) throws ClassNotFoundException, SQLException {
		int id = (int) req.getAttribute("id");
		ReimbursementDao rd = new ReimbursementDao();
		ArrayList<String[]> reimb 	= rd.getReimbEmp(id);
	}
	
	public void retreiveAllReimbursements(HttpServletRequest req, HttpServletRequest resp) throws ClassNotFoundException, SQLException {
		ReimbursementDao r = new ReimbursementDao();
		List<String[]> allreimb = r.getAll();
	}
	
	public void registerUser(User user) {
		
	}
}
