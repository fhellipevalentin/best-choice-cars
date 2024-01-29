package com.example.demo.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.example.demo.model.Car;
import com.example.demo.repository.CarRepository;

@Component
public class DataInitializer implements CommandLineRunner{
	
	@Autowired
	public CarRepository carRepository;
	
	@Override
	public void run(String... args) throws Exception {
		if (carRepository.count() == 0) {
			Car car = new Car();
			car.setBrand("Hyundai");
			car.setModel("I10");
			car.setYearOfManufacture("2019");
			car.setKm("10000");
			car.setPrice("300000");
			car.setFuel("Petrol");
			Car car2 = new Car();
			car2.setBrand("Hyundai");
			car2.setModel("I20");
			car2.setYearOfManufacture("2018");
			car2.setKm("20000");
			car2.setPrice("200000");
			car2.setFuel("Diesel");
			Car car3 = new Car();
			car3.setBrand("Hyundai");
			car3.setModel("Verna");
			car3.setYearOfManufacture("2019");
			car3.setKm("15000");
			car3.setPrice("250000");
			car3.setFuel("Petrol");
			Car car4 = new Car();
			car4.setBrand("Tata");
			car4.setModel("Bolt");
			car4.setYearOfManufacture("2019");
			car4.setKm("15000");
			car4.setPrice("250000");
			car4.setFuel("Petrol");
			Car car5 = new Car();
			car5.setBrand("Maruthi Suzuki");
			car5.setModel("Ciaz");
			car5.setYearOfManufacture("2019");
			car5.setKm("5000");
			car5.setPrice("600000");
			car5.setFuel("Petrol");
			Car car6 = new Car();
			car6.setBrand("Honda");
			car6.setModel("jazz");
			car6.setYearOfManufacture("2018");
			car6.setKm("20000");
			car6.setPrice("600000");
			car6.setFuel("Diesel");
			Car car7 = new Car();
			car7.setBrand("Honda");
			car7.setModel("City");
			car7.setYearOfManufacture("2019");
			car7.setKm("15000");
			car7.setPrice("400000");
			car7.setFuel("");
			Car car8 = new Car();
			car8.setBrand("Maruthi Suzuki");
			car8.setModel("");
			car8.setYearOfManufacture("2019");
			car8.setKm("10000");
			car8.setPrice("550000");
			car8.setFuel("Petrol");
			Car car9 = new Car();
			car9.setBrand("Tata");
			car9.setModel("Nexon");
			car9.setYearOfManufacture("2019");
			car9.setKm("5000");
			car9.setPrice("600000");
			car9.setFuel("Petrol");
			carRepository.saveAll(Arrays.asList(car, car2, car3, car4, car5, car6, car7, car8, car9));
		}	
	}
}
