package com.example.service;

import java.util.List;

import com.example.entities.Team;

public interface ITeamService {
	boolean SaveTeam(Team m);

	boolean UpdateTeam(int id, Team m);

	List<Team> FindTeams();

	Team FindTeam(int id);

	boolean DeleteTeam(int id);

	boolean DeleteAllTeams();
	
	List<Team> Goal_Scored();
	
	List<Team> Goal_Conceded();

}
