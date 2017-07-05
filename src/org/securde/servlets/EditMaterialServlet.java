package org.securde.servlets;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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

		String title = request.getParameter("title");
		String materialType = request.getParameter("materialType");
		String deweyLocation = request.getParameter("location");
		String author = request.getParameter("author");
		String publisher = request.getParameter("publisher");
		String year = request.getParameter("year");
		String tags = request.getParameter("tags");
		int status = Integer.parseInt(request.getParameter("status"));
		int materialID = Integer.parseInt(request.getParameter("materialID"));
		
		Material m = new Material(materialID, title, materialType, deweyLocation, author, publisher, year, tags, status, null, null);
	
		MaterialServices.editMaterial(m);
		
		Material m1 = MaterialServices.getMaterialData(materialID);

		request.setAttribute("material", m1);
		request.getRequestDispatcher("ViewAllMaterialsServlet").forward(request, response);
				

	
	}

}
