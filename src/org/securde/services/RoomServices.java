package org.securde.services;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import org.securde.beans.Account;
import org.securde.beans.Material;
import org.securde.beans.Room;
import org.securde.db.DBPool;

public class RoomServices {

	public static ArrayList<Room> getRooms(){
		ArrayList<Room> rooms = new ArrayList<Room>();

		Room room = new Room();

		String sql = "Select * from meetingroom;";

		Connection conn = DBPool.getInstance().getConnection();

		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement(sql);

			rs = pstmt.executeQuery();

			while (rs.next()) {

				room.setRoomId(rs.getInt(Room.ROOM_ID));
				room.setRoomName(rs.getString(Room.ROOM_NAME));
				room.setRoomLocation(rs.getString(Room.ROOM_LOCATION));
				room.setRoomAvail(rs.getString(Room.ROOM_AVAILABLE));
				room.setTimeOccupied(rs.getDate(Room.ROOM_TIME_OCCUPIED));
				room.setTimeOut(rs.getDate(Room.ROOM_TIME_OUT));

				rooms.add(room);

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block

		} finally {
			try {
				pstmt.close();
				conn.close();
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block

			}

		}
		return rooms;
	}
	
	public static Room getRoomData(int roomId){
		Room room = new Room();
		String sql = "Select * from meetingroom" + " where roomId = ?;";
		Connection conn = DBPool.getInstance().getConnection();

		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement(sql);

			pstmt.setInt(1, roomId);

			rs = pstmt.executeQuery();

			while (rs.next()) {
				room.setRoomId(rs.getInt(Room.ROOM_ID));
				room.setRoomName(rs.getString(Room.ROOM_NAME));
				room.setRoomLocation(rs.getString(Room.ROOM_LOCATION));
				room.setRoomAvail(rs.getString(Room.ROOM_AVAILABLE));
				room.setTimeOccupied(rs.getDate(Room.ROOM_TIME_OCCUPIED));
				room.setTimeOut(rs.getDate(Room.ROOM_TIME_OUT));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block

		} finally {
			try {
				pstmt.close();
				conn.close();
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block

			}

		}

		return room;
		
	}
	
	//to be added more

}
