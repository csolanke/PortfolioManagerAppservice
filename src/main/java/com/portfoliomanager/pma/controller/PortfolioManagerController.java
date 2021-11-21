package com.portfoliomanager.pma.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.portfoliomanager.pma.domain.Stock;
import com.portfoliomanager.pma.dto.StockDTO;
import com.portfoliomanager.pma.mapper.StockMapper;
import com.portfoliomanager.pma.service.StockService;

@RestController
@RequestMapping("/api/v1")
public class PortfolioManagerController {
	
	
@Autowired
private StockService service;
@Autowired
private StockMapper mapper;
	

@GetMapping("/stocks")
 public List<Stock> fetchAllStocksFromHoldings()
 {
	return service.getAllStocks();
 }


@GetMapping("/stocks/{id}")
public StockDTO  fetchStockById(@PathVariable("id") int stockId) {
	 Stock stockEntity = service.getStock(stockId);
	 
 return mapper.stockEntityToDTO(stockEntity);
	 
}


@PostMapping("/stocks")
public void  addStock(@RequestBody StockDTO stockDTO) {
	
    service.addStock(mapper.stockDTOToEntity(stockDTO));
    
}

@PutMapping("/stocks/{id}")
public void updateStock(@PathVariable("id") int stockId, @RequestBody StockDTO stockDto) {
	
    service.updateStock(stockId, mapper.stockDTOToEntity(stockDto));
}


@DeleteMapping("/stocks/{id}")
public void deleteStockById(@PathVariable("id") int stockId)
{
    service.deleteStock(stockId);	
}




}
