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
import org.securde.db.DBPool;

public class MaterialServices {
	public static ArrayList<Material> getBooks() {

		ArrayList<Material> books = new ArrayList<Material>();

		Material book = new Material();

		String sql = "Select * from readingMaterial" + " where materialType = 'book';";

		Connection conn = DBPool.getInstance().getConnection();

		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement(sql);

			rs = pstmt.executeQuery();

			while (rs.next()) {

				book.setAuthor(rs.getString(Material.MATERIAL_AUTHOR));
				book.setDateReserve(rs.getDate(Material.MATERIAL_DATERESERVE));
				book.setDateReturn(rs.getDate(Material.MATERIAL_DATERETURN));
				book.setLocation(rs.getString(Material.MATERIAL_DEWEYLOCATION));
				book.setMaterialID(rs.getInt(Material.MATERIAL_MATERIALID));
				book.setMaterialType(rs.getString(Material.MATERIAL_MATERIALTYPE));
				book.setPublisher(rs.getString(Material.MATERIAL_PUBLISHER));
				book.setStatus(rs.getInt(Material.MATERIAL_STATUS));
				book.setTags(rs.getString(Material.MATERIAL_TAGS));
				book.setYear(rs.getString(Material.MATERIAL_YEAR));
				book.setTitle(rs.getString(Material.MATERIAL_TITLE));

				book.setRating(getAverageRating(book.getMaterialID()));

				books.add(book);

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
		return books;
	}

	public static ArrayList<Material> getAllMaterials() {

		ArrayList<Material> materials = new ArrayList<Material>();

		Material material = new Material();

		String sql = "Select * from readingMaterial;";

		Connection conn = DBPool.getInstance().getConnection();

		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement(sql);

			rs = pstmt.executeQuery();

			while (rs.next()) {

				material = new Material();
				material.setAuthor(rs.getString(Material.MATERIAL_AUTHOR));
				material.setDateReserve(rs.getDate(Material.MATERIAL_DATERESERVE));
				material.setDateReturn(rs.getDate(Material.MATERIAL_DATERETURN));
				material.setLocation(rs.getString(Material.MATERIAL_DEWEYLOCATION));
				material.setMaterialID(rs.getInt(Material.MATERIAL_MATERIALID));
				material.setMaterialType(rs.getString(Material.MATERIAL_MATERIALTYPE));
				material.setPublisher(rs.getString(Material.MATERIAL_PUBLISHER));
				material.setStatus(rs.getInt(Material.MATERIAL_STATUS));
				material.setTags(rs.getString(Material.MATERIAL_TAGS));
				material.setYear(rs.getString(Material.MATERIAL_YEAR));
				material.setTitle(rs.getString(Material.MATERIAL_TITLE));

				material.setRating(getAverageRating(material.getMaterialID()));

				materials.add(material);

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
		return materials;
	}

	public static ArrayList<Material> getMagazines() {

		ArrayList<Material> magazines = new ArrayList<Material>();

		Material magazine = new Material();

		String sql = "Select * from readingMaterial" + " where materialType = 'magazine';";

		Connection conn = DBPool.getInstance().getConnection();

		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement(sql);

			rs = pstmt.executeQuery();

			while (rs.next()) {

				magazine.setAuthor(rs.getString(Material.MATERIAL_AUTHOR));
				magazine.setDateReserve(rs.getDate(Material.MATERIAL_DATERESERVE));
				magazine.setDateReturn(rs.getDate(Material.MATERIAL_DATERETURN));
				magazine.setLocation(rs.getString(Material.MATERIAL_DEWEYLOCATION));
				magazine.setMaterialID(rs.getInt(Material.MATERIAL_MATERIALID));
				magazine.setMaterialType(rs.getString(Material.MATERIAL_MATERIALTYPE));
				magazine.setPublisher(rs.getString(Material.MATERIAL_PUBLISHER));
				magazine.setStatus(rs.getInt(Material.MATERIAL_STATUS));
				magazine.setTags(rs.getString(Material.MATERIAL_TAGS));
				magazine.setYear(rs.getString(Material.MATERIAL_YEAR));
				magazine.setTitle(rs.getString(Material.MATERIAL_TITLE));
				magazine.setRating(getAverageRating(magazine.getMaterialID()));
				magazines.add(magazine);

				System.out.println(magazine.getTitle() + "asdadas");

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

		return magazines;
	}

	public static ArrayList<Material> getTheses() {

		ArrayList<Material> theses = new ArrayList<Material>();

		Material thesis = new Material();

		String sql = "Select * from readingMaterial" + " where materialType = 'thesis';";

		Connection conn = DBPool.getInstance().getConnection();

		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement(sql);

			rs = pstmt.executeQuery();

			while (rs.next()) {

				thesis.setAuthor(rs.getString(Material.MATERIAL_AUTHOR));
				thesis.setDateReserve(rs.getDate(Material.MATERIAL_DATERESERVE));
				thesis.setDateReturn(rs.getDate(Material.MATERIAL_DATERETURN));
				thesis.setLocation(rs.getString(Material.MATERIAL_DEWEYLOCATION));
				thesis.setMaterialID(rs.getInt(Material.MATERIAL_MATERIALID));
				thesis.setMaterialType(rs.getString(Material.MATERIAL_MATERIALTYPE));
				thesis.setPublisher(rs.getString(Material.MATERIAL_PUBLISHER));
				thesis.setStatus(rs.getInt(Material.MATERIAL_STATUS));
				thesis.setTags(rs.getString(Material.MATERIAL_TAGS));
				thesis.setYear(rs.getString(Material.MATERIAL_YEAR));
				thesis.setTitle(rs.getString(Material.MATERIAL_TITLE));
				thesis.setRating(getAverageRating(thesis.getMaterialID()));
				theses.add(thesis);

				System.out.println(thesis.getTitle() + "asdadas");

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

		return theses;
	}

	public static Material getMaterialData(int material_id) {
		Material book = new Material();

		String sql = "Select * from readingMaterial" + " where materialId = ?;";

		Connection conn = DBPool.getInstance().getConnection();

		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement(sql);

			pstmt.setInt(1, material_id);

			rs = pstmt.executeQuery();

			while (rs.next()) {

				book.setAuthor(rs.getString(Material.MATERIAL_AUTHOR));
				book.setDateReserve(rs.getDate(Material.MATERIAL_DATERESERVE));
				book.setDateReturn(rs.getDate(Material.MATERIAL_DATERETURN));
				book.setLocation(rs.getString(Material.MATERIAL_DEWEYLOCATION));
				book.setMaterialID(rs.getInt(Material.MATERIAL_MATERIALID));
				book.setMaterialType(rs.getString(Material.MATERIAL_MATERIALTYPE));
				book.setPublisher(rs.getString(Material.MATERIAL_PUBLISHER));
				book.setStatus(rs.getInt(Material.MATERIAL_STATUS));
				book.setTags(rs.getString(Material.MATERIAL_TAGS));
				book.setYear(rs.getString(Material.MATERIAL_YEAR));
				book.setTitle(rs.getString(Material.MATERIAL_TITLE));
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

		book.setRating(getAverageRating(book.getMaterialID()));

		return book;
	}

	public static int getAverageRating(int material_id) {
		int averageRating = 0;
		String sql = "Select avg(rating) from rating where materialId = ?";

		Connection conn = DBPool.getInstance().getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, material_id);

			rs = pstmt.executeQuery();

			while (rs.next()) {

				averageRating = rs.getInt("avg(rating)");
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
		return averageRating;
	}

	public static void borrowMaterial(int accountID, int materialID, String from, String to) {
		String sql = "INSERT into borrow(accountID, materialID, dateBorrow, dateReturn, returned) values (?,?, ?,?, 0)";

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
					new SimpleDateFormat("dd/MM/yyyy").parse(from).getTime());
			toDate = Date.valueOf(sqlTimeStamp.toLocalDateTime().toLocalDate());
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		try {

			pstmt = conn.prepareStatement(sql);

			pstmt.setInt(1, accountID);

			pstmt.setInt(2, materialID);
			pstmt.setDate(3, fromDate);
			pstmt.setDate(4, toDate);

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
					new SimpleDateFormat("dd/MM/yyyy").parse(date).getTime());
			finalDate = Date.valueOf(sqlTimeStamp.toLocalDateTime().toLocalDate());
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		return finalDate;

	}

	public static void borrowMaterialAccountTable(int materialID, String from, String to) {
		String sql = "Update readingmaterial SET status = 0, dateReserve = ?, dateReturn = ? WHERE materialId = ?;";

		Date fromDate = dateToSQLDate(from);

		Date toDate = dateToSQLDate(to);

		Connection conn = DBPool.getInstance().getConnection();
		PreparedStatement pstmt = null;

		try {

			pstmt = conn.prepareStatement(sql);
			pstmt.setDate(1, fromDate);

			pstmt.setDate(2, toDate);
			pstmt.setInt(3, materialID);

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

	public static void returnBorrow(int materialID, int accountID) {
		String sql = "Update borrow SET returned = 1 WHERE materialID = ? && accountID = ? && returned = 0;";

		Connection conn = DBPool.getInstance().getConnection();
		PreparedStatement pstmt = null;

		try {

			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, materialID);

			pstmt.setInt(2, accountID);

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

	public static ArrayList<Material> BorrowedByAccount(int accountID) {
		String sql = "Select * from readingmaterial where materialId in (select materialID from borrow where accountID = ? && returned =0);";

		ArrayList<Material> borrowed = new ArrayList<Material>();
		Material m = new Material();

		Connection conn = DBPool.getInstance().getConnection();
		PreparedStatement pstmt = null;

		ResultSet rs = null;

		try {

			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, accountID);

			rs = pstmt.executeQuery();

			while (rs.next()) {
				m = new Material();

				m.setAuthor(rs.getString(Material.MATERIAL_AUTHOR));
				m.setDateReserve(rs.getDate(Material.MATERIAL_DATERESERVE));
				m.setDateReturn(rs.getDate(Material.MATERIAL_DATERETURN));
				m.setLocation(rs.getString(Material.MATERIAL_DEWEYLOCATION));
				m.setMaterialID(rs.getInt(Material.MATERIAL_MATERIALID));
				m.setMaterialType(rs.getString(Material.MATERIAL_MATERIALTYPE));
				m.setPublisher(rs.getString(Material.MATERIAL_PUBLISHER));
				m.setStatus(rs.getInt(Material.MATERIAL_STATUS));
				m.setTags(rs.getString(Material.MATERIAL_TAGS));
				m.setYear(rs.getString(Material.MATERIAL_YEAR));
				m.setTitle(rs.getString(Material.MATERIAL_TITLE));

				m.setRating(getAverageRating(m.getMaterialID()));

				borrowed.add(m);

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

		return borrowed;
	}

	public static void returnMaterial(int materialID) {
		String sql = "Update readingmaterial SET status = 1 WHERE materialId = ?;";

		Connection conn = DBPool.getInstance().getConnection();
		PreparedStatement pstmt = null;

		try {

			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, materialID);

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

	public static void addMaterial(Material m) {
		System.out.println(m.getMaterialType());
		String sql = "INSERT INTO " + Material.MATERIAL_TABLENAME + " (" + Material.MATERIAL_TITLE + ", "
				+ Material.MATERIAL_MATERIALTYPE + ", " + Material.MATERIAL_DEWEYLOCATION + ", "
				+ Material.MATERIAL_AUTHOR + ", " + Material.MATERIAL_PUBLISHER + ", " + Material.MATERIAL_YEAR + ", "
				+ Material.MATERIAL_TAGS + ", " + Material.MATERIAL_DATERESERVE + ", " + Material.MATERIAL_DATERETURN
				+ ", " + Material.MATERIAL_STATUS + ") VALUES (?, ?, ?, ?, ?, ?, ?, '2000-01-01', '2000-01-01', 1)";

		Connection conn = DBPool.getInstance().getConnection();
		PreparedStatement pstmt = null;

		try {
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, m.getTitle());

			pstmt.setString(2, m.getMaterialType());
			pstmt.setString(3, m.getLocation());
			pstmt.setString(4, m.getAuthor());
			pstmt.setString(5, m.getPublisher());
			pstmt.setString(6, m.getYear());
			pstmt.setString(7, m.getTags());

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

}
