package com.ers.controller;

import javax.servlet.http.HttpServletRequest;

public class LoginController {
	
	public static String login(HttpServletRequest req) {
		System.out.println(req.getMethod());
		if(req.getMethod().toLowerCase().equals("post")) {
			String username = req.getParameter("username");
			String password = req.getParameter("password");
			
			if(username.equals("manager") && password.equals("pass1234")) {
				return "html/manager.html";
			} else {
				return "html/employee";
			}
		}
		return "html/index.html";
	}
}
