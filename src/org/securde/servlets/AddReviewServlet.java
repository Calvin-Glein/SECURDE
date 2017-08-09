package org.securde.servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringEscapeUtils;
import org.securde.beans.Material;
import org.securde.beans.Review;
import org.securde.services.MaterialServices;
import org.securde.services.ReviewServices;

/**
 * Servlet implementation class AddReviewServlet
 */
@WebServlet("/AddReviewServlet")
public class AddReviewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AddReviewServlet() {
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
		int accountID = Integer.parseInt(request.getSession(false).getAttribute("accountID").toString());
		int materialID = Integer.parseInt(request.getParameter("materialID").toString());
		String comment = StringEscapeUtils.escapeHtml4(request.getParameter("comment"));
		int rating = Integer.parseInt(request.getParameter("rating").toString());

		Review r = new Review(accountID, materialID, comment, rating, null,
				request.getSession(false).getAttribute("Username").toString());

		ReviewServices.adddReview(r);

		Material m = MaterialServices.getMaterialData(materialID);

		int canComment = MaterialServices.canComment(
				Integer.parseInt(request.getSession(false).getAttribute("accountID").toString()), materialID);

		ArrayList<Review> reviews = ReviewServices.getReviews(materialID);

		request.setAttribute("commentable", canComment);
		request.setAttribute("reviews", reviews);
		request.setAttribute("material", m);
		request.getRequestDispatcher("/WEB-INF/jsp/viewMaterial.jsp").forward(request, response);

	}

}
