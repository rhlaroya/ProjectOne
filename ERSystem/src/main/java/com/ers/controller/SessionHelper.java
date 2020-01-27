package com.ers.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class SessionHelper {

	public static String process(HttpServletRequest req) {
		switch(req.getRequestURI()) {
		case "/ERSystem/set.session":
			HttpSession session = req.getSession();
			String username = req.getParameter("username");
			String password = req.getParameter("password");
			session.setAttribute("username", username);
			session.setAttribute("password", password);
			break;
		case "/ERSystem/print.session":
			HttpSession currentSession = req.getSession(true);
			String user = (String)currentSession.getAttribute("username"); //can store objects
			String pass = (String)currentSession.getAttribute("password");
			System.out.println(user + "\t" + pass);
			break;
		case "/ERSystem/clear.session":
			req.getSession().invalidate();
			break;
		}
		return "html/employee.html";
	}
}
