package com.intersoft.Assignment2.serviceImpl;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.intersoft.Assignment2.dao.CountryDao;
import com.intersoft.Assignment2.entity.City;
import com.intersoft.Assignment2.entity.Countries;
import com.intersoft.Assignment2.entity.State;
import com.intersoft.Assignment2.service.CountryService;

@Service
public class CountryServiceImpl implements CountryService{
	
	@Autowired
	CountryDao countryDao;
	
	@Override
	public Countries addCountry(Countries country) {
		return countryDao.addCountry(country);
	}
	
	@Override
	public ArrayList<Countries> getAllCountries() {
		return countryDao.getAllCountries();
	}

	@Override
	public ArrayList<State> getStatesByCountryId(int id) {
		return countryDao.getStatesByCountryId(id);
	}

	@Override
	public ArrayList<City> getCitiesByStateId(int id) {
		return countryDao.getCitiesByStateId(id);
	}
	
	@Override
	public Long getZipCode( int id) {
		return countryDao.getZipCode(id);
	}

}
