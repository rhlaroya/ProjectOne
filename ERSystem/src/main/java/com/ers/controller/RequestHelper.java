package com.ers.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RequestHelper {

	public static String process(HttpServletRequest req) {
		switch(req.getRequestURI()) {
		case "ERSystem/create.reimb":
			return CreateController.createRmbrsmt(req);
			
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
