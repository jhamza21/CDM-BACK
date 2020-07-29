package com.example.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.entities.Match;
import com.example.entities.Pool;
import com.example.entities.Referee;
import com.example.entities.Team;
import com.example.repository.MatchRepository;
import com.example.repository.PoolRepository;
import com.example.repository.RefereeRepository;
import com.example.repository.TeamRepository;

@Service
public class PoolService implements IPoolService {
	@Autowired
	PoolRepository pr;
	@Autowired
	TeamRepository tr;
	@Autowired
	MatchRepository mr;
	@Autowired
	RefereeRepository rr;
	@Autowired
	MatchService ms;

	List<String> Stadiums = new ArrayList<String>();

	public boolean GeneratePool() {
		try {
			Pool A = new Pool("P");
			Pool B = new Pool("P");
			Pool C = new Pool("P");
			Pool D = new Pool("P");
			Pool E = new Pool("P");
			Pool F = new Pool("P");
			Pool G = new Pool("P");
			Pool H = new Pool("P");
			int a = 0, b = 0, c = 0, d = 0, e = 0, f = 0, g = 0, h = 0;

			// Get all teams in list l
			List<Team> l = new ArrayList<Team>();
			l = tr.findAll();
			// List of numbers
			List<Integer> nb = new ArrayList<Integer>();
			Random r = new Random();

			// Pool A
			while (a < 4) {
				int i = r.nextInt(32);
				if (!nb.contains(i)) {
					nb.add(i);
					A.getTeams().add(l.get(i));
					a++;
					pr.save(A);
					l.get(i).setPool(A);
					tr.save(l.get(i));
				}
			}
			// Pool B

			while (b < 4) {
				int i = r.nextInt(32);
				if (!nb.contains(i)) {
					nb.add(i);
					B.getTeams().add(l.get(i));
					b++;
					pr.save(B);
					l.get(i).setPool(B);
					tr.save(l.get(i));
				}
			}
			// Pool C

			while (c < 4) {
				int i = r.nextInt(32);
				if (!nb.contains(i)) {
					nb.add(i);
					C.getTeams().add(l.get(i));
					c++;
					pr.save(C);
					l.get(i).setPool(C);
					tr.save(l.get(i));
				}
			}
			// Pool D
			while (d < 4) {
				int i = r.nextInt(32);
				if (!nb.contains(i)) {
					nb.add(i);
					D.getTeams().add(l.get(i));
					d++;
					pr.save(D);
					l.get(i).setPool(D);
					tr.save(l.get(i));
				}
			}
			// Pool E

			while (e < 4) {
				int i = r.nextInt(32);
				if (!nb.contains(i)) {
					nb.add(i);
					E.getTeams().add(l.get(i));
					e++;
					pr.save(E);
					l.get(i).setPool(E);
					tr.save(l.get(i));
				}
			}
			// Pool F
			while (f < 4) {
				int i = r.nextInt(32);
				if (!nb.contains(i)) {
					nb.add(i);
					F.getTeams().add(l.get(i));
					f++;
					pr.save(F);
					l.get(i).setPool(F);
					tr.save(l.get(i));
				}
			}
			// Pool G
			while (g < 4) {
				int i = r.nextInt(32);
				if (!nb.contains(i)) {
					nb.add(i);
					G.getTeams().add(l.get(i));
					g++;
					pr.save(G);
					l.get(i).setPool(G);
					tr.save(l.get(i));
				}
			}
			// Pool H
			while (h < 4) {
				int i = r.nextInt(32);
				if (!nb.contains(i)) {
					nb.add(i);
					H.getTeams().add(l.get(i));
					h++;
					pr.save(H);
					l.get(i).setPool(H);
					tr.save(l.get(i));
				}
			}
			return true;
		} catch (Exception e) {
			return false;
		}

	}

