package com.portfoliomanager.pma.dto;

public class StockDTO {
	
private int id;
	
	private String name;
	private double pricePurchased;
	int quantityPurchased;
	private String purchaseDate;
	private double amountInvested;
	private double currentValueOfInvestment;
	
	
	
	public StockDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public StockDTO(int id, String name, double pricePurchased, int quantityPurchased, String purchaseDate,
			double amountInvested,
			double currentValueOfInvestment) {
		super();
		this.id = id;
		this.name = name;
		this.pricePurchased = pricePurchased;
		this.quantityPurchased = quantityPurchased;
		this.purchaseDate = purchaseDate;
		this.amountInvested=amountInvested;
		this.currentValueOfInvestment=currentValueOfInvestment;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getPricePurchased() {
		return pricePurchased;
	}
	public void setPricePurchased(double pricePurchased) {
		this.pricePurchased = pricePurchased;
	}
	public int getQuantityPurchased() {
		return quantityPurchased;
	}
	public void setQuantityPurchased(int quantityPurchased) {
		this.quantityPurchased = quantityPurchased;
	}
	public String getPurchaseDate() {
		return purchaseDate;
	}
	public void setPurchaseDate(String purchaseDate) {
		this.purchaseDate = purchaseDate;
	}
	public double getAmountInvested() {
		return amountInvested;
	}
	public void setAmountInvested(double amountInvested) {
		this.amountInvested = amountInvested;
	}
	public double getCurrentValueOfInvestment() {
		return currentValueOfInvestment;
	}
	public void setCurrentValueOfInvestment(double currentValueOfInvestment) {
		this.currentValueOfInvestment = currentValueOfInvestment;
	}
	
	
	

}
