package org.securde.beans;

import java.io.Serializable;
import java.sql.Date;

public class Material implements Serializable {
	private static final long serialVersionUID = 1L;
	public static final String MATERIAL_MATERIALID = "materialID";
	public static final String MATERIAL_MATERIALTYPE = "materialType";
	public static final String MATERIAL_DEWEYLOCATION = "deweyLocation";
	public static final String MATERIAL_AUTHOR = "author";
	public static final String MATERIAL_PUBLISHER = "publisher";
	public static final String MATERIAL_YEAR = "year";
	public static final String MATERIAL_TAGS = "tags";
	public static final String MATERIAL_STATUS = "status";
	public static final String MATERIAL_DATERESERVE = "dateReserve";
	public static final String MATERIAL_DATERETURN = "dateReturn";
	public static final String MATERIAL_TITLE = "title";

	private int materialID;
	private String materialType;
	private String location;
	private String author;
	private String publisher;
	private String year;
	private String tags;
	private int status;
	private Date dateReserve;
	private Date dateReturn;
	private String title;
	
	
	public Material(){
		
	}

	public Material(int materialID, String title, String materialType, String deweyLocation, String author, String publisher,
			String year, String tags, int status, Date dateReserve, Date dateReturn) {
		super();
		this.materialID = materialID;
		this.materialType = materialType;
		this.location = deweyLocation;
		this.author = author;
		this.publisher = publisher;
		this.year = year;
		this.tags = tags;
		this.status = status;
		this.dateReserve = dateReserve;
		this.dateReturn = dateReturn;
		this.title = title;
	}

	public int getMaterialID() {
		return materialID;
	}

	public void setMaterialID(int materialID) {
		this.materialID = materialID;
	}

	public String getMaterialType() {
		return materialType;
	}

	public void setMaterialType(String materialType) {
		this.materialType = materialType;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String deweyLocation) {
		this.location = deweyLocation;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public String getTags() {
		return tags;
	}

	public void setTags(String tags) {
		this.tags = tags;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public Date getDateReserve() {
		return dateReserve;
	}

	public void setDateReserve(Date dateReserve) {
		this.dateReserve = dateReserve;
	}

	public Date getDateReturn() {
		return dateReturn;
	}

	public void setDateReturn(Date dateReturn) {
		this.dateReturn = dateReturn;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

}
