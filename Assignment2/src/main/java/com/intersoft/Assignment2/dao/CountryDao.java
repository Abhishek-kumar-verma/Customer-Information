package com.intersoft.Assignment2.dao;

import java.util.ArrayList;

import org.springframework.stereotype.Component;

import com.intersoft.Assignment2.entity.City;
import com.intersoft.Assignment2.entity.Countries;
import com.intersoft.Assignment2.entity.State;

@Component
public interface CountryDao {
	ArrayList<Countries> getAllCountries();
	Countries addCountry(Countries country);
	ArrayList<State> getStatesByCountryId(int id);
	ArrayList<City> getCitiesByStateId(int id);
	Long getZipCode(int id);
}
