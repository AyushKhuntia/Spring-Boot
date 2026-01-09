package com.ayush.ticketbooking.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ayush.ticketbooking.model.Ticket;

@Repository
public interface ticketDAO extends CrudRepository<Ticket, Integer>{
	List<Ticket> findByPassangerName(String passangerName);

//	select * from tbl_ticket where passanger_name = passnagerName
}
