package com.demo.model;

public class BookingList {
	
	private int UserID;
	private int SID;
	private String SNameFirst;
	private String SNameLast;
	private int PhoneNumber;
	private double Wages;
	private int Ratings;
	
	
	public BookingList() {
		super();
	}
	
	
	public BookingList(int userID, int sID, String sNameFirst, String sNameLast, int phoneNumber, double wages,
			int ratings) {
		super();
		UserID = userID;
		SID = sID;
		SNameFirst = sNameFirst;
		SNameLast = sNameLast;
		PhoneNumber = phoneNumber;
		Wages = wages;
		Ratings = ratings;
	}


	public int getUserID() {
		return UserID;
	}
	public void setUserID(int userID) {
		UserID = userID;
	}
	public int getSID() {
		return SID;
	}
	public void setSID(int sID) {
		SID = sID;
	}
	public String getSNameFirst() {
		return SNameFirst;
	}
	public void setSNameFirst(String sNameFirst) {
		SNameFirst = sNameFirst;
	}
	public String getSNameLast() {
		return SNameLast;
	}
	public void setSNameLast(String sNameLast) {
		SNameLast = sNameLast;
	}
	public int getPhoneNumber() {
		return PhoneNumber;
	}
	public void setPhoneNumber(int phoneNumber) {
		PhoneNumber = phoneNumber;
	}
	public double getWages() {
		return Wages;
	}
	public void setWages(double wages) {
		Wages = wages;
	}
	public int getRatings() {
		return Ratings;
	}
	public void setRatings(int ratings) {
		Ratings = ratings;
	}
	@Override
	public String toString() {
		return "BookingList [UserID=" + UserID + ", SID=" + SID + ", SNameFirst=" + SNameFirst + ", SNameLast="
				+ SNameLast + ", PhoneNumber=" + PhoneNumber + ", Wages=" + Wages + ", Ratings=" + Ratings + "]";
	}
	
	
}





