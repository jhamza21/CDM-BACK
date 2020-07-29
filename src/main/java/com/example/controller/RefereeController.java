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
import com.example.entities.Referee;
import com.example.service.IRefereeService;
import java.util.List;

import javax.validation.Valid;

@RestController
@RequestMapping("/referee")
public class RefereeController {
	@Autowired
	IRefereeService rs;

	@CrossOrigin
	@GetMapping("/all")
	public List<Referee> GetAllreferees() {
		return rs.FindReferees();
	}

	@CrossOrigin
	@PostMapping("/add")
	public boolean save_referee(@Valid @RequestBody Referee m) {
		return rs.SaveReferee(m);
	}

	@CrossOrigin
	@GetMapping("/details/{id}")
	public Referee DetailsReferee(@PathVariable int id) {
		return rs.FindReferee(id);
	}

	@CrossOrigin
	@DeleteMapping("/delete/{id}")
	public boolean DeleteReferee(@PathVariable int id) {
		return rs.DeleteReferee(id);
	}

	@CrossOrigin
	@PutMapping("/update/{id}")
	public boolean UpdateReferee(@PathVariable int id, @Valid @RequestBody Referee nv) {
		return rs.UpdateReferee(id, nv);
	}

	@CrossOrigin
	@DeleteMapping("/deleteall")
	public boolean DeleteAllReferees() {
		return rs.DeleteAllReferees();
	}

}
