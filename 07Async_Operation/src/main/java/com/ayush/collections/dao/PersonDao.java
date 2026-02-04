package com.ayush.collections.dao;
import java.util.List;
import java.util.concurrent.CompletableFuture;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Repository;

import com.ayush.collections.model.Person;

@Repository
public interface PersonDao extends CrudRepository<Person,Integer>{

//	public Iterable<Person> findByLastNameAndFirstName(String lastName,String firstName);
//
//	public Iterable<Person> findByLastNameOrFirstName(String lastName,String firstName);
//	//	select * from person where last_name=lastName or first_name=firstName
//	 
//	public List<Person> findByLastNameOrderByCreatedDateDesc(String lastName);
//
//    //	select * from person where last_name=lastName order by created_date desc 
//    public List<Person> findByAgeLessThanEqual(Integer age);
//    
//    public List<Person> findByFirstNameLike(String firstName);
//    // select * from person where first_name like firstName
//    
//    public List<Person> findByLastNameAndAgeLessThanEqual(String lastName,Integer age);
//    
//    public List<Person> findByCreatedDateBetween(String startDate,String endDate);
    
    /*
     * Named Query Example
     */
	 
    public List<Person> givebyLastName(String lastName);
    
	/*
	 * Asynchronous Call Example
	 * CompletableFuture is the last name of the return type
	 */
    
//    Deafult is Synchronous Call
    public List<Person> findByEmail(String email);
    
//    Asynchronous Call
    @Async
    public CompletableFuture<List<Person>> findByemail(String email);
    
	
}
