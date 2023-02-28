package com.intersoft.Assignment2.entity;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Abhishek_City")
public class City {
	
	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
	private int city_id;
	private String city_name;
	private long zip_code;
	private boolean is_deleted;
	private LocalDate created_date;
	private LocalDate modified_date;
	
	
	public LocalDate getCreated_date() {
		return created_date;
	}

	public void setCreated_date(LocalDate created_date) {
		this.created_date = created_date;
	}

	public LocalDate getModified_date() {
		return modified_date;
	}


	
	
	public boolean isIs_deleted() {
		return is_deleted;
	}

	public void setIs_deleted(boolean is_deleted) {
		this.is_deleted = is_deleted;
	}

	public int getCity_id() {
		return city_id;
	}

	public void setCity_id(int city_id) {
		this.city_id = city_id;
	}

	public String getCity_name() {
		return city_name;
	}

	public void setCity_name(String city_name) {
		this.city_name = city_name;
	}

	public long getZip_code() {
		return zip_code;
	}
	public void setZip_code(long zip_code) {
		this.zip_code = zip_code;
	}
	

}
