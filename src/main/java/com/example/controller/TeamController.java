package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.entities.Team;
import com.example.service.ITeamService;

import java.util.List;

import javax.validation.Valid;

@RestController
@RequestMapping("/team")
public class TeamController {
	@Autowired
	ITeamService ts;

	@CrossOrigin
	@GetMapping("/all")
	public List<Team> GetAllTeams() {
		return ts.FindTeams();
	}


	@CrossOrigin
	@GetMapping("/Goal_Scored")
	public List<Team> Goal_Scored() {
		return ts.Goal_Scored();
	}

	

	@CrossOrigin
	@GetMapping("/Goal_Conceded")
	public List<Team> Goal_Conceded() {
		return ts.Goal_Conceded();
	}

	
	
	@CrossOrigin
	@PostMapping("/add")
	public boolean SaveTeam(@Valid @RequestBody Team m) {
		return ts.SaveTeam(m);
	}

	@CrossOrigin
	@GetMapping("/details/{id}")
	public Team DetailsTeam(@PathVariable int id) {
		return ts.FindTeam(id);
	}

	@CrossOrigin
	@DeleteMapping("/delete/{id}")
	public boolean DeleteTeam(@PathVariable int id) {
		return ts.DeleteTeam(id);
	}

	@CrossOrigin
	@PutMapping("/update/{id}")
	public boolean UpdateTeam(@PathVariable int id, @Valid @RequestBody Team nv) {
		return ts.UpdateTeam(id, nv);
	}

	@CrossOrigin
	@DeleteMapping("/deleteall")
	public boolean DeleteAllTeams() {
		return ts.DeleteAllTeams();
	}

}