	public boolean GeneratePoolP2() {
		try {
			CreateStadium();
			List<Pool> p = new ArrayList<Pool>();
			p = pr.findAll();
			Random x = new Random();
			List<Integer> nb = new ArrayList<Integer>();
			int i = x.nextInt(9);

			// Pool A && Pool B
			Match m1 = new Match();
			m1.getTeams().add(p.get(0).GetTeam(0));
			m1.getTeams().add(p.get(1).GetTeam(1));
			while (nb.contains(i)) {
				i = x.nextInt(9);
			}

			nb.add(i);
			m1.setStadium(Stadiums.get(i));
			m1.setDate("22/06/2022");
			m1.setHour("19:00");
			m1.setReferees(RandomReferee());
			mr.save(m1);
			for (Referee r : m1.getReferees()) {
				r.getMatchs().add(m1);
				rr.save(r);
			}
			Match m2 = new Match();
			m2.getTeams().add(p.get(0).GetTeam(1));
			m2.getTeams().add(p.get(1).GetTeam(0));
			while (nb.contains(i)) {
				i = x.nextInt(9);
			}

			nb.add(i);
			m2.setStadium(Stadiums.get(i));
			m2.setDate("22/06/2022");
			m2.setHour("19:00");
			m2.setReferees(RandomReferee());
			mr.save(m2);
			for (Referee r : m2.getReferees()) {
				r.getMatchs().add(m2);
				rr.save(r);
			}
			// Update teams
			p.get(0).GetTeam(0).getMatchs().add(m1);
			tr.save(p.get(0).GetTeam(0));
			p.get(1).GetTeam(1).getMatchs().add(m1);
			tr.save(p.get(1).GetTeam(1));

			p.get(0).GetTeam(1).getMatchs().add(m2);
			tr.save(p.get(0).GetTeam(1));
			p.get(1).GetTeam(0).getMatchs().add(m2);
			tr.save(p.get(1).GetTeam(0));

			// Pool C && Pool D

			m1 = new Match();
			m1.getTeams().add(p.get(2).GetTeam(0));
			m1.getTeams().add(p.get(3).GetTeam(1));
			while (nb.contains(i)) {
				i = x.nextInt(9);
			}

			nb.add(i);
			m1.setStadium(Stadiums.get(i));
			m1.setDate("23/06/2022");
			m1.setHour("19:00");
			m1.setReferees(RandomReferee());
			mr.save(m1);
			for (Referee r : m1.getReferees()) {
				r.getMatchs().add(m1);
				rr.save(r);
			}
			m2 = new Match();
			m2.getTeams().add(p.get(2).GetTeam(1));
			m2.getTeams().add(p.get(3).GetTeam(0));
			while (nb.contains(i)) {
				i = x.nextInt(9);
			}

			nb.add(i);
			m2.setStadium(Stadiums.get(i));
			m2.setDate("23/06/2022");
			m2.setHour("19:00");
			m2.setReferees(RandomReferee());
			mr.save(m2);
			for (Referee r : m2.getReferees()) {
				r.getMatchs().add(m2);
				rr.save(r);
			}
			// Update teams
			p.get(2).GetTeam(0).getMatchs().add(m1);
			tr.save(p.get(2).GetTeam(0));
			p.get(3).GetTeam(1).getMatchs().add(m1);
			tr.save(p.get(3).GetTeam(1));

			p.get(2).GetTeam(1).getMatchs().add(m2);
			tr.save(p.get(2).GetTeam(1));
			p.get(3).GetTeam(0).getMatchs().add(m2);
			tr.save(p.get(3).GetTeam(0));

			// Pool E && Pool F

			m1 = new Match();
			m1.getTeams().add(p.get(4).GetTeam(0));
			m1.getTeams().add(p.get(5).GetTeam(1));
			while (nb.contains(i)) {
				i = x.nextInt(9);
			}

			nb.add(i);
			m1.setStadium(Stadiums.get(i));
			m1.setDate("24/06/2022");
			m1.setHour("19:00");
			m1.setReferees(RandomReferee());
			mr.save(m1);
			for (Referee r : m1.getReferees()) {
				r.getMatchs().add(m1);
				rr.save(r);
			}
			m2 = new Match();
			m2.getTeams().add(p.get(4).GetTeam(1));
			m2.getTeams().add(p.get(5).GetTeam(0));
			while (nb.contains(i)) {
				i = x.nextInt(9);
			}

			nb.add(i);
			m2.setStadium(Stadiums.get(i));
			m2.setDate("24/06/2022");
			m2.setHour("19:00");
			m2.setReferees(RandomReferee());
			mr.save(m2);
			for (Referee r : m2.getReferees()) {
				r.getMatchs().add(m2);
				rr.save(r);
			}
			// Update teams
			p.get(4).GetTeam(0).getMatchs().add(m1);
			tr.save(p.get(4).GetTeam(0));
			p.get(5).GetTeam(1).getMatchs().add(m1);
			tr.save(p.get(5).GetTeam(1));

			p.get(4).GetTeam(1).getMatchs().add(m2);
			tr.save(p.get(4).GetTeam(1));
			p.get(5).GetTeam(0).getMatchs().add(m2);
			tr.save(p.get(5).GetTeam(0));

			// Pool G && Pool H

			m1 = new Match();
			m1.getTeams().add(p.get(6).GetTeam(0));
			m1.getTeams().add(p.get(7).GetTeam(1));
			while (nb.contains(i)) {
				i = x.nextInt(9);
			}

			nb.add(i);
			m1.setStadium(Stadiums.get(i));
			m1.setDate("25/06/2022");
			m1.setHour("19:00");
			m1.setReferees(RandomReferee());
			mr.save(m1);
			for (Referee r : m1.getReferees()) {
				r.getMatchs().add(m1);
				rr.save(r);
			}
			m2 = new Match();
			m2.getTeams().add(p.get(6).GetTeam(1));
			m2.getTeams().add(p.get(7).GetTeam(0));
			while (nb.contains(i)) {
				i = x.nextInt(9);
			}

			nb.add(i);
			m2.setStadium(Stadiums.get(i));
			m2.setDate("25/06/2022");
			m2.setHour("19:00");
			m2.setReferees(RandomReferee());
			mr.save(m2);
			for (Referee r : m2.getReferees()) {
				r.getMatchs().add(m2);
				rr.save(r);
			}
			// Update teams
			p.get(6).GetTeam(0).getMatchs().add(m1);
			tr.save(p.get(6).GetTeam(0));
			p.get(7).GetTeam(1).getMatchs().add(m1);
			tr.save(p.get(7).GetTeam(1));

			p.get(6).GetTeam(1).getMatchs().add(m2);
			tr.save(p.get(6).GetTeam(1));
			p.get(7).GetTeam(0).getMatchs().add(m2);
			tr.save(p.get(7).GetTeam(0));
			return true;
		} catch (Exception e) {
			return false;
		}

	}

