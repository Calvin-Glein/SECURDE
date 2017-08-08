package org.securde.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.securde.beans.Account;
import org.securde.services.AccountServices;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginServlet() {
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
		String username = request.getParameter("username");
		String password = request.getParameter("password");

		Account a = new Account(username, password);
		
		Account b = AccountServices.Login(a);
		
		if(b.getAccountid()!=-1){
			HttpSession session = request.getSession(true);

//			// Get session creation time.
//			Date createTime = new Date(session.getCreationTime());
	//
//			// Get last access time of this web page.
//			Date lastAccessTime = new Date(session.getLastAccessedTime());

			
			session.setAttribute("Username", b.getUsername());
			session.setAttribute("accountID", b.getAccountid());
			session.setAttribute("accountType", b.getAccountType());

			session.setAttribute("loggedIn", 1);

			
			request.setAttribute("account", AccountServices.getAccountData(b.getAccountid()));
			request.getRequestDispatcher("/WEB-INF/jsp/userAccountDetails.jsp").forward(request, response);
		}
		else{
			request.getRequestDispatcher("/WEB-INF/jsp/loginRetry.jsp").forward(request, response);

		}

		


	}

}
