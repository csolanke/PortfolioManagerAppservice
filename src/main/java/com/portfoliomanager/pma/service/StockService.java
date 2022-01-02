package com.portfoliomanager.pma.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.portfoliomanager.pma.domain.Stock;
import com.portfoliomanager.pma.persistance.StockRepository;
import com.portfoliomanager.pma.domain.exception.ResourceExistException;
import com.portfoliomanager.pma.domain.exception.ResourceNotFoundException;

@Service
public class StockService {

	
	private StockRepository repo;

	public StockService(StockRepository repo) {
		this.repo = repo;
	}
	
	
	
	public List<Stock> getAllStocks(){
		return repo.findAll();
		
	}
	
	
	public Stock getStock(int id)
	{
		return repo.findById(id).orElseThrow(()-> new ResourceNotFoundException("Stock with requested Id:"+id+" does not exist"));
	}
	
	public Stock addStock(Stock stock)
	{
		List<Stock> stockList =repo.findByName(stock.getName());
		if(stockList.isEmpty()) {
			repo.save(stock);
		}
		else {
			throw new ResourceExistException("Stock alreday exist in holding list");
		}
		
		return stock;
	
	}
	
	
	public void updateStock(int id, Stock stock) {
        repo.save(stock);
    }

    public void deleteStock(int id) {
        repo.deleteById(id);
    }
    
   public List<Stock> findStocksByName(String name)
   {
	return repo.findByName(name);
	   
   }	
	
	
	
}
