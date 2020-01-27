package com.ers.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ers.model.Reimbursement;
import com.ers.model.User;
import com.ers.service.ReimbursementService;
import com.ers.service.UserService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JacksonController {

	public static void sendReimbursement(HttpServletRequest req, HttpServletResponse resp) {
		new ReimbursementService();
		Reimbursement r = ReimbursementService.getById(
				Integer.parseInt(
						req.getParameter("id")));
		try {
			resp.getWriter()
			.write(
					new ObjectMapper()
					.writeValueAsString(r));
			
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void sendUser(HttpServletRequest req, HttpServletResponse resp) {
		new ReimbursementService();
		User u = UserService.getById(
				Integer.parseInt(
						req.getParameter("id")));
		try {
			resp.getWriter()
			.write(
					new ObjectMapper()
					.writeValueAsString(u));
			
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}
