package com.ayush.ticketbooking.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ayush.ticketbooking.dao.ticketDAO;
import com.ayush.ticketbooking.model.Ticket;


@Service
public class TicketService {
	
	@Autowired
	private ticketDAO ticketDao;
	
//	Retrive all ticket
	public Iterable<Ticket> getAllTicket(){
		return ticketDao.findAll();
	}
	
//	Retrive individual ticket
	public Ticket getTicketById(Integer ticketId){
		return ticketDao.findById(ticketId).orElse(new Ticket());
	}
	
//	create Ticket
	public Ticket createTicket(Ticket ticketObj) {
		return ticketDao.save(ticketObj);
	}
	
//	Update Ticket
	public Ticket updateTicket(Integer ticketId,String email) {
		Ticket ticketobj = getTicketById(ticketId);
		ticketobj.setEmail(email);
		return ticketDao.save(ticketobj);
	}
//	Delete Ticket
	public void deleteTicket(Integer ticketId) {
		ticketDao.deleteById(ticketId);
	}
	
}
