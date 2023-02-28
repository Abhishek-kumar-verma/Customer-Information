package com.intersoft.Assignment2.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.intersoft.Assignment2.entity.City;
import com.intersoft.Assignment2.entity.Countries;
import com.intersoft.Assignment2.entity.State;
import com.intersoft.Assignment2.service.CountryService;

@RestController
//@CrossOrigin("http://localhost:3000")
@CrossOrigin(exposedHeaders = {"Access-Control-Allow-Origin","Access-Control-Allow-Credentials"})
public class CountryController {
	
	@Autowired
	CountryService countryService;
	
	@PostMapping("/pushCountry")
	public Countries addCountry(@RequestBody Countries country) {
		return countryService.addCountry(country);
	}
	
    @GetMapping("/getStatesByCountryId/{id}")
    public ArrayList<State> getStatesByCountryId(@PathVariable int id){
    	return countryService.getStatesByCountryId(id);
    }
    
    @GetMapping("/getCitiesByStateId/{state_id}")
    public ArrayList<City> getCitiesByStateId(@PathVariable int state_id){
    	return countryService.getCitiesByStateId(state_id);
    }
    
	@GetMapping("/getAllCountries")
    public ArrayList<Countries> getAllCountries(){
    	return countryService.getAllCountries();
    }
	
	@GetMapping("/getZipCodeByCityId/{id}")
	public Long getZipCode(@PathVariable int id) {
		return countryService.getZipCode(id);
	}
}
