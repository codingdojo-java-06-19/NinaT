package com.ninatompkin.beltreviewer.repositories;

import org.springframework.data.repository.CrudRepository;

import com.ninatompkin.beltreviewer.models.User;

public interface UserRepository extends CrudRepository<User, Long>{
	User findByEmail(String email);

}
