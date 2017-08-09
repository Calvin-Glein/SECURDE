package org.securde.servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.securde.beans.Material;
import org.securde.beans.Room;
import org.securde.services.MaterialServices;
import org.securde.services.RoomServices;
import org.securde.beans.Reservation;

/**
 * Servlet implementation class ManageRoomServlet
 */
@WebServlet("/ManageRoomServlet")
public class ManageRoomServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ManageRoomServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
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
		int roomID = Integer.parseInt(request.getParameter("room_id"));

		Room r = RoomServices.getRoomData(roomID);
		ArrayList<Reservation> reservations = RoomServices.getReservationList(roomID);
		request.setAttribute("room", r);
		request.setAttribute("reservations", reservations); 
		
		request.getRequestDispatcher("/WEB-INF/jsp/staffViewManageRoom.jsp").forward(request, response);
	}
}
