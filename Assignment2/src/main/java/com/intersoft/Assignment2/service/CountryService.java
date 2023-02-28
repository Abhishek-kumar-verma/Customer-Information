package com.intersoft.Assignment2.service;

import java.util.ArrayList;

import org.springframework.stereotype.Component;

import com.intersoft.Assignment2.entity.City;
import com.intersoft.Assignment2.entity.Countries;
import com.intersoft.Assignment2.entity.State;

@Component
public interface CountryService {
	Countries addCountry(Countries country);
	ArrayList<Countries> getAllCountries();
	ArrayList<State> getStatesByCountryId(int id);
	ArrayList<City> getCitiesByStateId(int id);
	Long getZipCode(int id);
}
