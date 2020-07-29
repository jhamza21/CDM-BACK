package com.example.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.entities.Pool;
@Repository
public interface PoolRepository extends JpaRepository <Pool,Integer> {
	public Pool findById(int id);
	public List<Pool> findByRound(String r);
	public List<Pool> findByRoundStartingWith(String s);

}
