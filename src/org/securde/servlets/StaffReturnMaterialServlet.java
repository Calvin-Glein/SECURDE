package org.securde.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.securde.beans.Material;
import org.securde.services.MaterialServices;

/**
 * Servlet implementation class StaffReturnMaterialServlet
 */
@WebServlet("/StaffReturnMaterialServlet")
public class StaffReturnMaterialServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public StaffReturnMaterialServlet() {
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
		MaterialServices.returnMaterial(Integer.parseInt(request.getParameter("material_id")));
		MaterialServices.returnBorrow(Integer.parseInt(request.getParameter("material_id")),
				MaterialServices.returnCurrentBorrowerAccountID(Integer.parseInt(request.getParameter("material_id"))));

		int materialID = Integer.parseInt(request.getParameter("material_id"));

		Material m = MaterialServices.getMaterialData(materialID);

		request.setAttribute("material", m);
		request.getRequestDispatcher("ViewAllMaterialsServlet").forward(request, response);
	}

}
