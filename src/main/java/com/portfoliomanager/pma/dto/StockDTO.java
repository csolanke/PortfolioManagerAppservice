package com.portfoliomanager.pma.dto;

public class StockDTO {
	
private int id;
	
	private String Name;
	private double pricePurchased;
	int QuantityPurchased;
	private String purchaseDate;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public double getPricePurchased() {
		return pricePurchased;
	}
	public void setPricePurchased(double pricePurchased) {
		this.pricePurchased = pricePurchased;
	}
	public int getQuantityPurchased() {
		return QuantityPurchased;
	}
	public void setQuantityPurchased(int quantityPurchased) {
		QuantityPurchased = quantityPurchased;
	}
	public String getPurchaseDate() {
		return purchaseDate;
	}
	public void setPurchaseDate(String purchaseDate) {
		this.purchaseDate = purchaseDate;
	}
	
	

}
