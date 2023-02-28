package com.intersoft.Assignment2.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Component;

import com.intersoft.Assignment2.entity.City;
import com.intersoft.Assignment2.entity.State;

@Component
public interface StateRepository extends JpaRepository<State,Integer> {
	
	@Query(value="select * from Abhishek_State c where c.country_id =:country_id ",nativeQuery=true)
    public List<State> getStateByCountryId(@Param("country_id") int country_id);

}
