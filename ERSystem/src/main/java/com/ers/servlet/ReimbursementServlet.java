package com.ers.servlet;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import java.sql.Timestamp;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ers.DAO.ReimbursementDao;
import com.ers.controller.RequestHelper;
import com.ers.model.Reimbursement;

/**
 * Servlet implementation class ReimbursementController
 */
@MultipartConfig
@WebServlet(name= "ReimbursementServlet", urlPatterns = {"/ReimbursementServlet"})
public class ReimbursementServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReimbursementServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			request.getRequestDispatcher(RequestHelper.process(request)).forward(request,response);
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

			int type = Integer.parseInt(request.getParameter("type"));
			int amount = Integer.parseInt(request.getParameter("amount"));
			String desc = request.getParameter("description");
			Timestamp time = new Timestamp(System.currentTimeMillis());
			HttpSession session = request.getSession();
			int id = (int) session.getAttribute("id");
			int status = 1;
			ReimbursementDao rd = new ReimbursementDao();
			try {
				rd.insert(new Reimbursement(amount,time,desc,id,status,type));
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
	}
}
