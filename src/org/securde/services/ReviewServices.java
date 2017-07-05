package org.securde.services;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

import org.securde.beans.Review;
import org.securde.db.DBPool;

public class ReviewServices {
	public static ArrayList<Review> getReviews(int materialID) {

		ArrayList<Review> reviews = new ArrayList<Review>();

		Review review = new Review();

		String sql = "Select * from rating  where materialId = ?;";

		Connection conn = DBPool.getInstance().getConnection();

		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement(sql);

			pstmt.setInt(1, materialID);

			rs = pstmt.executeQuery();

			while (rs.next()) {

				
				review = new Review();
				review.setAccountID(rs.getInt(Review.REVIEW_ACCOUNTID));
				review.setComment(rs.getString(Review.REVIEW_COMMENT));
				review.setCommentTime(rs.getDate(Review.REVIEW_COMMENTTIME));
				review.setMaterialID(rs.getInt(Review.REVIEW_MATERIALID));
				review.setRating(rs.getInt(Review.REVIEW_RATING));
				review.setName(rs.getString(Review.REVIEW_NAME));

				reviews.add(review);

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
		return reviews;
	}

	public static void adddReview(Review r) {
		String sql = "insert into rating(accountId, materialId, comment, rating, commentTime, name) values (?,?, ?, ?, ?, ?)";

		Connection conn = DBPool.getInstance().getConnection();
		PreparedStatement pstmt = null;

		/*
		 * Data d; String dateString = "30/1/2000"; //terminal Date date1 =
		 * null; try { date1 = (Date) new
		 * SimpleDateFormat("dd/MM/yyyy").parse(dateString); } catch
		 * (ParseException e1) { // TODO Auto-generated catch block
		 * e1.printStackTrace(); }
		 */

		java.sql.Date timeNow = new Date(Calendar.getInstance().getTimeInMillis());

		try {

			pstmt = conn.prepareStatement(sql);

			pstmt.setInt(1, r.getAccountID());

			pstmt.setInt(2, r.getMaterialID());
			pstmt.setString(3, r.getComment());
			pstmt.setInt(4, r.getRating());
			pstmt.setDate(5, timeNow);
			pstmt.setString(6, r.getName());

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
