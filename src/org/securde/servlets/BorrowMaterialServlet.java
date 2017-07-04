package org.securde.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.securde.services.MaterialServices;

/**
 * Servlet implementation class BorrowMaterialServlet
 */
@WebServlet("/BorrowMaterialServlet")
public class BorrowMaterialServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public BorrowMaterialServlet() {
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
		String from = request.getParameter("from");
		String to = request.getParameter("to");

		System.out.println("Frommmmm: " + from);
		System.out.println("tooooo: " + to);
		int materialID = Integer.parseInt(request.getParameter("materialID"));
		System.out.println(request.getSession(false).getAttribute("accountID"));
		int accountID = Integer.parseInt((request.getSession(false).getAttribute("accountID").toString()));
		MaterialServices.borrowBook(accountID, materialID, from, to);

	}

}
