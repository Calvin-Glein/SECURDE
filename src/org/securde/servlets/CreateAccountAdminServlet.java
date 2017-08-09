package org.securde.servlets;

import java.io.IOException;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringEscapeUtils;
import org.securde.beans.Account;
import org.securde.services.AccountServices;

/**
 * Servlet implementation class CreateAccountAdminServlet
 */
@WebServlet("/CreateAccountAdminServlet")
public class CreateAccountAdminServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CreateAccountAdminServlet() {
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
		// TODO Auto-generated method stub
		String email = StringEscapeUtils.escapeHtml4(request.getParameter("email"));
		String username = StringEscapeUtils.escapeHtml4(request.getParameter("username"));
		String password = StringEscapeUtils.escapeHtml4(request.getParameter("password"));

		String firstname = StringEscapeUtils.escapeHtml4(request.getParameter("firstname"));

		String middlename = StringEscapeUtils.escapeHtml4(request.getParameter("middlename"));

		String lastname = StringEscapeUtils.escapeHtml4(request.getParameter("lastname"));

		String idNumber = StringEscapeUtils.escapeHtml4(request.getParameter("numberID"));

		String birthdate = StringEscapeUtils.escapeHtml4(request.getParameter("birthdate"));

		String sQuestion = StringEscapeUtils.escapeHtml4(request.getParameter("sQuestion"));

		String sAnswer = StringEscapeUtils.escapeHtml4(request.getParameter("sAnswer"));

		int accountType = Integer.parseInt(request.getParameter("accountType"));
		// int isActive = Integer.parseInt(request.getParameter("isActive"));
		// int isChanged = Integer.parseInt(request.getParameter("isChanged"));
		int isActive = 1;
		int isChanged = 1;
		String passwordExpireString = "30/1/2000";

		Date passwordExpire = null;
		try {
			java.sql.Timestamp sqlTimeStamp = new java.sql.Timestamp(
					new SimpleDateFormat("dd/MM/yyyy").parse(passwordExpireString).getTime());
			passwordExpire = Date.valueOf(sqlTimeStamp.toLocalDateTime().toLocalDate());
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		Account a = new Account(username, password, email, firstname, middlename, lastname, idNumber, birthdate,
				sQuestion, sAnswer, accountType, isChanged, passwordExpire, isActive);
		if (AccountServices.IsPasswordWeakPasswords(password) == 0) {

			AccountServices.CreateAccount(a);
			response.sendRedirect("/WEB-INF/jsp/administratorCreateAccount.jsp");
		} else {

		}

	}

}
