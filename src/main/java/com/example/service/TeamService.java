package com.example.service;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.entities.Team;
import com.example.repository.TeamRepository;

@Service
public class TeamService implements ITeamService {
	@Autowired
	TeamRepository mr;

	@Override
	public boolean SaveTeam(Team m) {
		try {
			List<Team> l = mr.findAll();
			for (Team t : l)
				if (t.getName().equals(m.getName()))
					return false;
			mr.save(m);
			return true;
		}

		catch (Exception e) {
			return false;
		}
	}

	@Override
	public List<Team> FindTeams() {
		try {
			return mr.findAll();
		} catch (Exception e) {
			return null;
		}
	}

	public Team FindTeam(int id) {
		try {
			Team m = mr.findById(id);
			return m;
		} catch (Exception e) {
			return null;
		}
	}

	public boolean UpdateTeam(int id, Team nv) {
		try {

			Team m = mr.findById(id);
			m.setName(nv.getName());
//			m.setMatch(nv.getMatch());
			m.setNbrplayer(nv.getNbrplayer());
			m.setGameplayed(nv.getGameplayed());
			m.setNbrstaff(nv.getNbrstaff());
			m.setPoint(nv.getPoint());
			m.setPool(nv.getPool());
			mr.save(m);
			return true;
		}

		catch (Exception e) {
			return false;
		}
	}

	public boolean DeleteAllTeams() {
		try {
			mr.deleteAll();
			return true;
		}

		catch (Exception e) {
			return false;
		}
	}

	public boolean DeleteTeam(int id) {
		try {
			mr.deleteById(id);
			return true;
		}

		catch (Exception e) {
			return false;
		}
	}
	
	public List<Team> Goal_Scored(){
		try {
			List<Team> m = mr.findAll();
			Collections.sort(m,Comparator.comparingInt(Team::getGoal_scored).reversed());
			return m;
		} catch (Exception e) {
			return null;
		}
	}
	
	public List<Team> Goal_Conceded(){
		try {
			List<Team> m = mr.findAll();
			Collections.sort(m,Comparator.comparingInt(Team::getGoal_conceded));
			return m;
		} catch (Exception e) {
			return null;
		}
	}

}
