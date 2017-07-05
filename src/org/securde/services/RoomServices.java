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
				
				room = new Room();
				
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
	
	public static void reserveRoom(int accountID, int roomID, String from, String to) {
		String sql = "INSERT INTO borrow SET accountID = ?, materialID = ?, dateBorrow = ?, dateReturn = ?, returned = ?";

		Connection conn = DBPool.getInstance().getConnection();
		PreparedStatement pstmt = null;

		/*
		 * Data d; String dateString = "30/1/2000"; //terminal Date date1 =
		 * null; try { date1 = (Date) new
		 * SimpleDateFormat("dd/MM/yyyy").parse(dateString); } catch
		 * (ParseException e1) { // TODO Auto-generated catch block
		 * e1.printStackTrace(); }
		 */
		System.out.println("0");

		System.out.println("From: " + from);
		System.out.println("to: " + to);

		Date fromDate = dateToSQLDate(from);
		Date toDate = dateToSQLDate(to);
		try {
			java.sql.Timestamp sqlTimeStamp = new java.sql.Timestamp(
					new SimpleDateFormat("MM/dd/yyyy hh:mm").parse(from).getTime());
			toDate = Date.valueOf(sqlTimeStamp.toLocalDateTime().toLocalDate());
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		try {

			pstmt = conn.prepareStatement(sql);

			pstmt.setInt(1, accountID);

			pstmt.setInt(2, roomID+10000);
			pstmt.setDate(3, fromDate);
			pstmt.setDate(4, toDate);
			pstmt.setInt(5, 0);

			pstmt.executeUpdate();

		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			try {
				pstmt.close();
				conn.close();

			} catch (SQLException e) {
				// TODO Auto-generated catch block

			}

		}

	}

	public static void reserveRoomAccountTable(int roomID, String from, String to) {
		String sql = "Update meetingroom SET roomAvail = 0, timeOccupied = ?, timeOut = ? WHERE roomId = ?;";

		Date fromDate = dateToSQLDate(from);

		Date toDate = dateToSQLDate(to);

		Connection conn = DBPool.getInstance().getConnection();
		PreparedStatement pstmt = null;

		try {

			pstmt = conn.prepareStatement(sql);
			pstmt.setDate(1, fromDate);

			pstmt.setDate(2, toDate);
			pstmt.setInt(3, roomID);

			pstmt.executeUpdate();

		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			try {
				pstmt.close();
				conn.close();

			} catch (SQLException e) {
				// TODO Auto-generated catch block

			}

		}
	}
	
	public static Date dateToSQLDate(String date) {
		Date finalDate = null;
		try {
			java.sql.Timestamp sqlTimeStamp = new java.sql.Timestamp(
					new SimpleDateFormat("MM/dd/yyyy hh:mm").parse(date).getTime());
			finalDate = Date.valueOf(sqlTimeStamp.toLocalDateTime().toLocalDate());
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		return finalDate;

	}
}
