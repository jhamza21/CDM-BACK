package com.example.service;

import java.util.List;

import com.example.entities.Referee;

public interface IRefereeService {
	boolean SaveReferee(Referee m);

	boolean UpdateReferee(int id, Referee m);

	boolean DeleteReferee(int id);

	List<Referee> FindReferees();

	Referee FindReferee(int id);

	boolean DeleteAllReferees();

}
