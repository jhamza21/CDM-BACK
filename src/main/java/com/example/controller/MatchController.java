package com.example.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.entities.Match;
import com.example.service.IMatchService;

@RestController
@RequestMapping("/match")
public class MatchController {
	@Autowired
	IMatchService ms;

	@CrossOrigin
	@GetMapping("/all")
	public List<Match> GetAllMatches() {
		return ms.FindMatchs();
	}

	@CrossOrigin
	@GetMapping("/details/{id}")
	public Match DetailsMatch(@PathVariable int id) {
		return ms.FindMatch(id);
	}

	@CrossOrigin
	@DeleteMapping("/deleteall")
	public boolean DeleteAllMatchs() {
		return ms.DeleteAllMatchs();
	}

	@CrossOrigin
	@PutMapping("/update/{id}")
	public boolean UpdateMatch(@PathVariable int id, @Valid @RequestBody Match nv) {
		return ms.UpdateMatch(id, nv);
	}

	@CrossOrigin
	@PutMapping("/updatep/{id}")
	public boolean UpdateMatchP(@PathVariable int id, @Valid @RequestBody Match nv) {
		return ms.UpdateMatchPool(id, nv);
	}
	@CrossOrigin
	@PutMapping("/updatepeno/{id}")
	public boolean UpdatePeno(@PathVariable int id, @Valid @RequestBody Match nv) {
		return ms.UpdatePeno(id, nv);
	}

}
