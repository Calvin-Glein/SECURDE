package org.securde.services;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

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
}
