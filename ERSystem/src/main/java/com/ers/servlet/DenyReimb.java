package com.ers.servlet;

import java.io.IOException;
import java.sql.Timestamp;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ers.DAO.ReimbursementDao;
import com.ers.model.Reimbursement;

@MultipartConfig
/**
 * Servlet implementation class DenyReimb
 */
public class DenyReimb extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DenyReimb() {
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
		doGet(request, response);
		HttpSession session = request.getSession();
		int id = (int) session.getAttribute("id");
		int idreimb = Integer.parseInt(request.getParameter("id"));
		Timestamp time = new Timestamp(System.currentTimeMillis());
		System.out.println(time);
		int status = 3;
		ReimbursementDao rd = new ReimbursementDao();
		rd.update(new Reimbursement(time,id,status,idreimb));
	}

}
