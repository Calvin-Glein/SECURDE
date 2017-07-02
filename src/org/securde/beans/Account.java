package org.securde.beans;

import java.io.Serializable;

public class Account implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static final String USER_TABLE_NAME = "account";
	public static final String USER_USERNAME = "userName";
	public static final String USER_PASSWORD = "passWord";
	public static final String USER_USER_ID = "accountid";
	public static final String USER_EMAIL = "eMail";
	public static final String USER_FIRSTNAME = "firstName";
	public static final String USER_MIDDLENAME = "middleName";
	public static final String USER_LASTNAME = "lastName";
	public static final String USER_IDNUMBER = "idNumber";
	public static final String USER_BIRTHDAY = "birthDate";
	public static final String USER_SECRETQUESTION = "sQuestion";
	public static final String USER_SECRETANSWER = "sAnswer";
	public static final String USER_ACCOUNTTYPE = "accountType";
	public static final String USER_PASSWORDEXPIRE = "passwordExpire";
	public static final String USER_ISCHANGED = "isChanged";
	public static final String USER_ISACTIVE = "isActive";

	private String username;
	private String password;
	private String email;
	private String accountid;
	private String firstname;
	private String middlename;
	private String lastname;
	private String idNumber;
	private String birthdate;
	private String sQuestion;
	private String sAnswer;
	private String accountType;
	private String passwordExpire;
	private String isChanged;
	private String isActive;

	public Account() {

	}

	public String getIsActive() {
		return isActive;
	}

	public void setIsActive(String isActive) {
		this.isActive = isActive;
	}

	public Account(String username, String password, String email, String firstname, String middlename, String lastname,
			String idNumber, String birthdate, String sQuestion, String sAnswer, String accountType, String isChanged, String passwordExpire, String isActive) {
		super();
		this.username = username;
		this.password = password;
		this.email = email;
		this.firstname = firstname;
		this.middlename = middlename;
		this.lastname = lastname;
		this.idNumber = idNumber;
		this.birthdate = birthdate;
		this.sQuestion = sQuestion;
		this.sAnswer = sAnswer;
		this.accountType = accountType;
		this.isActive = isActive;
		this.isChanged = isChanged;
		this.passwordExpire = passwordExpire;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAccountid() {
		return accountid;
	}

	public void setAccountid(String accountid) {
		this.accountid = accountid;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getMiddlename() {
		return middlename;
	}

	public void setMiddlename(String middlename) {
		this.middlename = middlename;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getIdNumber() {
		return idNumber;
	}

	public void setIdNumber(String idNumber) {
		this.idNumber = idNumber;
	}

	public String getBirthdate() {
		return birthdate;
	}

	public void setBirthdate(String birthdate) {
		this.birthdate = birthdate;
	}

	public String getsQuestion() {
		return sQuestion;
	}

	public void setsQuestion(String sQuestion) {
		this.sQuestion = sQuestion;
	}

	public String getsAnswer() {
		return sAnswer;
	}

	public void setsAnswer(String sAnswer) {
		this.sAnswer = sAnswer;
	}

	public String getAccountType() {
		return accountType;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}

	public String getPasswordExpire() {
		return passwordExpire;
	}

	public void setPasswordExpire(String passwordExpire) {
		this.passwordExpire = passwordExpire;
	}

	public String getIsChanged() {
		return isChanged;
	}

	public void setIsChanged(String isChanged) {
		this.isChanged = isChanged;
	}

}
