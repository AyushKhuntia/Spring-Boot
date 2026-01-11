package com.ayush.collections.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ayush.collections.model.Person;

@Repository
public interface PersonDao extends CrudRepository<Person,Integer>{
	
//	save all
//	findbyId
}
