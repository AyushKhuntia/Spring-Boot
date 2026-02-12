package com.ayush.collections.sevice.impl;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.*;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.ayush.collections.DAO.UserInfoDAO;
import com.ayush.collections.entities.UserInfo;

@Service
public class UserServiceImpl implements UserDetailsService {
	
	@Autowired
	private UserInfoDAO userInfoDAO;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		UserInfo userInfo = userInfoDAO.getByUsername(username);
		
//		for multiple roles set<role> roles
//	    List<GrantedAuthority> authorities =
//	            userInfo.getRoles().stream()
//	                .map(role -> new SimpleGrantedAuthority(role.getRoleName()))
//	                .collect(Collectors.toList());
	    
		GrantedAuthority grantAuthority = new SimpleGrantedAuthority(userInfo.getRole());
		User user = new User(userInfo.getUsername(), userInfo.getPassword(), Arrays.asList(grantAuthority));
		
		return (UserDetails) user;
	}

}
