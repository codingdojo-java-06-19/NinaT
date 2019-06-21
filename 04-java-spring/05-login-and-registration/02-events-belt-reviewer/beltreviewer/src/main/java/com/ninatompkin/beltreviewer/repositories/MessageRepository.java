package com.ninatompkin.beltreviewer.repositories;

import org.springframework.data.repository.CrudRepository;

import com.ninatompkin.beltreviewer.models.Message;

public interface MessageRepository extends CrudRepository <Message,Long>{

}
