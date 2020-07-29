package com.example.controller;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.entities.Match;
import com.example.entities.Pool;
import com.example.entities.Team;
import com.example.repository.MatchRepository;
import com.example.repository.PoolRepository;
import com.example.repository.TeamRepository;
import com.example.service.IPoolService;

@RestController
@RequestMapping("/pool")
public class PoolController {
	@Autowired
	IPoolService ps;
	@Autowired
	PoolRepository pr;
	@Autowired
	TeamRepository tr;
	@Autowired
	MatchRepository mr;

	@CrossOrigin
	@GetMapping("/all")
	public List<Pool> GetAllPools() {
		return ps.GetAllPools();

	}

	@CrossOrigin
	@DeleteMapping("/deleteall")
	public boolean DeleteAllPools() {
		return ps.DeleteAllPools();
	}

	@CrossOrigin
	@PutMapping("/genererpool")
	public boolean GenererPool() {
		try {

			// Test
			List<Pool> test = pr.findAll();
			if (test.size() != 0)
				return false;
			// Test
			List<Team> test2 = tr.findAll();
			if (test2.size() != 32)
				return false;

			ps.GeneratePool();
			List<Pool> l = new ArrayList<Pool>();
			l = ps.GetAllPools();
			for (Pool p : l)
				ps.GenerateMatchs(p);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@CrossOrigin
	@PutMapping("/genererpoolp")
	public boolean GenererPoolP() {
		try {
			// Test
			List<Pool> test = pr.findAll();
			if (test.size() != 8)
				return false;
			// Test score
			List<Match> test2 = mr.findAll();
			if (test2.size() != 48)
				return false;
			for (Match m : test2) {
				if (m.getScorea().equals("") || m.getScoreb().equals(""))
					return false;
				
			}

			ps.GeneratePoolP2();

			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@CrossOrigin
	@PutMapping("/genererpoolg")
	public boolean GenererPoolG() {
		try {
			// Test
			List<Pool> test = pr.findAll();
			if (test.size() != 8)
				return false;
			// Test score
			List<Match> test2 = mr.findAll();
			if (test2.size() != 56)
				return false;
			int i=0;
			for (Match m : test2) {
				i++;
				if(i>48) {
				if (m.getScorea().equals("") || m.getScoreb().equals(""))
					return false;
				if (m.getScorea().equals(m.getScoreb())&&(m.getPenoa().equals("")))
					return false;
			}
			}

			ps.GeneratePoolG();

			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@CrossOrigin
	@PutMapping("/genererpools")
	public boolean GenererPoolS() {
		try {
			// Test
			List<Pool> test = pr.findAll();
			if (test.size() != 8)
				return false;
			// Test score
			List<Match> test2 = mr.findAll();
			if (test2.size() != 60)
				return false;
			int i=0;
			for (Match m : test2) {
				i++;
				if(i>48) {
				if (m.getScorea().equals("") || m.getScoreb().equals(""))
					return false;
				if (m.getScorea().equals(m.getScoreb())&&(m.getPenoa().equals("")))
					return false;
			}
			}
			ps.GeneratePoolS();

			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@CrossOrigin
	@PutMapping("/genererpoolf")
	public boolean GenererPoolF() {
		try {
			// Test
			List<Pool> test = pr.findAll();
			if (test.size() != 8)
				return false;
			// Test score
			List<Match> test2 = mr.findAll();
			if (test2.size() != 62)
				return false;
			int i=0;
			for (Match m : test2) {
				i++;
				if(i>48) {
				if (m.getScorea().equals("") || m.getScoreb().equals(""))
					return false;
				if (m.getScorea().equals(m.getScoreb())&&(m.getPenoa().equals("")))
					return false;
			}
			}
			ps.GeneratePoolF();

			return true;
		} catch (Exception e) {
			return false;
		}
	}

}
