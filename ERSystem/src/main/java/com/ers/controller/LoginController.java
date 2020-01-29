package com.ers.controller;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.xml.bind.DatatypeConverter;

import com.ers.DAO.UserDao;
import com.ers.model.User;

public class LoginController {
	
	public static String login(HttpServletRequest req) throws NoSuchAlgorithmException {
		System.out.println(req.getMethod());
		if(req.getMethod().toLowerCase().equals("post")) {
			String username = req.getParameter("user");
			String password = req.getParameter("pass");
			String enc = encrypt(password);
			
//	    	UserDao ud = new UserDao();
//	    	List<User> list = ud.getAll();
//
//	    	for(User e: list) {
//	    		System.out.println("input pass:"+enc  +" the pass:"+e.getPassword());
//	    		if(e.getUsername().equals(username) && e.getPassword().equals(enc)) {
//	    			System.out.print("it worked");
//	    		}
//	    	}
			
			if(username.equals("manager") && password.equals("pass1234")) {
				HttpSession session = req.getSession();
				session.setAttribute("username", username);
				 return "manager.html";
			} else {
				return "employee.html";
			}
		}
		return "index.html";
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
