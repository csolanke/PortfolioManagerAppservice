package com.portfoliomanager.pma.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.portfoliomanager.pma.domain.Stock;
import com.portfoliomanager.pma.persistance.StockRepository;

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
		return repo.findById(id).orElseGet(Stock::new);
	}
	
	public void addStock(Stock stock)
	{
		repo.save(stock);
	
	}
	
	
	public void updateStock(int id, Stock stock) {
        repo.save(stock);
    }

    public void deleteStock(int id) {
        repo.deleteById(id);
    }
	
	
	
	
}
