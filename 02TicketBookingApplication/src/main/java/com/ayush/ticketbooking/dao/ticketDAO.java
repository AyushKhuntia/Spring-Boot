package com.ayush.ticketbooking.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ayush.ticketbooking.model.Ticket;

@Repository
public interface ticketDAO extends CrudRepository<Ticket, Integer>{

}
