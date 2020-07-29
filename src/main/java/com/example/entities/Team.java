package com.example.entities;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;

@Entity
@Data
@AllArgsConstructor
public class Team implements Comparable<Team> {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	private int nbrplayer;
	private int nbrstaff;
	private int point;
	private int goal_scored;
	private int goal_conceded;
	private int gameplayed;
	@ManyToMany(mappedBy = "teams")
	@JsonIgnore
	private List<Match> matchs;
	@ManyToOne
	@JsonIgnore
	private Pool pool;

	public Team(String s) {
		name = s;
		nbrplayer = 0;
		nbrstaff = 0;
		point = 0;
		gameplayed = 0;
		matchs = new ArrayList<Match>();

	}

	public int compareTo(Team t) {
		if (this.getPoint() == t.getPoint())
			return 0;
		else if (this.getPoint() > t.getPoint())
			return -1;
		else
			return 1;
	}

	public Team() {
		nbrplayer = 0;
		nbrstaff = 0;
		point = 0;
		gameplayed = 0;
		matchs = new ArrayList<Match>();

	}

}
