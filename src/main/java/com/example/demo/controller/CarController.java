package com.example.demo.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.model.Car;
import com.example.demo.repository.CarRepository;

@Controller
public class CarController {

    private final CarRepository carRepository;

    public CarController(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    @GetMapping("/")
    public String home(Model model) {
        return "index";
    }

    @GetMapping("/selectBrand")
    public String selectBrand(Model model) {
        List<String> distinctBrands = carRepository.findDistinctBrands();
        model.addAttribute("brands", distinctBrands);
        model.addAttribute("car", new Car());
        return "selectBrand";
    }

    @PostMapping("/getCarByBrand")
    public String getCarByBrand(@ModelAttribute("car") Car car, Model model) {
        List<Car> cars = carRepository.findByBrand(car.getBrand());
        model.addAttribute("cars", cars);
        return "getCarByBrand";
    }
    
    @PostMapping("/selectedCar")
    public String selectedCar(@RequestParam Long selectedCar, Model model) {
        Car car = carRepository.findById(selectedCar).orElseThrow(() -> new IllegalArgumentException("Invalid car Id:" + selectedCar));
        model.addAttribute("car", car);
        return "congratulations";
    }
    
    @GetMapping("/searchByPrice")
    public String searchByPrice(Model model) {
        model.addAttribute("car", new Car());
        return "searchByPrice";
    }
    
    @PostMapping("/searchByPrice")
    public String processSearchByPrice(@RequestParam String priceRange, Model model) {
        int maxPrice = 500000;

        if ("lessThan".equals(priceRange)) {
            List<Car> affordableCars = carRepository.findByPriceLessThan(maxPrice);
            model.addAttribute("cars", affordableCars);
        } else if ("moreThan".equals(priceRange)) {
            List<Car> luxuryCars = carRepository.findByPriceGreaterThanEqual(maxPrice);
            model.addAttribute("cars", luxuryCars);
        }

        return "displayCarsByPrice";
    }
}
