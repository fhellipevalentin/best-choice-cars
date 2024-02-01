package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.model.Car;

public interface CarRepository extends JpaRepository<Car, Long>{
	
	List<Car> findByBrand(String brand);
	
	@Query("SELECT DISTINCT c.brand FROM Car c")
    List<String> findDistinctBrands();
	
	List<Car> findByPriceLessThan(int maxPrice);

    List<Car> findByPriceGreaterThanEqual(int minPrice);
}
