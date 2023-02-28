package com.intersoft.Assignment2.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.intersoft.Assignment2.entity.Tenant;

public interface TenantRepository extends JpaRepository<Tenant,Integer> {

}
