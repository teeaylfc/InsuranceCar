package model;

import java.io.Serializable;
import java.util.Date;

public class OwnCar implements Serializable{
	
	private int owncarID, cmID, haveInsurance, numberOfSeat;
	private String carNumber,brand;
	
	public OwnCar(){}
	
	public OwnCar(int owncarID, int cmID, int haveInsurance, int numberOfSeat, String carNumber, String brand) {
		super();
		this.owncarID = owncarID;
		this.cmID = cmID;
		this.haveInsurance = haveInsurance;
		this.numberOfSeat = numberOfSeat;
		this.carNumber = carNumber;
		this.brand = brand;
	}
	public OwnCar(int cmID, int haveInsurance, int numberOfSeat, String carNumber, String brand) {
		super();
		this.cmID = cmID;
		this.haveInsurance = haveInsurance;
		this.numberOfSeat = numberOfSeat;
		this.carNumber = carNumber;
		this.brand = brand;
	}
	public int getOwncarID() {
		return owncarID;
	}
	public void setOwncarID(int owncarID) {
		this.owncarID = owncarID;
	}
	public int getCmID() {
		return cmID;
	}
	public void setCmID(int cmID) {
		this.cmID = cmID;
	}
	public int getHaveInsurance() {
		return haveInsurance;
	}
	public void setHaveInsurance(int haveInsurance) {
		this.haveInsurance = haveInsurance;
	}
	public int getNumberOfSeat() {
		return numberOfSeat;
	}
	public void setNumberOfSeat(int numberOfSeat) {
		this.numberOfSeat = numberOfSeat;
	}
	public String getCarNumber() {
		return carNumber;
	}
	public void setCarNumber(String carNumber) {
		this.carNumber = carNumber;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}

}
