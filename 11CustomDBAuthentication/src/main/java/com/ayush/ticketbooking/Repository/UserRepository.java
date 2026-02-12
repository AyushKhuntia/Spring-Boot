package com.ayush.ticketbooking.Repository;
import com.ayush.ticketbooking.model.User;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
public interface UserRepository extends JpaRepository<User, Integer> {

//	Derived Query to find User by email
	Optional<User> findByEmail(String email);
	
}
