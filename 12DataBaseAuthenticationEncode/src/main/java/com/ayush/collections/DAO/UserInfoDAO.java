package com.ayush.collections.DAO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ayush.collections.entities.UserInfo;
public interface UserInfoDAO extends JpaRepository<UserInfo, String> {
	
	@Query("SELECT u FROM UserInfo u WHERE u.username = ?1")
	public UserInfo getByUsername(String username);
}
