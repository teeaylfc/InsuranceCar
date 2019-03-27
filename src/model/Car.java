package model;

import java.io.Serializable;
import java.sql.*;

public class Car implements Serializable{
	private int carID;
	private String name, description, brand, imageCar;
	private int productDate;
	private long price;
	private int quantityStock;
	
	public Car() {
		
	}
	
	public Car(String name, String description, String brand, int date, long price, int quantityStock, String imageCar) {
		super();
		this.name = name;
		this.description = description;
		this.brand = brand;
		this.productDate = date;
		this.price = price;
		this.quantityStock = quantityStock;
		this.imageCar = imageCar;
	}
	public Car(String name, String description, String brand, int date, long price, int quantityStock) {
		super();
		this.name = name;
		this.description = description;
		this.brand = brand;
		this.productDate = date;
		this.price = price;
		this.quantityStock = quantityStock;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public int getProductDate() {
		return productDate;
	}
	public void setProductDate(int date) {
		this.productDate = date;
	}
	public long getPrice() {
		return price;
	}
	public void setPrice(long price) {
		this.price = price;
	}
	public int getQuantityStock() {
		return quantityStock;
	}
	public void setQuantityStock(int quantityStock) {
		this.quantityStock = quantityStock;
	}

	public int getCarID() {
		return carID;
	}

	public void setCarID(int carID) {
		this.carID = carID;
	}
	public String getImageCar() {
		return imageCar;
	}
	public void setImageCar(String imageCar) {
		this.imageCar = imageCar;
	}
	
	
}
