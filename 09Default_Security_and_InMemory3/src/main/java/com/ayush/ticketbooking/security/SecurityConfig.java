package com.ayush.ticketbooking.security;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//import org.springframework.boot.security.autoconfigure.SecurityProperties.User;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.config.Customizer;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
	
//	Authnetication
	@Bean
	public UserDetailsService userDetailsService() {
		UserDetails user1 = User.withDefaultPasswordEncoder()
			.username("ayush")
			.password("ayush")
			.roles("ADMIN")
			.build();
		UserDetails user2 = User.withDefaultPasswordEncoder()
				.username("ayush1")
				.password("ayush1")
				.roles("USER")
				.build();
		
		return new InMemoryUserDetailsManager(user1, user2);
		
	}
	
	
//	Authorization
	
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

	    http.authorizeHttpRequests(request -> request
	            .requestMatchers("/ticket/all").hasRole("ADMIN")
	            .requestMatchers("/ticket/{ticketId}").hasAnyRole("ADMIN", "USER")
	            .anyRequest().authenticated()
	    )
	    .httpBasic(Customizer.withDefaults());


	    return http.build();
	}

	
}
