package com.example.entities;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import lombok.AllArgsConstructor;
import lombok.Data;

@Entity
@AllArgsConstructor
@Data
public class Match {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String stadium;
	private String hour;
	private String scorea;
	private String scoreb;
	private String penoa;
	private String penob;
	private String date;

	@ManyToMany
	private List<Team> teams;
	@ManyToMany
	private List<Referee> referees;

	public Team GetTeam(int i) {
		try {
			return teams.get(i);

		} catch (Exception e) {
			return null;
		}
	}

	public Match() {
		teams = new ArrayList<Team>();
		referees = new ArrayList<Referee>();
	}
}
