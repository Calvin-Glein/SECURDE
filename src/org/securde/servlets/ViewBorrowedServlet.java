package org.securde.servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.securde.beans.Material;
import org.securde.services.AccountServices;
import org.securde.services.MaterialServices;

/**
 * Servlet implementation class ViewBorrowedServlet
 */
@WebServlet("/ViewBorrowedServlet")
public class ViewBorrowedServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ViewBorrowedServlet() {
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
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		ArrayList<Material> borrows = MaterialServices
				.BorrowedByAccount(Integer.parseInt((request.getSession(false).getAttribute("accountID").toString())));
		request.setAttribute("materials", borrows);
		request.getRequestDispatcher("/WEB-INF/jsp/userMaterialsBorrowed.jsp").forward(request, response);
	}

}
