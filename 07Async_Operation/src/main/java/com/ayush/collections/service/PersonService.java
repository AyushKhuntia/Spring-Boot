package com.ayush.collections.service;

import java.util.List;
import java.util.concurrent.CompletableFuture;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ayush.collections.dao.EmployeeDao;
import com.ayush.collections.dao.PersonDao;
import com.ayush.collections.model.Employee;
import com.ayush.collections.model.Person;


@Service
public class PersonService {
	
	@Autowired
	private PersonDao personDao;
	
	@Autowired
	private EmployeeDao employeeDao;
	
	public List<Object[]> getMaxSalaryByDept(List<String> deptNames){
		return employeeDao.getMaxSalaryByDept(deptNames);
	}
	
	public Iterable<Employee> retriveAllEmployees(Iterable<Employee> empList){
		return employeeDao.findAll();
	}
	
	public Iterable<Employee> saveAllEmployees(Iterable<Employee> empList){
		return employeeDao.saveAll(empList);
	}
	
	public Iterable<Person> getAllPersons(){
		return personDao.findAll();
	}
	
	public Iterable<Person> saveAllPerson(Iterable<Person> personList){
		return personDao.saveAll(personList);
	}
	
	public Iterable<Person> getMultiplePersons(Iterable<Integer> personIds){
		return personDao.findAllById(personIds);
	}
	
	public List<Person> givebyLastName(String lastName){
		return personDao.givebyLastName(lastName);
	}
	
	
	public List<Person> findByEmail(String email){
		return personDao.findByEmail(email);
	}
	
	public CompletableFuture<List<Person>> findByemail(String email){
		return personDao.findByemail(email);
	}

}
