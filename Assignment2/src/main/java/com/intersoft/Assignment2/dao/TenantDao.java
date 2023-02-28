package com.intersoft.Assignment2.dao;

import java.util.ArrayList;

import org.springframework.stereotype.Component;

import com.intersoft.Assignment2.entity.Tenant;

@Component
public interface TenantDao {
	Tenant addTenant(Tenant tenant);
	ArrayList<Tenant> getAllTenant();

}
