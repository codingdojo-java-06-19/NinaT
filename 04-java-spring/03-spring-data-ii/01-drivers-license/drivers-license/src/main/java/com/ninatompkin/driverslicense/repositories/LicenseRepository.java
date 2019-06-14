package com.ninatompkin.driverslicense.repositories;

import org.springframework.stereotype.Repository;

import com.ninatompkin.driverslicense.models.License;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

@Repository
public interface LicenseRepository extends CrudRepository<License, Long> {
	List<License> findAll();

}


