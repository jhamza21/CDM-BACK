package com.example.service;

import java.util.List;
import com.example.entities.Match;
import com.example.entities.Team;

public interface IMatchService {
	Team WinnerMatch(Match m);

	boolean DeleteAllMatchs();

	boolean UpdateMatch(int id, Match m);

	boolean UpdateMatchPool(int id, Match m);
	boolean UpdatePeno(int id, Match m);

	List<Match> FindMatchs();

	Match FindMatch(int id);

}
