package com.intersoft.Assignment2.serviceImpl;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.intersoft.Assignment2.dao.TenantDao;
import com.intersoft.Assignment2.entity.Tenant;
import com.intersoft.Assignment2.service.TenantService;

@Service
public class TenantServiceImpl implements TenantService{
	
	@Autowired
	TenantDao tDao;

	@Override
	public Tenant addTenant(Tenant tenant) {
		return tDao.addTenant(tenant);
	}

	@Override
	public ArrayList<Tenant> getAllTenant() {
		return tDao.getAllTenant();
	}

}
