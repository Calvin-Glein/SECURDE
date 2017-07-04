package org.securde.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.securde.services.MaterialServices;

/**
 * Servlet implementation class ReturnMaterialServlet
 */
@WebServlet("/ReturnMaterialServlet")
public class ReturnMaterialServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ReturnMaterialServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		System.out.println("Triggered");
		MaterialServices.returnMaterial(Integer.parseInt(request.getParameter("material_id")));
		MaterialServices.returnBorrow(Integer.parseInt(request.getParameter("material_id")),
				Integer.parseInt((request.getSession(false).getAttribute("accountID").toString())));

		RequestDispatcher rd = request.getRequestDispatcher("ViewBorrowedServlet");

		rd.forward(request, response);
	}

}
