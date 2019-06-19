package com.ninatompkin.authentication.repositories;

import org.springframework.data.repository.CrudRepository;

import com.ninatompkin.authentication.models.User;

public interface UserRepository extends CrudRepository<User, Long>{
	User findByEmail(String email);

}
