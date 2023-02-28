package com.intersoft.Assignment2.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Component;

import com.intersoft.Assignment2.entity.City;
import com.intersoft.Assignment2.entity.State;

@Component
public interface CityRepository extends JpaRepository<City,Integer> {
	@Query(value="select * from Abhishek_City c where c.state_id =:state_id ",nativeQuery=true)
    public List<City> getCitiesByStateId(@Param("state_id") int state_id);
	
//	@Query(value="select * from Abhishek_City c where c.city_id =:id ",nativeQuery=true)
//    public City getZipCodeByCityId(@Param("city_id") int id);
	
     
}
