package model;

import java.io.Serializable;

public class Insurance implements Serializable{
	
	
	private int insuranceID;
	private String name;
	private String description;
	private int quantityStock;
	private String forBrand;
	private int type;
	private int exp;
	private long price;
	
	public Insurance() {
		// TODO Auto-generated constructor stub
	}
	
	public Insurance(String name, String description, int quantityStock, String forBrand, int type, int exp,
			long price) {
		super();
		this.name = name;
		this.description = description;
		this.quantityStock = quantityStock;
		this.forBrand = forBrand;
		this.type = type;
		this.exp = exp;
		this.price = price;
	}
	public int getInsuranceID() {
		return insuranceID;
	}
	public void setInsuranceID(int insuranceID) {
		this.insuranceID = insuranceID;
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
	public int getQuantityStock() {
		return quantityStock;
	}
	public void setQuantityStock(int quantityStock) {
		this.quantityStock = quantityStock;
	}
	public String getForBrand() {
		return forBrand;
	}
	public void setForBrand(String forBrand) {
		this.forBrand = forBrand;
	}
	public void setExp(int exp) {
		this.exp = exp;
	}
	public int getExp() {
		return exp;
	}
	public void setPrice(long price) {
		this.price = price;
	}
	public Long getPrice() {
		return price;
	}
	public void setType(int type) {
		this.type = type;
	}
	public int getType() {
		return type;
	}
	
}
