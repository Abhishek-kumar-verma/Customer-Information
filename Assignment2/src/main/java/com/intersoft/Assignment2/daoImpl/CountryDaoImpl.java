package com.intersoft.Assignment2.daoImpl;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.intersoft.Assignment2.dao.CountryDao;
import com.intersoft.Assignment2.entity.City;
import com.intersoft.Assignment2.entity.Countries;
import com.intersoft.Assignment2.entity.State;
import com.intersoft.Assignment2.repository.CityRepository;
import com.intersoft.Assignment2.repository.CountriesRepository;
import com.intersoft.Assignment2.repository.StateRepository;

@Repository
public class CountryDaoImpl implements CountryDao{
	
	@Autowired
	CountriesRepository countryRepo;
	
	@Autowired
	StateRepository stateRepo;
	
	@Autowired
	CityRepository cityRepo;
	
    @Override
    public Countries addCountry(Countries country) {
    	return countryRepo.save(country);
    }
    
	@Override
	public ArrayList<Countries> getAllCountries() {
	    ArrayList<Countries> ans = new ArrayList<>();
	    ans = (ArrayList<Countries>) countryRepo.findAll();
	    return ans;
	}

	@Override
	public ArrayList<State> getStatesByCountryId(int id) {
		return (ArrayList<State>) stateRepo.getStateByCountryId(id);
//		return null;
	}

	@Override
	public ArrayList<City> getCitiesByStateId(int id) {
		return (ArrayList<City>)cityRepo.getCitiesByStateId(id);
//		return null;
	}
	
	@Override
	public Long getZipCode(int id) {
		City city = cityRepo.findById(id).get();
		System.out.println(city.getZip_code());
		return city.getZip_code();
		
	}
}
