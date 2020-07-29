package com.example.entities;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;

import lombok.AllArgsConstructor;
import lombok.Data;

@Entity
@Data
@AllArgsConstructor
public class Pool {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String round;
	@OneToMany(mappedBy = "pool")
	@OrderBy("point DESC,goal_scored DESC,goal_conceded")
	private List<Team> teams;

	public Pool(String r) {
		round = r;
		teams = new ArrayList<Team>();

	}

	public Team GetTeam(int i) {
		try {
			return this.teams.get(i);
		} catch (Exception e) {
			return null;
		}
	}

	public Pool() {
		teams = new ArrayList<Team>();
		// TODO Auto-generated constructor stub
	}
}
