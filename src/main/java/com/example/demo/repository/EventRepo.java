package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.models.Event;

@Repository
public interface EventRepo extends JpaRepository<Event, Integer> {

}