	public boolean GeneratePoolG() {
		try {
			CreateStadium();
			Random x = new Random();
			List<Integer> nb = new ArrayList<Integer>();
			int i = x.nextInt(9);
			List<Match> p = new ArrayList<Match>();
			p = mr.findAll();
			// Match 1
			Match m1 = new Match();

			m1.getTeams().add(ms.WinnerMatch(p.get(48)));
			m1.getTeams().add(ms.WinnerMatch(p.get(49)));
			while (nb.contains(i)) {
				i = x.nextInt(9);
			}

			nb.add(i);
			m1.setStadium(Stadiums.get(i));
			m1.setDate("27/06/2022");
			m1.setHour("19:00");
			mr.save(m1);

			m1.setReferees(RandomReferee());
			for (Referee r : m1.getReferees()) {
				r.getMatchs().add(m1);
				rr.save(r);
			}
			// Update teams
			ms.WinnerMatch(p.get(48)).getMatchs().add(m1);
			tr.save(ms.WinnerMatch(p.get(48)));
			ms.WinnerMatch(p.get(49)).getMatchs().add(m1);
			tr.save(ms.WinnerMatch(p.get(49)));

			// Match 2
			m1 = new Match();
			m1.getTeams().add(ms.WinnerMatch(p.get(50)));
			m1.getTeams().add(ms.WinnerMatch(p.get(51)));
			while (nb.contains(i)) {
				i = x.nextInt(9);
			}

			nb.add(i);
			m1.setStadium(Stadiums.get(i));
			m1.setDate("27/06/2022");
			m1.setHour("22:00");
			m1.setReferees(RandomReferee());
			mr.save(m1);
			for (Referee r : m1.getReferees()) {
				r.getMatchs().add(m1);
				rr.save(r);
			}
			// Update teams
			ms.WinnerMatch(p.get(50)).getMatchs().add(m1);
			tr.save(ms.WinnerMatch(p.get(50)));
			ms.WinnerMatch(p.get(51)).getMatchs().add(m1);
			tr.save(ms.WinnerMatch(p.get(51)));

			// Match 3
			m1 = new Match();
			m1.getTeams().add(ms.WinnerMatch(p.get(52)));
			m1.getTeams().add(ms.WinnerMatch(p.get(53)));
			while (nb.contains(i)) {
				i = x.nextInt(9);
			}

			nb.add(i);
			m1.setStadium(Stadiums.get(i));
			m1.setDate("28/06/2022");
			m1.setHour("19:00");
			m1.setReferees(RandomReferee());
			mr.save(m1);
			for (Referee r : m1.getReferees()) {
				r.getMatchs().add(m1);
				rr.save(r);
			}
			// Update teams
			ms.WinnerMatch(p.get(52)).getMatchs().add(m1);
			tr.save(ms.WinnerMatch(p.get(52)));
			ms.WinnerMatch(p.get(53)).getMatchs().add(m1);
			tr.save(ms.WinnerMatch(p.get(53)));

			// Match 4
			m1 = new Match();
			m1.getTeams().add(ms.WinnerMatch(p.get(54)));
			m1.getTeams().add(ms.WinnerMatch(p.get(55)));
			while (nb.contains(i)) {
				i = x.nextInt(9);
			}

			nb.add(i);
			m1.setStadium(Stadiums.get(i));
			m1.setDate("28/06/2022");
			m1.setHour("22:00");
			m1.setReferees(RandomReferee());
			mr.save(m1);
			for (Referee r : m1.getReferees()) {
				r.getMatchs().add(m1);
				rr.save(r);
			}
			// Update teams
			ms.WinnerMatch(p.get(54)).getMatchs().add(m1);
			tr.save(ms.WinnerMatch(p.get(54)));
			ms.WinnerMatch(p.get(55)).getMatchs().add(m1);
			tr.save(ms.WinnerMatch(p.get(55)));
			return true;
		} catch (Exception e) {
			return false;
		}

	}

