package com.intersoft.Assignment2.entity;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="VBS3120_Customer")
public class Customer {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;
	private String name;
	private String description;
	private String address;
	private String contact_email;
	private String country;
	private String state;
	private String city;
	private Long zip;
	private String contact_name;
	private Long contact_phone;
	private String[] violation_category;
	private boolean is_active=false;
    private String tenant;
    private boolean i_deleted;
    
    private LocalDate created_date;
	private LocalDate modified_date =java.time.LocalDate.now();
	public boolean isI_deleted() {
		return i_deleted;
	}
	public void setI_deleted(boolean i_deleted) {
		this.i_deleted = i_deleted;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getContact_email() {
		return contact_email;
	}
	public void setContact_email(String contact_email) {
		this.contact_email = contact_email;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public Long getZip() {
		return zip;
	}
	public void setZip(Long zip) {
		this.zip = zip;
	}
	public String getContact_name() {
		return contact_name;
	}
	public void setContact_name(String contact_name) {
		this.contact_name = contact_name;
	}
	public Long getContact_phone() {
		return contact_phone;
	}
	public void setContact_phone(Long contact_phone) {
		this.contact_phone = contact_phone;
	}
	public String[] getViolation_category() {
		return violation_category;
	}
	public void setViolation_category(String[] violation_category) {
		this.violation_category = violation_category;
	}
	public boolean isIs_active() {
		return is_active;
	}
	public void setIs_active(boolean is_active) {
		this.is_active = is_active;
	}
	public String getTenant() {
		return tenant;
	}
	public void setTenant(String tenant) {
		this.tenant = tenant;
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
