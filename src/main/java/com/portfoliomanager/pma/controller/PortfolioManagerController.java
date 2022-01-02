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
		return new ResponseEntity<>(holdingList, HttpStatus.OK);
 }


@GetMapping("/stocks/{id}")
public ResponseEntity<StockDTO> fetchStockById(@PathVariable("id") int stockId) {

	Stock stock = service.getStock(stockId);
	
	StockDTO dto = mapper.stockEntityToDTO(stock);
    return new ResponseEntity<>(dto,HttpStatus.OK); 
	  
}


@PostMapping("/stocks")
public ResponseEntity<StockDTO>  addStock(@RequestBody StockDTO stockDTO) {
	
	
       Stock stock =mapper.stockDTOToEntity(stockDTO);
       Stock savedstock = service.addStock(stock);
       
       StockDTO dto = mapper.stockEntityToDTO(savedstock);

	return new ResponseEntity<>(dto,HttpStatus.CREATED);
    
}

@PutMapping("/stocks/{id}")
public ResponseEntity<StockDTO> updateStock(@PathVariable("id") int stockId, @RequestBody StockDTO stockDto) {
	
	  Stock stock =service.getStock(stockId);
	        stock.setName(stockDto.getName());
	        stock.setPricePurchased(stockDto.getPricePurchased());
	        stock.setPurchaseDate(stockDto.getPurchaseDate());
	        stock.setQuantityPurchased(stockDto.getQuantityPurchased());
	        stock.setAmountInvested(stockDto.getAmountInvested());
	        stock.setCurrentValueOfInvestment(stockDto.getCurrentValueOfInvestment());
	        stock.setPurchaseStrategy(stockDto.getPurchaseStrategy());
	        
	        service.updateStock(stockId, stock);
	        
	       StockDTO dto = mapper.stockEntityToDTO(stock);
	        
	        
	
	
	return ResponseEntity.ok(dto);
}


@DeleteMapping("/stocks/{id}")
public ResponseEntity<?>  deleteStockById(@PathVariable("id") int stockId)
{
    service.deleteStock(stockId);	
    
    return new ResponseEntity<>(HttpStatus.OK);
}

}
