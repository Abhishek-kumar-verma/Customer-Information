package com.intersoft.Assignment2.entity;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="Abhishek_State")
public class State{
	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
	private int state_id;
    private String state_name;
	private boolean is_deleted;
	private LocalDate created_date;
	private LocalDate modified_date =java.time.LocalDate.now();
	
	@OneToMany(targetEntity = City.class , cascade = CascadeType.ALL)
	@JoinColumn(name="state_id", referencedColumnName = "state_id" )
	private List<City> cities;
	
	
	
	public boolean isIs_deleted() {
		return is_deleted;
	}

	public void setIs_deleted(boolean is_deleted) {
		this.is_deleted = is_deleted;
	}

	
	
	public int getState_id() {
		return state_id;
	}

	public void setState_id(int state_id) {
		this.state_id = state_id;
	}

	public String getState_name() {
		return state_name;
	}

	public void setState_name(String state_name) {
		this.state_name = state_name;
	}

	public List<City> getCities() {
		return cities;
	}

	public void setCities(List<City> cities) {
		this.cities = cities;
	}

	public LocalDate getCreated_date() {
		return created_date;
	}

	public void setCreated_date(LocalDate created_date) {
		this.created_date = created_date;
	}

	public LocalDate getModified_date() {
		return modified_date;
	}



	
	

}
