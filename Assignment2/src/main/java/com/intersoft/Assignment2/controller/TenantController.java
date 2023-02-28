package com.intersoft.Assignment2.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.intersoft.Assignment2.entity.Tenant;
import com.intersoft.Assignment2.service.TenantService;

@RestController
@CrossOrigin("http://localhost:3000")
public class TenantController {

	@Autowired
	TenantService tService;

	@PostMapping("/addTenant")
	public Tenant addTenant(@RequestBody Tenant tenant) {
		return tService.addTenant(tenant);
	}
	
	@GetMapping("/getAllTenant")
	public ArrayList<Tenant> getAllTenant(){
		return tService.getAllTenant();
	}
	
}
