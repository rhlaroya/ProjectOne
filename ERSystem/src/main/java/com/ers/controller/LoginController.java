package com.ers.controller;

import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.xml.bind.DatatypeConverter;

import com.ers.DAO.UserDao;
import com.ers.model.User;
import com.ers.service.UserService;

@WebServlet(name = "LoginController", urlPatterns = {"/LoginController"})
public class LoginController {
	
	public static String login(HttpServletRequest req) throws NoSuchAlgorithmException, IOException, ClassNotFoundException {
		//System.out.println(req.getMethod());
		String path = "index.html";
		int roles = -1;
		if(req.getMethod().toLowerCase().equals("post")) {
			String username = req.getParameter("user");
			String password = req.getParameter("pass");
			
			UserService us = new UserService();
			if(us.verifyLoginCredientials(username, password)!=-1) {
				HttpSession session = req.getSession();
				session.setAttribute("id", us.verifyLoginCredientials(username, password));
				UserDao ud = new UserDao();				
				User users = ud.getById(us.verifyLoginCredientials(username, password));
				roles = users.getRole_id();
				System.out.println(req.getSession());
			}
			
			if(roles == 1) {	
				 path = "manager.html";
			} else if(roles == 2) {
				path = "employee.html";
			}
		}
		return path;
	}
	
	public static String encrypt(String password) 
			  throws NoSuchAlgorithmException {
			    String hash = "35454B055CC325EA1AF2126E27707052";
			    
			         
			    MessageDigest md = MessageDigest.getInstance("MD5");
			    md.update(password.getBytes());
			    byte[] digest = md.digest();
			    String myHash = DatatypeConverter
			      .printHexBinary(digest).toUpperCase();
			    
			    return myHash;
			}
	
//	package com.ers.controller;
//
//	import javax.servlet.http.HttpServletRequest;
//
//	public class LoginController {
//		
//		public static String login(HttpServletRequest req) {
//			System.out.println(req.getMethod());
//			if(req.getMethod().toLowerCase().equals("post")) {
//				String username = req.getParameter("user");
//				String password = req.getParameter("pass");
//				
//				if(username.equals("manager") && password.equals("pass1234")) {
//					 "manager.html";
//				} else {
//					return "employee.html";
//				}
//			}
//			return "index.html";
//		}
	

}
