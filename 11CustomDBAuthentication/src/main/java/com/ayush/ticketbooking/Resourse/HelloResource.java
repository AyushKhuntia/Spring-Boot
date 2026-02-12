package com.ayush.ticketbooking.Resourse;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/rest/hello")
@RestController
public class HelloResource {

	@GetMapping("/all")
	public String helloAll() {
		return "Hello All Users";
	}
	
	@PreAuthorize("hasRole('ADMIN')")
	@GetMapping("/secure/control")
	public String secureAdmin() {
		return "Hello Secured Users";
	}
	@PreAuthorize("hasRole('USER','ADMIN')")
	@GetMapping("/secure/user")
	public String SecureGuest() {
		return "Its securePage.. Both Admin and Guest can view";
	}
	
}
