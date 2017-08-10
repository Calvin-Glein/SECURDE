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
 * Servlet implementation class ForgotPasswordServlet
 */
@WebServlet("/ForgotPasswordServlet")
public class ForgotPasswordServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ForgotPasswordServlet() {
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
	
	private static boolean checkString(String str) {
	    char ch;
	    boolean capitalFlag = false;
	    boolean lowerCaseFlag = false;
	    boolean numberFlag = false;
	    for(int i=0;i < str.length();i++) {
	        ch = str.charAt(i);
	        if( Character.isDigit(ch)) {
	            numberFlag = true;
	        }
	        else if (Character.isUpperCase(ch)) {
	            capitalFlag = true;
	        } else if (Character.isLowerCase(ch)) {
	            lowerCaseFlag = true;
	        }
	        if(numberFlag && capitalFlag && lowerCaseFlag)
	            return true;
	    }
	    return false;
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);

		String question = StringEscapeUtils.escapeHtml4(request.getParameter("secretquestion"));
		String answer = StringEscapeUtils.escapeHtml4(request.getParameter("secretanswer"));

		String newpassword = StringEscapeUtils.escapeHtml4(request.getParameter("newpassword"));

		if(newpassword.length()<8 && !checkString(newpassword)){
			request.setAttribute("isChanged", "Password is weak");
			request.getRequestDispatcher("/WEB-INF/jsp/IsChangedPassword.jsp").forward(request, response);
		}
		
		// panget eto for now
		Account a = new Account(question, answer);

		Account b = AccountServices.LoginQuestion(a);

		if (b.getAccountid() != -1) {
			HttpSession session = request.getSession(true);
			session.setAttribute("Username", null);
			session.setAttribute("accountID", null);
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
			// request.getRequestDispatcher("/WEB-INF/jsp/userAccountDetails.jsp").forward(request,
			// response);

			// from change password servlet
//			String newpassword = StringEscapeUtils.escapeHtml4(request.getParameter("newpassword"));

			TripleDES td;

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
			request.setAttribute("isChanged", "Changed");

			request.getRequestDispatcher("/WEB-INF/jsp/IsChangedPassword.jsp").forward(request, response);


		} else {

			// request.getRequestDispatcher("/WEB-INF/jsp/loginRetry.jsp").forward(request,
			// response);

			request.setAttribute("isChanged", "Wrong Password/Passphrase");
			request.getRequestDispatcher("/WEB-INF/jsp/IsChangedPassword.jsp").forward(request, response);


		}
	}

}
