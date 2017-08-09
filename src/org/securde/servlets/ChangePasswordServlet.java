package org.securde.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringEscapeUtils;
import org.securde.beans.Account;
import org.securde.services.AccountServices;

/**
 * Servlet implementation class ChangePasswordServlet
 */
@WebServlet("/ChangePasswordServlet")
public class ChangePasswordServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ChangePasswordServlet() {
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
		String password = StringEscapeUtils.escapeHtml4(request.getParameter("password"));
		String newpassword = StringEscapeUtils.escapeHtml4(request.getParameter("newpassword"));

		TripleDES td;
		String encryptedPassword = null;

		try {
			td = new TripleDES();
			encryptedPassword = td.encrypt(password);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Account a = new Account((String) request.getSession(false).getAttribute("Username"), encryptedPassword);

		Account b = AccountServices.Login(a);

		if (b.getAccountid() != -1
				&& (Integer) request.getSession(false).getAttribute("accountID") == b.getAccountid()) {

			String encryptedNewPassword = null;

			try {
				td = new TripleDES();
				encryptedNewPassword = td.encrypt(newpassword);

			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			AccountServices.ChangePassword((Integer) request.getSession(false).getAttribute("accountID"),
					encryptedNewPassword);
			request.setAttribute("isChanged","Changed");

			request.getRequestDispatcher("/WEB-INF/jsp/IsChangedPassword.jsp").forward(request, response);

		
		}else{
			request.setAttribute("isChanged","Wrong Password");
			request.getRequestDispatcher("/WEB-INF/jsp/IsChangedPassword.jsp").forward(request, response);

		}

	}

}
