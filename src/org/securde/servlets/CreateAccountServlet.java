package org.securde.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import org.securde.beans.Account;
import org.securde.services.AccountServices;

/**
 * Servlet implementation class CreateAccountServlet
 */
@WebServlet("/CreateAccountServlet")
public class CreateAccountServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CreateAccountServlet() {
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
		String email = request.getParameter("email");
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String firstname = request.getParameter("firstname");
		String middlename = request.getParameter("middlename");
		String lastname = request.getParameter("lastname");
		String idNumber = request.getParameter("idNumber");
		String birthdate = request.getParameter("birthdate");
		String sQuestion = request.getParameter("sQuestion");
		String sAnswer = request.getParameter("sAnswer");
		String accountType = request.getParameter("accountType");
		String isActive = request.getParameter("isActive");
		String isChanged = request.getParameter("isChanged");
		String passwordExpire = request.getParameter("passwordExpire");

		Account a = new Account(username, password, email, firstname, middlename, lastname, idNumber,
				birthdate, sQuestion, sAnswer, accountType);
		AccountServices.addUser(a);
		response.sendRedirect("login.html");
	}

}
