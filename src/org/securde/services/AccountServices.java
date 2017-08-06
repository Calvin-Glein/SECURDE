package org.securde.services;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.securde.beans.Account;
import org.securde.beans.Material;
import org.securde.db.DBPool;

public class AccountServices {

	/*
	 * public static void AddAccount(Account a) { String sql = "INSERT INTO " +
	 * Account.USER_TABLE_NAME + " (" + Account.USER_USERNAME + ", " +
	 * Account.USER_PASSWORD + ", " + Account.USER_EMAIL + ", " +
	 * Account.USER_FIRSTNAME + ", " + Account.USER_MIDDLENAME + ", " +
	 * Account.USER_LASTNAME + ", " + Account.USER_IDNUMBER + ", " +
	 * Account.USER_BIRTHDAY + ", " + Account.USER_SECRETQUESTION + ", " +
	 * Account.USER_SECRETANSWER + ", " + Account.USER_ACCOUNTTYPE + ", " +
	 * Account.USER_PASSWORDEXPIRE + ", " + Account.USER_ISCHANGED + ", " +
	 * Account.USER_ISACTIVE +
	 * ") VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
	 * 
	 * Connection conn = DBPool.getInstance().getConnection(); PreparedStatement
	 * pstmt = null;
	 * 
	 * try { pstmt = conn.prepareStatement(sql);
	 * 
	 * pstmt.setString(1, a.getUsername()); pstmt.setString(2, a.getPassword());
	 * pstmt.setString(3, a.getEmail()); pstmt.setString(4, a.getFirstname());
	 * pstmt.setString(5, a.getMiddlename()); pstmt.setString(6,
	 * a.getLastname()); pstmt.setString(7, a.getIdNumber()); pstmt.setString(8,
	 * a.getBirthdate()); pstmt.setString(9, a.getsQuestion());
	 * pstmt.setString(10, a.getsAnswer()); pstmt.setString(11,
	 * a.getAccountType()); pstmt.setString(12, a.getPasswordExpire());
	 * pstmt.setString(13, a.getIsChanged()); pstmt.setString(14,
	 * a.getIsActive());
	 * 
	 * pstmt.executeUpdate();
	 * 
	 * } catch (SQLException e) { // TODO Auto-generated catch block
	 * 
	 * } finally { try { pstmt.close(); conn.close();
	 * 
	 * } catch (SQLException e) { // TODO Auto-generated catch block
	 * 
	 * }
	 * 
	 * } }
	 */

	public static Account Login(Account a) {

		Account b = new Account();

		b.setAccountid(-1);
		String sql = "Select " + Account.USER_USER_ID + " , " + Account.USER_USERNAME + ", " + Account.USER_ACCOUNTTYPE
				+ " from account where " + Account.USER_USERNAME + " = ? && " + Account.USER_PASSWORD + " = ?;";

		Connection conn = DBPool.getInstance().getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, a.getUsername());
			pstmt.setString(2, a.getPassword());

			rs = pstmt.executeQuery();

			while (rs.next()) {
				b.setAccountid(Integer.parseInt(rs.getString(Account.USER_USER_ID)));
				b.setUsername(rs.getString(Account.USER_USERNAME));
				b.setAccountType(rs.getInt(Account.USER_ACCOUNTTYPE));
			}
			System.out.println("done");

		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			try {
				pstmt.close();
				conn.close();

			} catch (SQLException e) {
				// TODO Auto-generated catch block

			}
			System.out.println("done");

		}
		System.out.println("done");

		return b;
	}

	public static int IsPasswordWeakPasswords(String password){

		String sql = "Select passwordId from weakpasswords" + " where weakPassword = ?;";

		Connection conn = DBPool.getInstance().getConnection();

		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int weakpasswordId = -1;
		try {
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, password);

			rs = pstmt.executeQuery();

			while (rs.next()) {
				weakpasswordId = rs.getInt("passwordId");
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
		
		if(weakpasswordId == -1){
			return 0;
		}
		else{
			return 1;
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

		/*
		 * Data d; String dateString = "30/1/2000"; //terminal Date date1 =
		 * null; try { date1 = (Date) new
		 * SimpleDateFormat("dd/MM/yyyy").parse(dateString); } catch
		 * (ParseException e1) { // TODO Auto-generated catch block
		 * e1.printStackTrace(); }
		 */

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
			pstmt.setInt(11, a.getAccountType());
			pstmt.setDate(12, a.getPasswordExpire());
			pstmt.setInt(13, a.getIsChanged());
			pstmt.setInt(14, a.getIsActive());

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
			System.out.println("done");

		}
		System.out.println("done");

	}

	public static Account getAccountData(int accountID) {
		Account account = new Account();

		String sql = "Select * from account" + " where accountid = ?;";

		Connection conn = DBPool.getInstance().getConnection();

		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement(sql);

			pstmt.setInt(1, accountID);

			rs = pstmt.executeQuery();

			while (rs.next()) {
				account.setAccountType(rs.getInt(Account.USER_ACCOUNTTYPE));
				account.setAccountid(rs.getInt(Account.USER_USER_ID));
				account.setBirthdate(rs.getString(Account.USER_BIRTHDAY));
				account.setEmail(rs.getString(Account.USER_EMAIL));
				account.setFirstname(rs.getString(Account.USER_FIRSTNAME));
				account.setIdNumber(rs.getString(Account.USER_USER_ID));
				account.setIsActive(rs.getInt(Account.USER_ISACTIVE));
				account.setIsChanged(rs.getInt(Account.USER_ISCHANGED));
				account.setLastname(rs.getString(Account.USER_LASTNAME));
				account.setMiddlename(rs.getString(Account.USER_MIDDLENAME));
				account.setPassword(rs.getString(Account.USER_PASSWORD));
				account.setsAnswer(rs.getString(Account.USER_SECRETANSWER));
				account.setsQuestion(rs.getString(Account.USER_SECRETQUESTION));
				account.setUsername(rs.getString(Account.USER_USERNAME));

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

		return account;
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
