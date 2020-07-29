package com.example.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

@Entity
@Data
public class Referee {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	private String nationality;
	private boolean status;
	private int age;
	@ManyToMany(mappedBy = "referees")
	@JsonIgnore
	private List<Match> matchs;

	public Referee() {
		matchs = new ArrayList<Match>();
	}

	public Referee(int id, String name, String nationality, boolean status, int age) {

		this.name = name;
		this.nationality = nationality;
		this.status = status;
		this.age = age;
		this.matchs = new ArrayList<Match>();
	}

}
