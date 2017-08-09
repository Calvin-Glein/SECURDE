package org.securde.servlets;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringEscapeUtils;
import org.securde.beans.Account;
import org.securde.beans.Material;
import org.securde.services.MaterialServices;

/**
 * Servlet implementation class EditMaterialServlet
 */
@WebServlet("/EditMaterialServlet")
public class EditMaterialServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public EditMaterialServlet() {
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
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		String title = StringEscapeUtils.escapeHtml4(request.getParameter("title"));
		String materialType = StringEscapeUtils.escapeHtml4(request.getParameter("materialType"));
		String deweyLocation = StringEscapeUtils.escapeHtml4(request.getParameter("location"));
		String author = StringEscapeUtils.escapeHtml4(request.getParameter("author"));
		String publisher = StringEscapeUtils.escapeHtml4(request.getParameter("publisher"));
		String year = StringEscapeUtils.escapeHtml4(request.getParameter("year"));
		String tags = StringEscapeUtils.escapeHtml4(request.getParameter("tags"));
		int status = Integer.parseInt(request.getParameter("status"));
		int materialID = Integer.parseInt(request.getParameter("materialID"));
		
		Material m = new Material(materialID, title, materialType, deweyLocation, author, publisher, year, tags, status, null, null);
	
		
		MaterialServices.editMaterial(m);
		
		Material m1 = MaterialServices.getMaterialData(materialID);

		request.setAttribute("material", m1);
		request.getRequestDispatcher("ViewAllMaterialsServlet").forward(request, response);
				

	
	}

}
