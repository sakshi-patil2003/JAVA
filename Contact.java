package com.sakshi.contactmanager.entity;

public class Contact {

	private int id;
	private String firstName;
	private String lastName;
	private long mobileNo;
	private long workPlaceNo;
	private String email;
	
	public Contact() {
		super();
		
	} 


public Contact(int id, String firstName, String lastName, long mobileNo, long workPlaceNo, String email) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.mobileNo = mobileNo;
		this.workPlaceNo = workPlaceNo;
		this.email = email;
	}

//	}

	public int getId() {
		return id;
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

	public long getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(long mobileNo) {
		this.mobileNo = mobileNo;
	}

	public long getWorkPlaceNo() {
		return workPlaceNo;
	}

	public void setWorkPlaceNo(long workPlaceNo) {
		this.workPlaceNo = workPlaceNo;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "Contact [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", mobileNo=" + mobileNo
				+ ", workPlaceNo=" + workPlaceNo + ", email=" + email + "]";
	} 
	
	
	
}
