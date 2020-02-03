package com.ers.controller;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.ers.DAO.UserDao;
import com.ers.model.User;
import com.ers.service.UserService;

@WebServlet(name = "LoginController", urlPatterns = {"/LoginController"})
public class LoginController {
	
	public static String login(HttpServletRequest req) throws NoSuchAlgorithmException, IOException, ClassNotFoundException {
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
				System.out.println(req.getSession().toString());
			}
	
			if(roles == 1) {	
				 path = "alltickets.html";
			} else if(roles == 2) {
				path = "employee.html";
			}
		}
		return path;
	}
}
