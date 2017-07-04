package org.securde.beans;

import java.io.Serializable;
import java.sql.Date;

public class Room implements Serializable {
	
	private static final long serialVersionUID = 1L;
	public static final String ROOM_ID = "roomId";
	public static final String ROOM_NAME = "roomName";
	public static final String ROOM_LOCATION = "roomLocation";
	public static final String ROOM_AVAILABLE = "roomAvail";
	public static final String ROOM_TIME_OCCUPIED = "timeOccupied";
	public static final String ROOM_TIME_OUT = "timeOut";

	private int roomId;
	private String roomName;
	private String roomLocation;
	private String roomAvail;
	private Date timeOccupied;
	private Date timeOut;
	
	public Room(){}
	
	public Room(int roomId, String roomName, String roomLocation, String roomAvail,
			Date timeOccupied, Date timeOut) {
		super();
		this.roomId = roomId;
		this.roomName = roomName;
		this.roomLocation = roomLocation;
		this.roomAvail = roomAvail;
		this.timeOccupied = timeOccupied;
		this.timeOut = timeOut;
	}

	public int getRoomId() {
		return roomId;
	}

	public void setRoomId(int roomId) {
		this.roomId = roomId;
	}

	public String getRoomName() {
		return roomName;
	}

	public void setRoomName(String roomName) {
		this.roomName = roomName;
	}

	public String getRoomLocation() {
		return roomLocation;
	}

	public void setRoomLocation(String roomLocation) {
		this.roomLocation = roomLocation;
	}

	public String getRoomAvail() {
		return roomAvail;
	}

	public void setRoomAvail(String roomAvail) {
		this.roomAvail = roomAvail;
	}

	public Date getTimeOccupied() {
		return timeOccupied;
	}

	public void setTimeOccupied(Date timeOccupied) {
		this.timeOccupied = timeOccupied;
	}

	public Date getTimeOut() {
		return timeOut;
	}

	public void setTimeOut(Date timeOut) {
		this.timeOut = timeOut;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
