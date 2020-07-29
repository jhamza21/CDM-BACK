package com.example.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.entities.Match;
import com.example.entities.Team;
import com.example.repository.MatchRepository;
import com.example.repository.RefereeRepository;
import com.example.repository.TeamRepository;

@Service
public class MatchService implements IMatchService {
	@Autowired
	MatchRepository mr;
	@Autowired
	RefereeRepository rr;
	@Autowired
	TeamRepository tr;

	@Override
	public List<Match> FindMatchs() {
		try {
			return mr.findAll();
		} catch (Exception e) {
			return null;
		}
	}

	public Match FindMatch(int id) {
		try {
			Match m = mr.findById(id);
			return m;
		} catch (Exception e) {
			return null;
		}
	}
	public boolean UpdatePeno(int id, Match nv) {
		try {
		
			// Update Penalties
			Match m = mr.findById(id);
			m.setPenoa(nv.getPenoa());
			m.setPenob(nv.getPenob());
			m.setScorea(nv.getScorea());
			m.setScoreb(nv.getScoreb());
			
			mr.save(m);
			return true;
			}catch(Exception e) 
		{return false;}
	}
	public boolean UpdateMatch(int id, Match nv) {
		try {
		
			// Update score
			Match m = mr.findById(id);
			m.setScorea(nv.getScorea());
			m.setScoreb(nv.getScoreb());
			mr.save(m);
			
			Team t1,t2;
			t1 = tr.findById(m.GetTeam(0).getId());
			t2 = tr.findById(m.GetTeam(1).getId());
			
			int gsa=t1.getGoal_scored();
			int gca=t1.getGoal_conceded();
			int ngsa=Integer.parseInt(nv.getScorea());
			int gsb=t2.getGoal_scored();
			int gcb=t2.getGoal_conceded();
			int ngsb=Integer.parseInt(nv.getScoreb());
			
			t1.setGoal_scored(gsa+ngsa);
			t2.setGoal_scored(gsb+ngsb);
			t1.setGoal_conceded(gca+ngsb);
			t2.setGoal_conceded(gcb+ngsa);
			
			tr.save(t1);
			tr.save(t2);
			
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public boolean UpdateMatchPool(int id, Match nv) {
		try {

			// Update score
			Match m = mr.findById(id);
			m.setScorea(nv.getScorea());
			m.setScoreb(nv.getScoreb());
			// Update point
			if (!m.getScorea().equals("")) {
				// Team A winner
				if (Integer.parseInt(m.getScorea()) > Integer.parseInt(m.getScoreb())) {
					Team t = m.GetTeam(0);
					t.setPoint(t.getPoint() + 3);
					tr.save(t);
				}
				// Team B winner
				else if (Integer.parseInt(m.getScoreb()) > Integer.parseInt(m.getScorea())) {
					Team t = m.GetTeam(1);
					t.setPoint(t.getPoint() + 3);
					tr.save(t);
				}
				// Match nul
				else {
					Team t = m.GetTeam(0);
					t.setPoint(t.getPoint() + 1);
					Team tt = m.GetTeam(1);
					tt.setPoint(tt.getPoint() + 1);
					tr.save(t);
					tr.save(tt);
				}
			}

			mr.save(m);
			Team t1,t2;
			t1 = tr.findById(m.GetTeam(0).getId());
			t2 = tr.findById(m.GetTeam(1).getId());
			
			int gsa=t1.getGoal_scored();
			int gca=t1.getGoal_conceded();
			int ngsa=Integer.parseInt(nv.getScorea());
			int gsb=t2.getGoal_scored();
			int gcb=t2.getGoal_conceded();
			int ngsb=Integer.parseInt(nv.getScoreb());
			
			t1.setGoal_scored(gsa+ngsa);
			t2.setGoal_scored(gsb+ngsb);
			t1.setGoal_conceded(gca+ngsb);
			t2.setGoal_conceded(gcb+ngsa);
			
			tr.save(t1);
			tr.save(t2);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public boolean DeleteAllMatchs() {
		try {
			mr.deleteAll();
			return true;
		}

		catch (Exception e) {
			return false;
		}
	}

	public Team WinnerMatch(Match m) {
		try {
			if (Integer.parseInt(m.getScorea()) > Integer.parseInt(m.getScoreb()))
				return m.GetTeam(0);
			else if (Integer.parseInt(m.getScorea()) < Integer.parseInt(m.getScoreb()))
				return m.GetTeam(1);
			else  {
				if (Integer.parseInt(m.getPenoa()) > Integer.parseInt(m.getPenob()))
					return m.GetTeam(0);
				else return m.GetTeam(1);
				}
			
		}
		catch (Exception e) {
			return null;
		}
	}

}
