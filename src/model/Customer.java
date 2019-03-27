package model;

import java.io.Serializable;

public class Customer implements Serializable{
	
	
	
	private String account, password, name, gender,address, phone;
	private String dob;
	private int cmID;
	
	public Customer(String account, String password, String name, String gender, String address, String phone, String dob,
			int cmID) {
		super();
		this.account = account;
		this.password = password;
		this.name = name;
		this.gender = gender;
		this.address = address;
		this.phone = phone;
		this.dob = dob;
		this.cmID = cmID;
	}
	public Customer(String account, String password, String name, String gender, String address, String phone, String dob) {
		super();
		this.account = account;
		this.password = password;
		this.name = name;
		this.gender = gender;
		this.address = address;
		this.phone = phone;
		this.dob = dob;
	}
	
	public Customer() {
		super();
	}
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getDob() {
		return dob;
	}
	public void setDob(String dob) {
		this.dob = dob;
	}
	public int getCmID() {
		return cmID;
	}
	public void setCmID(int cmID) {
		this.cmID = cmID;
	}
	
	
}
