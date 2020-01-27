package com.ers.controller;

import java.io.IOException;
import java.sql.Timestamp;

import javax.servlet.http.HttpServletRequest;

import com.ers.model.Reimbursement;
import com.ers.service.CreateService;
import com.fasterxml.jackson.databind.ObjectMapper;

public class CreateController {
	
	public static String createRmbrsmt(HttpServletRequest req) {
		int id = Integer.parseInt(req.getParameter("id"));
		int amount = Integer.parseInt(req.getParameter("amount"));
		Timestamp submitted = Timestamp.valueOf(req.getParameter("submitted"));
		Timestamp resolved = Timestamp.valueOf(req.getParameter("resolved"));
		String description = req.getParameter("description");
		byte receipt = Byte.parseByte(req.getParameter("receipt"));
		int author = Integer.parseInt(req.getParameter("author"));
		int resolver = Integer.parseInt(req.getParameter("resolver"));
		int status_id = Integer.parseInt(req.getParameter("status_id"));
		int type_id = Integer.parseInt(req.getParameter("type_id"));
		CreateService.createReimbursement(id, amount, submitted, resolved, description, receipt, author, resolver, status_id, type_id);
		createFromJson(req);
		return "index.html";
	}
	
	public static String createUsr(HttpServletRequest req) {
		int user_id = Integer.parseInt(req.getParameter("user_id"));
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		String first_name = req.getParameter("first_name");
		String last_name = req.getParameter("last_name");
		String email = req.getParameter("email");
		int role_id = Integer.parseInt(req.getParameter("role_id"));
		CreateService.createUser(user_id, username, password, first_name, last_name, email, role_id);
		createFromJson(req);
		return "index.html";
	}
	
	public static void createFromJson(HttpServletRequest req) {
		ObjectMapper om = new ObjectMapper();
		String line = "";
		String temp;
		try {
			while((temp=req.getReader().readLine())!=null){
				line += temp;
			}
			Reimbursement r = om.readValue(line, Reimbursement.class);
			System.out.println(r);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
