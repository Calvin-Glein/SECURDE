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
 * Servlet implementation class ReserveRoomServlet
 */
@WebServlet("/ReserveRoomServlet")
public class ReserveRoomServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReserveRoomServlet() {
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
		String from = request.getParameter("fromString").toString();
		String to = request.getParameter("toString").toString();

		int roomId = Integer.parseInt(request.getParameter("roomId"));
		int accountID = Integer.parseInt((request.getSession(false).getAttribute("accountID").toString()));
		RoomServices.reserveRoom(accountID, roomId, from, to);
		//RoomServices.reserveRoomAccountTable(roomId, from, to);
		
		RequestDispatcher rd = request.getRequestDispatcher("GetRoomServlet");
		
		rd.forward(request,response);
	}
}
