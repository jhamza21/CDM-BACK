package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.entities.Referee;
import com.example.repository.RefereeRepository;

@Service
public class RefereeService implements IRefereeService {
	@Autowired
	RefereeRepository mr;

	@Override
	public boolean SaveReferee(Referee m) {
		try {
			List<Referee> l = mr.findAll();
			for (Referee r : l)
				if (r.getName().equals(m.getName()))
					return false;
			mr.save(m);
			return true;
		}

		catch (Exception e) {
			return false;
		}
	}

	@Override
	public List<Referee> FindReferees() {
		try {
			return mr.findAll();
		} catch (Exception e) {
			return null;
		}
	}

	public Referee FindReferee(int id) {
		try {
			Referee m = mr.findById(id);
			return m;
		} catch (Exception e) {
			return null;
		}
	}

	public boolean UpdateReferee(int id, Referee nv) {
		try {
			Referee m = mr.findById(id);
			m.setAge(nv.getAge());
			m.setName(nv.getName());
			m.setNationality(nv.getNationality());
			// m.setMatch(nv.getMatch());
			mr.save(m);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public boolean DeleteReferee(int id) {
		try {
			Referee m = mr.findById(id);
			mr.delete(m);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public boolean DeleteAllReferees() {
		try {
			mr.deleteAll();
			return true;
		} catch (Exception e) {
			return false;
		}
	}

}