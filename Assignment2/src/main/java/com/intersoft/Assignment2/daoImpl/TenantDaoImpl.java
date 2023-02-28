package com.intersoft.Assignment2.daoImpl;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.intersoft.Assignment2.dao.TenantDao;
import com.intersoft.Assignment2.entity.Tenant;
import com.intersoft.Assignment2.repository.TenantRepository;

@Repository
public class TenantDaoImpl implements TenantDao {
	
    @Autowired
    TenantRepository tRepo;
    
	@Override
	public Tenant addTenant(Tenant tenant) {
		return tRepo.save(tenant);
	}

	@Override
	public ArrayList<Tenant> getAllTenant() {
		ArrayList<Tenant> ans = new ArrayList<>();
		ans = (ArrayList<Tenant>) tRepo.findAll();
		return ans;
	}

}
