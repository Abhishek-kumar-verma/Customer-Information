package com.intersoft.Assignment2.service;

import java.util.ArrayList;

import org.springframework.stereotype.Component;

import com.intersoft.Assignment2.entity.Tenant;
@Component
public interface TenantService {
	Tenant addTenant(Tenant tenant);
	ArrayList<Tenant> getAllTenant();

}
