package org.securde.services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
				books.add(book);
				book.setRating(getAverageRating(book.getMaterialID()));

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

	public static Material getBookData(int material_id) {
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
		String sql = "Select avg(rating) from ratings where materialId = ?";

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
}
