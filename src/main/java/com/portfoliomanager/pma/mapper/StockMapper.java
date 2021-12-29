package com.portfoliomanager.pma.mapper;

import org.springframework.stereotype.Component;

import com.portfoliomanager.pma.domain.Stock;
import com.portfoliomanager.pma.dto.StockDTO;

@Component
public class StockMapper {
	
	public Stock stockDTOToEntity(StockDTO dto)
	{
		if(null!=dto)
		{ 
			Stock stock = new Stock();
			
			stock.setId(dto.getId());
			stock.setName(dto.getName());
			stock.setPricePurchased(dto.getPricePurchased());
			stock.setPurchaseDate(dto.getPurchaseDate());
			stock.setQuantityPurchased(dto.getQuantityPurchased());
			stock.setAmountInvested(dto.getAmountInvested());
			stock.setCurrentValueOfInvestment(dto.getCurrentValueOfInvestment());
			
			return stock;
		}
		return null;
	}
	
	public StockDTO stockEntityToDTO( Stock stock)
	{
		if(null!=stock)
		{
			StockDTO dto = new StockDTO();
			
			dto.setId(stock.getId());
			dto.setName(stock.getName());
			dto.setPricePurchased(stock.getPricePurchased());
			dto.setPurchaseDate(stock.getPurchaseDate());
			dto.setQuantityPurchased(stock.getQuantityPurchased());
			dto.setAmountInvested(stock.getAmountInvested());
			dto.setCurrentValueOfInvestment(stock.getCurrentValueOfInvestment());
			
			return dto;
		}
		
		return null;
	}

}
