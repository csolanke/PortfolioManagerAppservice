package com.portfoliomanager.pma.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.portfoliomanager.pma.application.ResourceNotFoundException;
import com.portfoliomanager.pma.domain.Stock;
import com.portfoliomanager.pma.dto.StockDTO;
import com.portfoliomanager.pma.mapper.StockMapper;
import com.portfoliomanager.pma.service.StockService;


@CrossOrigin
@RestController
@RequestMapping("/api/v1")
public class PortfolioManagerController {
	
	
@Autowired
private StockService service;
@Autowired
private StockMapper mapper;


@GetMapping("/stocks")
 public ResponseEntity<List<Stock>>  fetchAllStocksFromHoldings()
 {
	List<Stock> holdingList = service.getAllStocks();
	
	if(null!=holdingList)
	{
		return new ResponseEntity<>(holdingList, HttpStatus.OK);
	}
	return null;
	

 }


@GetMapping("/stocks/{id}")
public ResponseEntity<Stock> fetchStockById(@PathVariable("id") int stockId) {

	   Stock stock = service.getStock(stockId);
	   if(null!= stock)
	   {
		   return new ResponseEntity<>(stock,HttpStatus.OK); 
	   }
	   else{
		   
		   throw new ResourceNotFoundException("Stock with requested Id does not exist");
	   }
	 
}


@PostMapping("/stocks")
public ResponseEntity<Stock>  addStock(@RequestBody StockDTO stockDTO) {
	
	
	List<Stock> stockList =service.findStocksByName(stockDTO.getName());
	if(stockList.isEmpty())
	{
		service.addStock(mapper.stockDTOToEntity(stockDTO));
	}

	return new ResponseEntity<>(HttpStatus.OK);
    
}

@PutMapping("/stocks/{id}")
public ResponseEntity<Stock> updateStock(@PathVariable("id") int stockId, @RequestBody StockDTO stockDto) {
	
	  Stock stock =service.getStock(stockId);
	        stock.setName(stockDto.getName());
	        stock.setPricePurchased(stockDto.getPricePurchased());
	        stock.setPurchaseDate(stockDto.getPurchaseDate());
	        stock.setQuantityPurchased(stockDto.getQuantityPurchased());
	        stock.setAmountInvested(stockDto.getAmountInvested());
	        stock.setCurrentValueOfInvestment(stockDto.getCurrentValueOfInvestment());
	        stock.setPurchaseStrategy(stockDto.getPurchaseStrategy());
	        
	        service.addStock(stock);
	
	
	return ResponseEntity.ok(stock);
}


@DeleteMapping("/stocks/{id}")
public ResponseEntity<Stock>  deleteStockById(@PathVariable("id") int stockId)
{
    service.deleteStock(stockId);	
    
    return new ResponseEntity<>(HttpStatus.OK);
}




}
