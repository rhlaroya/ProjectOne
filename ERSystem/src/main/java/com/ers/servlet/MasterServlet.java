	package com.ers.servlet;

	import java.io.IOException;
	import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;

import javax.servlet.ServletException;
	import javax.servlet.annotation.WebServlet;
	import javax.servlet.http.HttpServlet;
	import javax.servlet.http.HttpServletRequest;
	import javax.servlet.http.HttpServletResponse;

	import com.ers.controller.RequestHelper;
	//"*.session"
	@WebServlet(urlPatterns = {"*.go", "*.json"})
	public class MasterServlet extends HttpServlet {
		
		@Override
		protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			try {
				RequestHelper.directProcess(req, resp);
			} catch (ClassNotFoundException | SQLException e) {
				e.printStackTrace();
			}
		}
		
		@Override
		protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			try {
				req.getRequestDispatcher(RequestHelper.process(req)).forward(req,resp);
			} catch (NoSuchAlgorithmException e) {
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
		}
		
		@Override
		protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			try {
				RequestHelper.directProcess(req, resp);
			} catch (ClassNotFoundException | SQLException e) {
				e.printStackTrace();
			}
		}
	}