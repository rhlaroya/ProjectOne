package com.ers.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ers.model.Reimbursement;
import com.ers.model.User;
import com.ers.service.ReimbursementService;
import com.ers.service.UserService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;


public class JacksonController {

	public static void sendReimbursement(HttpServletRequest req, HttpServletResponse resp) throws ClassNotFoundException, SQLException {
		new ReimbursementService();
		HttpSession session = req.getSession();
		int i = (int) session.getAttribute("id");
		List<String[]> r = ReimbursementService.getById(i);
		try {
		    ObjectMapper mapper = new ObjectMapper();
		    mapper.enable(SerializationFeature.INDENT_OUTPUT);
		    String errorsJson = mapper.writeValueAsString(r);        
		    resp.setContentType("application/json");
		    resp.getWriter().write(errorsJson);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	// rerun
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
	
	// 
	public static void sendAllReimbursement(HttpServletRequest req, HttpServletResponse resp) throws ClassNotFoundException, SQLException {
		new ReimbursementService();
		HttpSession session = req.getSession();
		int i = (int) session.getAttribute("id");
		List<String[]> r = ReimbursementService.getAll();
		try {
		    ObjectMapper mapper = new ObjectMapper();
		    mapper.enable(SerializationFeature.INDENT_OUTPUT);
		    String errorsJson = mapper.writeValueAsString(r);        
		    resp.setContentType("application/json");
		    resp.getWriter().write(errorsJson);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
