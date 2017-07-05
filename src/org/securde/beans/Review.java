package org.securde.beans;

import java.sql.Date;

public class Review {

	public static final String REVIEW_TABLE_NAME = "rating";
	public static final String REVIEW_ACCOUNTID = "accountId";
	public static final String REVIEW_MATERIALID = "materialId";
	public static final String REVIEW_COMMENT = "comment";
	public static final String REVIEW_RATING = "rating";
	public static final String REVIEW_COMMENTTIME = "commentTime";
	public static final String REVIEW_NAME = "name";

	private int accountID;
	private int materialID;
	private String comment;
	private int rating;
	private Date commentTime;
	private String name;

	public Review(){
		
	}
	
	public Review(int accountID, int materialID, String comment, int rating, Date commentTime, String name) {
		super();
		this.accountID = accountID;
		this.materialID = materialID;
		this.comment = comment;
		this.rating = rating;
		this.commentTime = commentTime;
		this.name = name;
	}

	public int getAccountID() {
		return accountID;
	}

	public void setAccountID(int accountID) {
		this.accountID = accountID;
	}

	public int getMaterialID() {
		return materialID;
	}

	public void setMaterialID(int materialID) {
		this.materialID = materialID;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	public Date getCommentTime() {
		return commentTime;
	}

	public void setCommentTime(Date commentTime) {
		this.commentTime = commentTime;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
