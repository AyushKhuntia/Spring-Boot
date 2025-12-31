package com.ayush.ticketbooking;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.ayush.ticketbooking.model.Ticket;
import com.ayush.ticketbooking.service.TicketService;

@SpringBootApplication
public class Application implements CommandLineRunner{

	@Autowired
	public TicketService ticketService;
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
	@Override
	public void run(String... args) throws Exception {
		Ticket ticketobj = new Ticket();
		ticketobj.setPassangerName("Ayush");
		ticketobj.setSourceStation("Odisha");
		ticketobj.setDestinationStation("Hyd");
		ticketobj.setEmail("ayush@gmail.com");
		ticketobj.setTravelDate(new Date());;
		
		ticketService.createTicket(ticketobj);
		
		
	}

}
