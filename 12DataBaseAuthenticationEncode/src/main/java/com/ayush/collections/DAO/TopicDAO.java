package com.ayush.collections.DAO;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ayush.collections.entities.Topic;

public interface TopicDAO extends JpaRepository<Topic, Integer> {

}
