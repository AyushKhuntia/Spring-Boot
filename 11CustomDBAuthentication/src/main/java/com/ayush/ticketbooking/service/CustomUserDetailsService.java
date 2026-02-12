package com.ayush.ticketbooking.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.ayush.ticketbooking.Repository.UserRepository;
import com.ayush.ticketbooking.model.CustomUserDetails;
import com.ayush.ticketbooking.model.User;

@Service
public class CustomUserDetailsService implements UserDetailsService {

	@Autowired
	private UserRepository userRepository;
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<User> dbUserData = userRepository.findByEmail(username);
		
		dbUserData.orElseThrow(()-> new UsernameNotFoundException("User Not Found with username: "+username));
		
		return dbUserData.map(CustomUserDetails::new).get();
		
	}
	
	

}
