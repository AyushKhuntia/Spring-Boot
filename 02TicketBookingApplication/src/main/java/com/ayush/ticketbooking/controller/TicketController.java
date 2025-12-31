package com.ayush.ticketbooking.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ayush.ticketbooking.model.Ticket;
import com.ayush.ticketbooking.service.TicketService;

@RestController
@RequestMapping(value="/ticket")
public class TicketController {

	@Autowired
	private TicketService ticketService;
	
//	Get All Ticket
	@GetMapping("/all")
	public Iterable<Ticket> getAllTicket(){
		return ticketService.getAllTicket();
	}
	
//	get individual ticket
	@GetMapping(value="/{ticketId}")
	public Ticket getTicketById(@PathVariable("ticketId") Integer ticketId) {
		return ticketService.getTicketById(ticketId);
	}
	
//	Create a Ticket.
	@PostMapping(value="/create")
	public Ticket createTicket(@RequestBody Ticket ticketobj) {
		return ticketService.createTicket(ticketobj);
	}
	
	@PutMapping(value="/{ticketId}/{newEmail}")
	public Ticket updateTicket(@PathVariable("ticketId") Integer ticketId,@PathVariable("newEmail") String newEmail) {
		return ticketService.updateTicket(ticketId, newEmail);
	}
	
	@DeleteMapping(value="/{ticketId")
	public void DeleteTicket(@PathVariable("ticketId") Integer ticketId) {
		ticketService.deleteTicket(ticketId);
	}
	
	
}
