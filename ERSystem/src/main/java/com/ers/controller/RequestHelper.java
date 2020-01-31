package com.ers.controller;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ers.controller.LoginController;

public class RequestHelper {

	public static String process(HttpServletRequest req) throws NoSuchAlgorithmException, IOException, ClassNotFoundException {
		switch(req.getRequestURI()) {
		case "/ERSystem/html/create.reimb":
			return CreateController.createRmbrsmt(req);
		case "/ERSystem/html/login.go":
			return LoginController.login(req);
		default:
			return "";
		}	
	}
	
	public static void directProcess(HttpServletRequest req, HttpServletResponse resp) throws ClassNotFoundException, SQLException {
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
