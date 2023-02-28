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
@Table(name="Abhishek_Country")
public class Countries {
	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
	private int country_id;
	private String country_name;
	private boolean is_deleted ;
	private LocalDate created_date;
	private LocalDate modified_date =java.time.LocalDate.now();
	
	@OneToMany(targetEntity=State.class  ,cascade= CascadeType.ALL)
	@JoinColumn(name="country_id" , referencedColumnName = "country_id")
	private List<State> states;
	
	public boolean isIs_deleted() {
		return is_deleted;
	}

	public void setIs_deleted(boolean is_deleted) {
		this.is_deleted = is_deleted;
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



	public int getCountry_id() {
		return country_id;
	}

	public void setCountry_id(int country_id) {
		this.country_id = country_id;
	}

	public String getCountry_name() {
		return country_name;
	}

	public void setCountry_name(String country_name) {
		this.country_name = country_name;
	}

	public List<State> getStates() {
		return states;
	}

	public void setStates(List<State> states) {
		states = states;
	}
	
	
	

}
