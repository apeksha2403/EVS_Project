package com.spring.entity;

import java.time.LocalDate;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "evs_tbl_user_profile")
public class UserEntity {

	@GeneratedValue(strategy = GenerationType.AUTO)
	@Id
	@Column()
	private int userId;

	@Column()
	private String firstName;

	@Column()
	private String lastName;

	@Column()
	private LocalDate dateOfBirth;

	@Column()
	private String gender;

	@Column()
	private String street;

	@Column()
	private String constituency;

	@Column()
	private String city;

	@Column()
	private String state;

	@Column()
	private String emailId;

	@Column()
	private String mobileNo;

	@Column()
	private int pincode;

	@Column()
	private String password;

	@Column()
	private String userType;

	
	@Column()
	private int loginStatus=0;
	
	@Column()
	private String sessionId;
	
	
	public UserEntity() {
		super();
	}

	public UserEntity(int userId, String firstName, String lastName, LocalDate dateOfBirth, String gender,
			String street, String constituency, String city, String state, String emailId, String mobileNo, int pincode,
			String password, String userType) {
		super();
		this.userId = userId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.dateOfBirth = dateOfBirth;
		this.gender = gender;
		this.street = street;
		this.constituency = constituency;
		this.city = city;
		this.state = state;
		this.emailId = emailId;
		this.mobileNo = mobileNo;
		this.pincode = pincode;
		this.password = password;
		this.userType = userType;
	}

	public UserEntity(String firstName, String lastName, LocalDate dateOfBirth, String gender, String street,
			String constituency, String city, String state, String emailId, String mobileNo, int pincode,
			String password, String userType) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.dateOfBirth = dateOfBirth;
		this.gender = gender;
		this.street = street;
		this.constituency = constituency;
		this.city = city;
		this.state = state;
		this.emailId = emailId;
		this.mobileNo = mobileNo;
		this.pincode = pincode;
		this.password = password;
		this.userType = userType;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(LocalDate dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getConstituency() {
		return constituency;
	}

	public void setConstituency(String constituency) {
		this.constituency = constituency;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}

	public int getPincode() {
		return pincode;
	}

	public void setPincode(int pincode) {
		this.pincode = pincode;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUserType() {
		return userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}

	public int getLoginStatus() {
		return loginStatus;
	}

	public void setLoginStatus(int loginStatus) {
		this.loginStatus = loginStatus;
	}

	public String getSessionId() {
		return sessionId;
	}

	public void setSessionId(String sessionId) {
		this.sessionId = sessionId;
	}

	@Override
	public String toString() {
		return "UserEntity [userId=" + userId + ", firstName=" + firstName + ", lastName=" + lastName + ", dateOfBirth="
				+ dateOfBirth + ", gender=" + gender + ", street=" + street + ", constituency=" + constituency
				+ ", city=" + city + ", state=" + state + ", emailId=" + emailId + ", mobileNo=" + mobileNo
				+ ", pincode=" + pincode + ", password=" + password + ", userType=" + userType + "]";
	}

	

	
}
