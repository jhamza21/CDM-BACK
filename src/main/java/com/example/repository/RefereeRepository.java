package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.entities.Referee;
@Repository
public interface RefereeRepository extends JpaRepository<Referee,Integer> {
	public Referee findById(int id);

} 
