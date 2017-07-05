package org.securde.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.securde.services.MaterialServices;
import org.securde.services.RoomServices;

/**
 * Servlet implementation class FreeTimeSlots
 */
@WebServlet("/FreeTimeSlotsServlet")
public class FreeTimeSlotsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FreeTimeSlotsServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		int reserveID = Integer.parseInt(request.getParameter("reserve_id"));
		
		RoomServices.freeTimeSlot(reserveID);
		
		RequestDispatcher rd = request.getRequestDispatcher("ViewAllRoomsServlet");
		
		rd.forward(request,response);
	}

}
