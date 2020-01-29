package com.ers.service;

import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import com.ers.DAO.UserDao;
import com.ers.model.Reimbursement;
import com.ers.model.User;

public class UserService {
	
	public static User getById(int id) {
		return new UserDao().getById(id);
	}
	
	public void verifyLoginCredientials(String username, String password) {
//        String path = "index.html";
//        boolean exist = false;
//        int uID = 0;
//        int uRole = 0;
//        
//        String uname = request.getParameter("uname");
//        String passw = request.getParameter("passw");
//        
//        HttpSession session=request.getSession();  
////session.setAttribute("uname",n);  
//        UserDAO ud = new UserDAO();
//        ArrayList<User> users = ud.retrieve();
//
//        for(User e: users){
//            if(uname.equals(e.getUsername())){
//                if(Encrypt.checkpw(passw, e.getPassword())){
//                    exist = true;
//                    uID = e.getId();
//                    uRole = e.getRoleID();
//                }
//            }
//        }
//        
//        if(exist){
//            session.setAttribute("id", uID);
//            if(uRole == 1){
//                path="finmanger/home.html";
//            }
//            
//            if(uRole == 2){
//                path="employee/home.html";                        
//            }
//        }
//        
//        response.sendRedirect(path);
	}
	
	public Reimbursement retreiveReimbursements(User user) {
		return null;
	}
	
	public void registerUser(User user) {
		
	}
}
