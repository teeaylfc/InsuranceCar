package model;

import java.io.Serializable;
import java.util.Date;

public class RegisterInsurance implements Serializable{
	

	private int riID, insuranceID, cmID, status;
	private String registeredDate ,carNumber;
	
	public RegisterInsurance(){}
	
	public RegisterInsurance(int riID, String carNumber, int insuranceID, String registeredDate, int cmID, int status) {
		super();
		this.riID = riID;
		this.carNumber = carNumber;
		this.insuranceID = insuranceID;
		this.registeredDate = registeredDate;
		this.cmID = cmID;
		this.status = status;
	}
	
	public RegisterInsurance(String carNumber, int insuranceID, String registeredDate, int cmID, int status) {
		super();
		this.carNumber = carNumber;
		this.insuranceID = insuranceID;
		this.registeredDate = registeredDate;
		this.cmID = cmID;
		this.status = status;
	}
	
	public int getRiID() {
		return riID;
	}

	public void setRiID(int riID) {
		this.riID = riID;
	}


	public int getInsuranceID() {
		return insuranceID;
	}

	public void setInsuranceID(int insuranceID) {
		this.insuranceID = insuranceID;
	}

	public String getRegisterDate() {
		return registeredDate;
	}

	public void setRegisterDate(String registeredDate) {
		this.registeredDate = registeredDate;
	}

	public int getCmID() {
		return cmID;
	}

	public void setCmID(int cmID) {
		this.cmID = cmID;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getCarNumber() {
		return carNumber;
	}

	public void setCarNumber(String carNumber) {
		this.carNumber = carNumber;
	}
	
	
}
