package org.securde.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringEscapeUtils;
import org.securde.beans.Material;
import org.securde.services.MaterialServices;

/**
 * Servlet implementation class AddMaterialServlet
 */
@WebServlet("/AddMaterialServlet")
public class AddMaterialServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AddMaterialServlet() {
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

		String title = StringEscapeUtils.escapeHtml4(request.getParameter("title"));
		String materialType = StringEscapeUtils.escapeHtml4(request.getParameter("materialType"));
		String location = StringEscapeUtils.escapeHtml4(request.getParameter("location"));
		String author = StringEscapeUtils.escapeHtml4(request.getParameter("author"));
		String publisher = StringEscapeUtils.escapeHtml4(request.getParameter("publisher"));
		String year = StringEscapeUtils.escapeHtml4(request.getParameter("year"));
		String tags = StringEscapeUtils.escapeHtml4(request.getParameter("tags"));

		Material m = new Material();
		
		m.setTitle(title);
		m.setMaterialType(materialType);
		m.setLocation(location);
		m.setAuthor(author);
		m.setAuthor(author);
		m.setPublisher(publisher);
		m.setYear(year);
		m.setTags(tags);
		
		MaterialServices.addMaterial(m);
		
		response.sendRedirect("/WEB-INF/jsp/staffAddMaterial.jsp");
		
		
	}

}