	public boolean GeneratePoolS() {
		try {

			CreateStadium();
			Random x = new Random();
			List<Integer> nb = new ArrayList<Integer>();
			int i = x.nextInt(9);
			List<Match> p = new ArrayList<Match>();
			p = mr.findAll();
			// Match 1
			Match m1 = new Match();

			m1.getTeams().add(ms.WinnerMatch(p.get(56)));
			m1.getTeams().add(ms.WinnerMatch(p.get(57)));
			while (nb.contains(i)) {
				i = x.nextInt(9);
			}

			nb.add(i);
			m1.setStadium(Stadiums.get(i));
			m1.setDate("01/07/2022");
			m1.setHour("19:00");
			mr.save(m1);

			m1.setReferees(RandomReferee());
			for (Referee r : m1.getReferees()) {
				r.getMatchs().add(m1);
				rr.save(r);
			}
			// Update teams
			ms.WinnerMatch(p.get(56)).getMatchs().add(m1);
			tr.save(ms.WinnerMatch(p.get(56)));
			ms.WinnerMatch(p.get(57)).getMatchs().add(m1);
			tr.save(ms.WinnerMatch(p.get(57)));

			// Match 2
			m1 = new Match();
			m1.getTeams().add(ms.WinnerMatch(p.get(58)));
			m1.getTeams().add(ms.WinnerMatch(p.get(59)));
			while (nb.contains(i)) {
				i = x.nextInt(9);
			}

			nb.add(i);
			m1.setStadium(Stadiums.get(i));
			m1.setDate("01/07/2022");
			m1.setHour("22:00");
			m1.setReferees(RandomReferee());
			mr.save(m1);
			for (Referee r : m1.getReferees()) {
				r.getMatchs().add(m1);
				rr.save(r);
			}
			// Update teams
			ms.WinnerMatch(p.get(58)).getMatchs().add(m1);
			tr.save(ms.WinnerMatch(p.get(58)));
			ms.WinnerMatch(p.get(59)).getMatchs().add(m1);
			tr.save(ms.WinnerMatch(p.get(59)));

			return true;
		} catch (Exception e) {
			return false;
		}

	}

