package org.securde.services;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

import org.securde.beans.Account;
import org.securde.beans.Material;
import org.securde.beans.Room;
import org.securde.db.DBPool;
import org.securde.beans.Reservation;

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
				room.setTimeOccupied(rs.getTimestamp(Room.ROOM_TIME_OCCUPIED));
				room.setTimeOut(rs.getTimestamp(Room.ROOM_TIME_OUT));

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
				room.setTimeOccupied(rs.getTimestamp(Room.ROOM_TIME_OCCUPIED));
				room.setTimeOut(rs.getTimestamp(Room.ROOM_TIME_OUT));
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
		String sql = "INSERT INTO reserve SET accountID = ?, roomID = ?, fromTime = ?, toTime = ?, status = ?";

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

		Timestamp fromDate = dateToSQLDate(from);
		Timestamp toDate = dateToSQLDate(to);
		
		long fromMs = fromDate.getTime();
		long toMs = toDate.getTime();
		boolean pass = true;
		
		ArrayList<Long> compareLong = new ArrayList<Long>();
		compareLong = getReservationLong(roomID);
		int i = 1;
		while(i < compareLong.size()){
			System.out.println("Loop Number" + i);
			System.out.println("FromMS : " + fromMs);
			System.out.println("toMS : " + toMs);
			System.out.println("CompareLong(from) : " + compareLong.get(i));
			System.out.println("CompareLong(to) : " + compareLong.get(i+1));
			if (compareLong.get(i) <= fromMs && compareLong.get(i+1) > fromMs){
				System.out.println("From");
				pass = false;
			}
			
			if (compareLong.get(i) < toMs && compareLong.get(i+1) > toMs){
				pass = false;
				System.out.println("To");
			}
			
			i += 2;
		}
		
		if (fromMs == toMs){
			pass = false;
		}
			
			
		
		/*
		try {
			java.sql.Timestamp sqlTimeStamp = new java.sql.Timestamp(
					new SimpleDateFormat("MM/dd/yyyy hh:mm").parse(from).getTime());
			toDate = Date.valueOf(sqlTimeStamp.toLocalDateTime().toLocalDate());
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		*/
		
		if (pass){
		try {

			pstmt = conn.prepareStatement(sql);

			pstmt.setInt(1, accountID);

			pstmt.setInt(2, roomID);
			pstmt.setTimestamp(3, fromDate);
			pstmt.setTimestamp(4, toDate);
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
		else{
			System.out.println("Failed!");
		}
	}

	public static void reserveRoomAccountTable(int roomID, String from, String to) {
		String sql = "Update meetingroom SET roomAvail = ?, timeOccupied = ?, timeOut = ? WHERE roomId = ?;";

		Timestamp fromDate = dateToSQLDate(from);

		Timestamp toDate = dateToSQLDate(to);

		Connection conn = DBPool.getInstance().getConnection();
		PreparedStatement pstmt = null;

		try {

			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, 1);
			pstmt.setTimestamp(2, fromDate);

			pstmt.setTimestamp(3, toDate);
			pstmt.setInt(4, roomID);

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
	
	public static ArrayList<Long> getReservationLong(int roomID){
		ArrayList<Long> timeArray = new ArrayList<Long>();
		int index = 0;
		timeArray.add(-1L);
		String sql = "Select fromTime, toTime, status from reserve where roomID = ?;";

		Connection conn = DBPool.getInstance().getConnection();

		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1,  roomID);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				
				Timestamp f = rs.getTimestamp("fromTime");
				Timestamp s = rs.getTimestamp("toTime");
				
				long first = f.getTime();
				long second = s.getTime();
				int stat = rs.getInt("status");
				
				if (stat == 0){
					timeArray.add(first);
					timeArray.add(second);
				}

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
		return timeArray;
	}
	
	public static ArrayList<String> getreservationSTime(int roomID){
		ArrayList<String> timeArray = new ArrayList<String>();
		String sql = "Select fromTime from reserve where status = ? and roomID = ?;";

		Connection conn = DBPool.getInstance().getConnection();

		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, 0);
			pstmt.setInt(2, roomID);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				
				String f = rs.getTimestamp("fromTime").toString();
				
				timeArray.add(f);
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
		return timeArray;
	}
	
	public static ArrayList<String> getreservationFTime(int roomID){
		ArrayList<String> timeArray = new ArrayList<String>();
		String sql = "Select toTime from reserve where status = ? and roomID = ?;";

		Connection conn = DBPool.getInstance().getConnection();

		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, 0);
			pstmt.setInt(2, roomID);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				
				String f = rs.getTimestamp("toTime").toString();
				
				timeArray.add(f);
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
		return timeArray;
	}
	
	public static ArrayList<Reservation> getReservationList(int roomID){
		ArrayList<Reservation> reservations = new ArrayList<Reservation>();
		Reservation res = new Reservation();
		
		String sql = "Select * from reserve where status = ? and roomID = ?;";
		
		Connection conn = DBPool.getInstance().getConnection();

		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, 0);
			pstmt.setInt(2, roomID);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				
				res = new Reservation();
				
				res.setReserveId(rs.getInt(Reservation.RESERVE_ID));
				res.setAccountID(rs.getInt(Reservation.RESERVE_ACCOUNT_ID));
				res.setRoomID(rs.getInt(Reservation.RESERVE_ROOM_ID));
				res.setFromTime(rs.getTimestamp(Reservation.RESERVE_START_TIME));
				res.setToTime(rs.getTimestamp(Reservation.RESERVE_END_TIME));
				res.setStatus(rs.getInt(Reservation.RESERVE_STATUS));
				
				reservations.add(res);
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
		return reservations;
	}
	
	public static void freeTimeSlot(int reservationID) {
		String sql = "Update reserve SET status = ? WHERE reserveId = ?;";


		Connection conn = DBPool.getInstance().getConnection();
		PreparedStatement pstmt = null;

		try {

			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, 1);
			pstmt.setInt(2, reservationID);

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
	
	public static ArrayList<Room> BorrowedByAccount(int accountID) {
		String sql = "Select * from meetingroom where roomId in (select roomID from reserve where accountID = ? && status = 0);";

		ArrayList<Room> reserved = new ArrayList<Room>();
		Room r = new Room();

		Connection conn = DBPool.getInstance().getConnection();
		PreparedStatement pstmt = null;

		ResultSet rs = null;

		try {

			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, accountID);

			rs = pstmt.executeQuery();

			while (rs.next()) {
				r = new Room();

				r.setRoomId(rs.getInt(Room.ROOM_ID));
				r.setRoomName(rs.getString(Room.ROOM_NAME));
				r.setRoomLocation(rs.getString(Room.ROOM_LOCATION));
				r.setRoomAvail(rs.getString(Room.ROOM_AVAILABLE));
				r.setTimeOccupied(rs.getTimestamp(Room.ROOM_TIME_OCCUPIED));
				r.setTimeOut(rs.getTimestamp(Room.ROOM_TIME_OUT));
				
				reserved.add(r);

			}

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

		return reserved;
	}
	
	public static void returnReservation(int roomID, int accountID) {
		String sql = "Update reserve SET status = 1 WHERE accountID = ? and roomID = ? and status = 0;";

		Connection conn = DBPool.getInstance().getConnection();
		PreparedStatement pstmt = null;

		try {

			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, accountID);
			pstmt.setInt(2, roomID);

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
	
	public static Timestamp dateToSQLDate(String date) {
		java.sql.Timestamp sqlTimeStamp = null;
		try {
			sqlTimeStamp = new java.sql.Timestamp(
					new SimpleDateFormat("MM/dd/yyyy HH:mm").parse(date).getTime());
			System.out.println(sqlTimeStamp);
			//finalDate = Date.valueOf(sqlTimeStamp.toLocalDateTime().toLocalDate());
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		return sqlTimeStamp;

	}
}
