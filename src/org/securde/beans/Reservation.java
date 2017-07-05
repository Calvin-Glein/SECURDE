package org.securde.beans;

import java.io.Serializable;
import java.sql.Date;
import java.sql.Timestamp;

public class Reservation implements Serializable {
	
	private static final long serialVersionUID = 1L;
	public static final String RESERVE_ID = "reserveID";
	public static final String RESERVE_ACCOUNT_ID = "accountID";
	public static final String RESERVE_ROOM_ID = "roomID";
	public static final String RESERVE_START_TIME = "fromTime";
	public static final String RESERVE_END_TIME = "toTime";
	public static final String RESERVE_STATUS = "status";

	private int reserveId;
	private int accountID;
	private int roomID;
	private int status;
	private Timestamp fromTime;
	private Timestamp toTime;
	
	public Reservation(){}

	public Reservation(int reserveId, int accountID, int roomID, int status, Timestamp fromTime, Timestamp toTime) {
		super();
		this.reserveId = reserveId;
		this.accountID = accountID;
		this.roomID = roomID;
		this.status = status;
		this.fromTime = fromTime;
		this.toTime = toTime;
	}

	public int getReserveId() {
		return reserveId;
	}

	public void setReserveId(int reserveId) {
		this.reserveId = reserveId;
	}

	public int getAccountID() {
		return accountID;
	}

	public void setAccountID(int accountID) {
		this.accountID = accountID;
	}

	public int getRoomID() {
		return roomID;
	}

	public void setRoomID(int roomID) {
		this.roomID = roomID;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public Timestamp getFromTime() {
		return fromTime;
	}

	public void setFromTime(Timestamp fromTime) {
		this.fromTime = fromTime;
	}

	public Timestamp getToTime() {
		return toTime;
	}

	public void setToTime(Timestamp toTime) {
		this.toTime = toTime;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	


}
