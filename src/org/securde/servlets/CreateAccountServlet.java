package org.securde.servlets;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.securde.beans.Account;
import org.securde.services.AccountServices;

import com.mysql.fabric.xmlrpc.base.Data;

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
		String idNumber = request.getParameter("numberID");
		String birthdate = request.getParameter("birthdate");
		String sQuestion = request.getParameter("sQuestion");
		String sAnswer = request.getParameter("sAnswer");
		int accountType = Integer.parseInt(request.getParameter("accountType"));

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
		
		if(AccountServices.IsPasswordWeakPasswords(password)==0)
		{
			AccountServices.CreateAccount(a);
			request.setAttribute("account", a);

			HttpSession session = request.getSession(true);

			session.setAttribute("Username", a.getUsername());
			session.setAttribute("accountID", a.getAccountid());
			session.setAttribute("accountType", a.getAccountType());

			session.setAttribute("loggedIn", 1);

			request.getRequestDispatcher("/WEB-INF/jsp/userAccountDetails.jsp").forward(request, response);
			System.out.println("weak: " +  AccountServices.IsPasswordWeakPasswords(password));
		}
		else{
			request.getRequestDispatcher("/WEB-INF/jsp/signupError.jsp").forward(request, response);

		}
		
	}

}