	public boolean GeneratePoolF() {
		try {

			CreateStadium();
			Random x = new Random();
			List<Integer> nb = new ArrayList<Integer>();
			int i = x.nextInt(9);
			List<Match> p = new ArrayList<Match>();
			p = mr.findAll();
			// Match 1
			Match m1 = new Match();

			m1.getTeams().add(ms.WinnerMatch(p.get(60)));
			m1.getTeams().add(ms.WinnerMatch(p.get(61)));
			while (nb.contains(i)) {
				i = x.nextInt(9);
			}

			nb.add(i);
			m1.setStadium(Stadiums.get(i));
			m1.setDate("03/07/2022");
			m1.setHour("19:00");
			mr.save(m1);

			m1.setReferees(RandomReferee());
			for (Referee r : m1.getReferees()) {
				r.getMatchs().add(m1);
				rr.save(r);
			}
			// Update teams
			ms.WinnerMatch(p.get(60)).getMatchs().add(m1);
			tr.save(ms.WinnerMatch(p.get(60)));
			ms.WinnerMatch(p.get(61)).getMatchs().add(m1);
			tr.save(ms.WinnerMatch(p.get(61)));

			return true;
		} catch (Exception e) {
			return false;
		}

	}

	public boolean GenerateMatchs(Pool p) {
		try {
			String date = "22/06/2020";
			String hour = "19:00";
			// Initializing stadium list
			CreateStadium();
			// Get list of teams

			// List of numbers
			Random x = new Random();
			List<Integer> nb = new ArrayList<Integer>();
			// List of pool teams
			List<Team> ltp = p.getTeams();
			int i = x.nextInt(9);
			// Match 1
			Match m1 = new Match();
			m1.getTeams().add(ltp.get(0));
			m1.getTeams().add(ltp.get(1));
			while (nb.contains(i)) {
				i = x.nextInt(9);
			}

			nb.add(i);
			m1.setStadium(Stadiums.get(i));
			m1.setDate(date);
			m1.setHour(hour);
			m1.setReferees(RandomReferee());
			mr.save(m1);
			for (Referee r : m1.getReferees()) {
				r.getMatchs().add(m1);
				rr.save(r);
			}
			// Update teams in pool
			p.GetTeam(0).getMatchs().add(m1);
			tr.save(p.GetTeam(0));
			p.GetTeam(1).getMatchs().add(m1);
			tr.save(p.GetTeam(1));

			// Match 2
			date = "23/06/2020";
			Match m2 = new Match();
			m2.getTeams().add(ltp.get(0));
			m2.getTeams().add(ltp.get(2));
			while (nb.contains(i)) {
				i = x.nextInt(9);
			}
			nb.add(i);
			m2.setStadium(Stadiums.get(i));
			m2.setDate(date);
			m2.setReferees(RandomReferee());
			m2.setHour(hour);
			mr.save(m2);
			for (Referee r : m2.getReferees()) {
				r.getMatchs().add(m2);
				rr.save(r);
			}

			// Update teams
			p.GetTeam(0).getMatchs().add(m2);
			tr.save(p.GetTeam(0));
			p.GetTeam(2).getMatchs().add(m2);
			tr.save(p.GetTeam(2));

			// Match 3
			date = "24/06/2020";
			Match m3 = new Match();
			m3.getTeams().add(ltp.get(0));
			m3.getTeams().add(ltp.get(3));
			while (nb.contains(i)) {
				i = x.nextInt(9);
			}
			nb.add(i);
			m3.setStadium(Stadiums.get(i));
			m3.setDate(date);
			m3.setReferees(RandomReferee());
			m3.setHour(hour);
			mr.save(m3);
			for (Referee r : m3.getReferees()) {
				r.getMatchs().add(m3);
				rr.save(r);
			}

			// Update teams
			p.GetTeam(0).getMatchs().add(m3);
			tr.save(p.GetTeam(0));
			p.GetTeam(3).getMatchs().add(m3);
			tr.save(p.GetTeam(3));
			// Match 4
			date = "25/06/2020";
			Match m4 = new Match();
			m4.getTeams().add(ltp.get(1));
			m4.getTeams().add(ltp.get(2));
			while (nb.contains(i)) {
				i = x.nextInt(9);
			}
			nb.add(i);
			m4.setStadium(Stadiums.get(i));
			m4.setDate(date);
			m4.setReferees(RandomReferee());
			m4.setHour(hour);
			mr.save(m4);
			for (Referee r : m4.getReferees()) {
				r.getMatchs().add(m4);
				rr.save(r);
			}

			// Update teams
			p.GetTeam(1).getMatchs().add(m4);
			tr.save(p.GetTeam(1));
			p.GetTeam(2).getMatchs().add(m4);
			tr.save(p.GetTeam(2));
			// Match 5
			date = "26/06/2020";
			Match m5 = new Match();
			m5.getTeams().add(ltp.get(1));
			m5.getTeams().add(ltp.get(3));
			while (nb.contains(i)) {
				i = x.nextInt(9);
			}
			nb.add(i);
			m5.setStadium(Stadiums.get(i));
			m5.setDate(date);
			m5.setReferees(RandomReferee());
			m5.setHour(hour);
			mr.save(m5);
			for (Referee r : m5.getReferees()) {
				r.getMatchs().add(m5);
				rr.save(r);
			}

			// Update teams
			p.GetTeam(1).getMatchs().add(m5);
			tr.save(p.GetTeam(1));
			p.GetTeam(3).getMatchs().add(m5);
			tr.save(p.GetTeam(3));
			// Match 6
			date = "27/06/2020";
			Match m6 = new Match();
			m6.getTeams().add(ltp.get(2));
			m6.getTeams().add(ltp.get(3));
			while (nb.contains(i)) {
				i = x.nextInt(9);
			}
			nb.add(i);
			m6.setStadium(Stadiums.get(i));
			m6.setDate(date);
			m6.setHour(hour);
			m6.setReferees(RandomReferee());
			mr.save(m6);
			for (Referee r : m6.getReferees()) {
				r.getMatchs().add(m6);
				rr.save(r);
			}

			// Update teams
			p.GetTeam(2).getMatchs().add(m6);
			tr.save(p.GetTeam(2));
			p.GetTeam(3).getMatchs().add(m6);
			tr.save(p.GetTeam(3));

			return true;
		} catch (Exception e) {
			return false;
		}

	}

	public List<Referee> RandomReferee() {

		int i = 0;
		Random x = new Random();
		List<Referee> lr = new ArrayList<Referee>();
		List<Referee> l = new ArrayList<Referee>();
		lr = rr.findAll();
		List<Integer> nb = new ArrayList<Integer>();

		while (i < 4) {
			int r = x.nextInt(lr.size());

			if (!nb.contains(r)) {
				nb.add(r);
				l.add(lr.get(r));
				i++;
			}

		}

		return l;
	}

	public boolean DeleteAllPools() {
		try {
			pr.deleteAll();
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public List<Pool> GetAllPools() {
		try {

			return pr.findAll();

		} catch (Exception e) {
			return null;
		}

	}

	public void CreateStadium() {
		Stadiums.add("Al Bayt Stadium");
		Stadiums.add("Lusail Iconic Stadium");
		Stadiums.add("Khalifa International Stadium");
		Stadiums.add("Sports City Stadium");
		Stadiums.add("Education City Stadium");
		Stadiums.add("Ash Shamal Stadium");
		Stadiums.add("Qatar University Stadium");
		Stadiums.add("Al-Gharafa Stadium");
		Stadiums.add("Doha Port Stadium");
		Stadiums.add("Al-Janoub Stadium");

	}
}
