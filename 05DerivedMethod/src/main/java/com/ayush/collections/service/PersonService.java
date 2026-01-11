package com.ayush.collections.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ayush.collections.dao.PersonDao;
import com.ayush.collections.model.Person;


@Service
public class PersonService {
	
	@Autowired
	private PersonDao personDao;
	
	public Iterable<Person> getAllPersons(){
		return personDao.findAll();
	}
	
	public Iterable<Person> saveAllPerson(Iterable<Person> personList){
		return personDao.saveAll(personList);
	}
	
	public Iterable<Person> getMultiplePersons(Iterable<Integer> personIds){
		return personDao.findAllById(personIds);
	}
	
	

}
