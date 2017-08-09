package org.securde.servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import org.securde.beans.Room;
import org.securde.services.RoomServices;

@WebServlet("/ViewRoomServlet")
public class ViewRoomServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ViewRoomServlet() {
		super();
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
		// a
		int roomID = Integer.parseInt(request.getParameter("room_id"));
		ArrayList<String> sTime = RoomServices.getreservationSTime(roomID);
		ArrayList<String> fTime = RoomServices.getreservationFTime(roomID);
		ArrayList<String> fin = new ArrayList<String>();
		if (sTime.size() > 0){
			for (int i = 0; i < sTime.size(); i++){
				fin.add(sTime.get(i) + " to " + fTime.get(i));			
			}
		}
		Room r = RoomServices.getRoomData(roomID);

		request.setAttribute("room", r);
		request.setAttribute("time", fin);
		request.getRequestDispatcher("/WEB-INF/jsp/viewRoom.jsp").forward(request, response);
	}

}
