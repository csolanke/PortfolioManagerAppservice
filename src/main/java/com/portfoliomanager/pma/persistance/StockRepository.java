package com.portfoliomanager.pma.persistance;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.portfoliomanager.pma.domain.Stock;

@Repository
public interface StockRepository extends JpaRepository<Stock, Integer> {
	
	List<Stock> findByName(String name);

	

}
