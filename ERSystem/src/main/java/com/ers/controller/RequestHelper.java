package com.ers.controller;

import java.security.NoSuchAlgorithmException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ers.controller.LoginController;

public class RequestHelper {

	public static String process(HttpServletRequest req) throws NoSuchAlgorithmException {
		switch(req.getRequestURI()) {
		case "/ERSystem/html/create.reimb":
			return CreateController.createRmbrsmt(req);
		case "/ERSystem/html/login.go":
			return LoginController.login(req);
		default:
			return "";
		}	
	}
	
	public static void directProcess(HttpServletRequest req, HttpServletResponse resp) {
		switch(req.getRequestURI())	{
		case "/ERSystem/user.json":
				JacksonController.sendUser(req, resp);
				break;
		case "/ERSystem/reimb.json":
				JacksonController.sendReimbursement(req, resp);
				break;
		case "/ERSystem/create.json":
			CreateController.createFromJson(req);
		break;
	}
	}
}
