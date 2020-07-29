package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.entities.Match;
@Repository
public interface MatchRepository extends JpaRepository<Match,Integer> {

	
	public Match findById(int id);
} 
