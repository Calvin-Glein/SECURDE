package org.securde.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.StringEscapeUtils;
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
		request.getRequestDispatcher("/WEB-INF/jsp/prohibitedAccess.jsp").forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String username = StringEscapeUtils.escapeHtml4(request.getParameter("username"));
		System.out.print(username);
		String password = StringEscapeUtils.escapeHtml4(request.getParameter("password"));

		TripleDES td;
		String encryptedPassword = null;

		try {
			td = new TripleDES();
			encryptedPassword = td.encrypt(password);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Account a = new Account(username, encryptedPassword);

		Account b = AccountServices.Login(a);
		
		HttpSession presession = request.getSession();
		int trial;
		if (presession.getAttribute("loginCount") == null){
			presession.setAttribute("loginCount", 0);
			trial = (Integer)presession.getAttribute("loginCount");
		}
		else{
			trial = (Integer)presession.getAttribute("loginCount");
		}

		if (b.getAccountid() != -1 && trial < 3) {
			HttpSession session = request.getSession(true);
			session.setAttribute("Username", null);
			session.setAttribute("accountID",null);
			session.setAttribute("accountType", null);

			// // Get session creation time.
			// Date createTime = new Date(session.getCreationTime());
			//
			// // Get last access time of this web page.
			// Date lastAccessTime = new Date(session.getLastAccessedTime());

			session.setAttribute("Username", b.getUsername());
			session.setAttribute("accountID", b.getAccountid());
			session.setAttribute("accountType", b.getAccountType());

			session.setAttribute("loggedIn", 1);

			request.setAttribute("account", AccountServices.getAccountData(b.getAccountid()));
			request.getRequestDispatcher("/WEB-INF/jsp/userAccountDetails.jsp").forward(request, response);
		} 
		else if (trial >= 3) {
			long lastAccessedTime = presession.getLastAccessedTime();
			long curTime = System.currentTimeMillis(); 
			System.out.println(lastAccessedTime);
			System.out.println(curTime);
			if (curTime - lastAccessedTime > 180000){ // 3 mins
				presession.invalidate();
				System.out.println("Unlocked.");
				trial = 0;
			}
			request.getRequestDispatcher("/WEB-INF/jsp/loginRetry.jsp").forward(request, response);
		}
		else {
			request.getRequestDispatcher("/WEB-INF/jsp/loginRetry.jsp").forward(request, response);
			System.out.println("Trial" + " " + trial);
			trial++;
			presession.setAttribute("loginCount", trial);
		}

	}

}
