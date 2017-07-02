package org.securde.services;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.securde.beans.Account;
import org.securde.db.DBPool;

import com.mysql.fabric.xmlrpc.base.Data;

public class AccountServices {

	public static void AddAccount(Account a) {
		String sql = "INSERT INTO " + Account.USER_TABLE_NAME + " (" + Account.USER_USERNAME + ", "
				+ Account.USER_PASSWORD + ", " + Account.USER_EMAIL + ", " + Account.USER_FIRSTNAME + ", "
				+ Account.USER_MIDDLENAME + ", " + Account.USER_LASTNAME + ", " + Account.USER_IDNUMBER + ", "
				+ Account.USER_BIRTHDAY + ", " + Account.USER_SECRETQUESTION + ", " + Account.USER_SECRETANSWER + ", "
				+ Account.USER_ACCOUNTTYPE + ", " + Account.USER_PASSWORDEXPIRE + ", " + Account.USER_ISCHANGED + ", "
				+ Account.USER_ISACTIVE + ") VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

		Connection conn = DBPool.getInstance().getConnection();
		PreparedStatement pstmt = null;

		try {
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, a.getUsername());
			pstmt.setString(2, a.getPassword());
			pstmt.setString(3, a.getEmail());
			pstmt.setString(4, a.getFirstname());
			pstmt.setString(5, a.getMiddlename());
			pstmt.setString(6, a.getLastname());
			pstmt.setString(7, a.getIdNumber());
			pstmt.setString(8, a.getBirthdate());
			pstmt.setString(9, a.getsQuestion());
			pstmt.setString(10, a.getsAnswer());
			pstmt.setString(11, a.getAccountType());
			pstmt.setString(12, a.getPasswordExpire());
			pstmt.setString(13, a.getIsChanged());
			pstmt.setString(14, a.getIsActive());

			pstmt.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block

		} finally {
			try {
				pstmt.close();
				conn.close();

			} catch (SQLException e) {
				// TODO Auto-generated catch block

			}

		}
	}

	public static void CreateAccount(Account a) {
		String sql = "INSERT INTO " + Account.USER_TABLE_NAME + " (" + Account.USER_USERNAME + ", "
				+ Account.USER_PASSWORD + ", " + Account.USER_EMAIL + ", " + Account.USER_FIRSTNAME + ", "
				+ Account.USER_MIDDLENAME + ", " + Account.USER_LASTNAME + ", " + Account.USER_IDNUMBER + ", "
				+ Account.USER_BIRTHDAY + ", " + Account.USER_SECRETQUESTION + ", " + Account.USER_SECRETANSWER + ", "
				+ Account.USER_ACCOUNTTYPE + ", " + Account.USER_PASSWORDEXPIRE + ", " + Account.USER_ISCHANGED + ", "
				+ Account.USER_ISACTIVE + ") VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

		Connection conn = DBPool.getInstance().getConnection();
		PreparedStatement pstmt = null;

		Data d;
		Date date = null;

		try {

			java.util.Date dateJava = new java.util.Date();

			d = new Data();
			String date = "January 2, 2010";
			date = new java.sql.Date(date);

		} catch (Exception e) {
		}

		try {
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, a.getUsername());
			pstmt.setString(2, a.getPassword());
			pstmt.setString(3, a.getEmail());
			pstmt.setString(4, a.getFirstname());
			pstmt.setString(5, a.getMiddlename());
			pstmt.setString(6, a.getLastname());
			pstmt.setString(7, a.getIdNumber());
			pstmt.setString(8, a.getBirthdate());
			pstmt.setString(9, a.getsQuestion());
			pstmt.setString(10, a.getsAnswer());
			pstmt.setString(11, a.getAccountType());
			pstmt.setDate(12, date);
			pstmt.setString(13, a.getIsChanged());
			pstmt.setString(14, a.getIsActive());

			pstmt.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block

		} finally {
			try {
				pstmt.close();
				conn.close();

			} catch (SQLException e) {
				// TODO Auto-generated catch block

			}

		}
	}

	/*
	 * public static ArrayList<User> getAllUser() { ArrayList<User> users = new
	 * ArrayList<>();
	 * 
	 * String sql = "Select * from " + User.USER_TABLE_NAME + ";";
	 * 
	 * Connection conn = DBPool.getInstance().getConnection();
	 * 
	 * PreparedStatement pstmt = null; ResultSet rs = null; try { pstmt =
	 * conn.prepareStatement(sql); rs = pstmt.executeQuery();
	 * 
	 * while (rs.next()) { User u = new User();
	 * u.setUser_id(rs.getInt(User.USER_USER_ID));
	 * u.setUsername(rs.getString(User.USER_USERNAME));
	 * u.setPassword(rs.getString(User.USER_PASSWORD));
	 * u.setEmail(rs.getString(User.USER_EMAIL));
	 * 
	 * users.add(u); } } catch (SQLException e) { // TODO Auto-generated catch
	 * block
	 * 
	 * } finally { try { pstmt.close(); conn.close(); rs.close(); } catch
	 * (SQLException e) { // TODO Auto-generated catch block
	 * 
	 * }
	 * 
	 * }
	 * 
	 * return users; }
	 * 
	 * public static User getUserAccount(String username, String password) {
	 * User u = new User(); u.setUser_id(-1); String sql = "Select * from " +
	 * User.USER_TABLE_NAME + " where " + User.USER_USERNAME + " = ? and " +
	 * User.USER_PASSWORD + " = ?";
	 * 
	 * Connection conn = DBPool.getInstance().getConnection();
	 * 
	 * PreparedStatement pstmt = null;
	 * 
	 * ResultSet rs = null; try {
	 * 
	 * pstmt = conn.prepareStatement(sql); pstmt.setString(1, username);
	 * pstmt.setString(2, password);
	 * 
	 * rs = pstmt.executeQuery();
	 * 
	 * while (rs.next()) { u = new User();
	 * u.setUser_id(rs.getInt(User.USER_USER_ID));
	 * u.setUsername(rs.getString("username"));
	 * u.setPassword(rs.getString(User.USER_PASSWORD));
	 * u.setEmail(rs.getString(User.USER_EMAIL));
	 * 
	 * } } catch (SQLException e) { // TODO Auto-generated catch block
	 * 
	 * } finally { try { pstmt.close(); conn.close(); rs.close(); } catch
	 * (SQLException e) { // TODO Auto-generated catch block
	 * 
	 * }
	 * 
	 * }
	 * 
	 * return u;
	 * 
	 * }
	 */
}
